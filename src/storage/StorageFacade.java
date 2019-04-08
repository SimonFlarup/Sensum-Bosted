/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import sensum_bosted.Diary;
import sensum_bosted.Notation;
import sensum_bosted.Patient;
import sensum_bosted.User;
import sensum_bosted.UserRoles;

/**
 *
 * @author Jonas
 */
public class StorageFacade implements StorageInterface {

    CRUDInterface CRUD = new CRUDFacade();

    @Override
    public Patient getPatient(UUID id) {
        HashMap<Enum, String> patientMap = CRUD.readFromKey(Tables.PATIENTS, id, null);
        HashMap<Enum, String> userMap = CRUD.readFromKey(Tables.USERS, id, null);
        // public Patient(String name, String username, String password, UserRoles field, String cpr)
        String name = patientMap.get(Fields.PatientFields.NAME);
        String username = userMap.get(Fields.UserFields.USERNAME);
        String password = userMap.get(Fields.UserFields.PASSWORD);
        UserRoles field = UserRoles.valueOf(userMap.get(Fields.UserFields.USERROLES));
        String cpr = patientMap.get(Fields.PatientFields.CPR);
        Patient patient = new Patient(name, username, password, field, cpr);
        return patient;
    }

    @Override
    public boolean setPatient(UUID id, Patient data) {

        /*Convert object to two hashmaps (Patient and User)
        **Make sure it's not already set for both (Do it for patient, then do it again for user)
        **If so
        **Use create with the hashmap
        **If not
        **Use update with the hashmap
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(UUID id) {
        //    public User(String name, String username, String password, UserRoles field) {
        HashMap<Enum, String> userMap = CRUD.readFromKey(Tables.USERS, id, null);
        String name = userMap.get(Fields.UserFields.NAME);
        String username = userMap.get(Fields.UserFields.USERNAME);
        String password = userMap.get(Fields.UserFields.PASSWORD);
        UserRoles field = UserRoles.valueOf(userMap.get(Fields.UserFields.USERROLES));
        User user = new User(name, username, password, field);
        return user;
    }

    @Override
    public boolean setUser(UUID id, User data) {
        /*Convert object to hashmap
        **Make sure it's not already set
        **If so
        **Use create with the hashmap
        **If not
        **Use update with the hashmap
         */

        HashMap<Enum, String> map = new HashMap<>();
        map.put(Fields.UserFields.NAME, data.getName());
        map.put(Fields.UserFields.PASSWORD, data.getPassword());
        map.put(Fields.UserFields.USERNAME, data.getUsername());
        map.put(Fields.UserFields.USERROLES, data.getField().toString());
        map.put(Fields.ID, data.getId().toString());

        if (CRUD.readFromKey(Tables.USERS, id, null) == null) {
            CRUD.create(Tables.USERS, map, null);
            return true;
        } else {
            CRUD.update(Tables.USERS, id, map, null);
            return true;
        }
    }

    @Override
    public Diary getDiary(UUID patientId) {
        //    public Notation(String content, Date date, Notation.Field field) {
        HashMap<Enum, String>[] array = CRUD.readAll(Tables.NOTATIONS, null);
        ArrayList<Notation> notations = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (patientId.toString().equals(array[i].get(Fields.NotationFields.PATIENTID))) {
                String content = array[i].get(Fields.NotationFields.CONTENT);
                String sDate = array[i].get(Fields.NotationFields.DATE);

                Date date;
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                } catch (ParseException ex) {
                    System.out.println("Parse expection while parsing to date");
                    return null;
                }

                Notation.Field field = Notation.Field.valueOf(array[i].get(Fields.NotationFields.FIELD));

                Notation notation = new Notation(content, date, field);
                notations.add(notation);
            }
        }
        Diary diary = new Diary(notations);

        return diary;
    }

    @Override
    public boolean setDiary(UUID id, Diary data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

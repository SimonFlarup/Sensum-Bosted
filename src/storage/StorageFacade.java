/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.HashMap;
import java.util.UUID;
import sensum_bosted.Diary;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Diary getDiary(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setDiary(UUID id, Diary data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

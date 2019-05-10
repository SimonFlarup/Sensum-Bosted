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
import java.util.Map;
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

    private static StorageFacade instance;

    private StorageFacade() {
    }

    public static StorageFacade getInstance() {
        if (instance == null) {
            instance = new StorageFacade();
        }
        return instance;
    }

    CRUDInterface CRUD = CRUDFacade.getInstance();

    @Override
    public Patient getPatient(UUID id) {
        HashMap<Enum, String> patientMap = CRUD.readFromKey(Tables.PATIENTS, id, null);
        HashMap<Enum, String> userMap = CRUD.readFromKey(Tables.USERS, id, null);
        // public Patient(String name, String username, String password, UserRoles field, String cpr)
        String name = userMap.get(Fields.UserFields.NAME);
        String username = userMap.get(Fields.UserFields.USERNAME);
        String password = userMap.get(Fields.UserFields.PASSWORD);
        UserRoles field = UserRoles.valueOf(userMap.get(Fields.UserFields.USERROLES));
        String cpr = patientMap.get(Fields.PatientFields.CPR);
        String info = patientMap.get(Fields.PatientFields.GENERAL_INFO);
        Patient patient = new Patient(name, username, password, field, cpr, info, id);
        return patient;
    }

    @Override
    public boolean setPatient(Patient data) {
        UUID id = data.getId();
        HashMap<Enum, String> userMap = new HashMap<>();
        userMap.put(Fields.UserFields.NAME, data.getName());
        userMap.put(Fields.UserFields.PASSWORD, data.getPassword());
        userMap.put(Fields.UserFields.USERNAME, data.getUsername());
        userMap.put(Fields.UserFields.USERROLES, data.getField().toString());
        userMap.put(Fields.ID, id.toString());

        if (CRUD.readFromKey(Tables.USERS, id, null) == null) {
            CRUD.create(Tables.USERS, userMap, null);
        } else {
            CRUD.update(Tables.USERS, id, userMap, null);
        }

        HashMap<Enum, String> patientMap = new HashMap<>();
        patientMap.put(Fields.PatientFields.CPR, data.getCpr());
        patientMap.put(Fields.PatientFields.GENERAL_INFO, data.getInfo());
        patientMap.put(Fields.ID, data.getId().toString());

        if (CRUD.readFromKey(Tables.PATIENTS, id, null) == null) {
            CRUD.create(Tables.PATIENTS, patientMap, null);
        } else {
            CRUD.update(Tables.PATIENTS, id, patientMap, null);
        }
        return true;
    }

    @Override
    public User getUser(UUID id) {
        //    public User(String name, String username, String password, UserRoles field) {
        HashMap<Enum, String> userMap = CRUD.readFromKey(Tables.USERS, id, null);
        String name = userMap.get(Fields.UserFields.NAME);
        String username = userMap.get(Fields.UserFields.USERNAME);
        String password = userMap.get(Fields.UserFields.PASSWORD);
        UserRoles field = UserRoles.valueOf(userMap.get(Fields.UserFields.USERROLES));
        HashMap<Enum, String>[] assignments = CRUD.readAll(Tables.ASSIGNMENTS, null);
        Map<UUID, String> map = new HashMap<>();
        for (HashMap<Enum, String> assignment : assignments) {
            if (assignment.get(Fields.AssignmentFields.USER_ID).equals(id.toString())) {
                String patientName = assignment.get(Fields.AssignmentFields.PATIENT_NAME);
                UUID patientId = UUID.fromString(assignment.get(Fields.AssignmentFields.PATIENT_ID));
                map.put(patientId, patientName);
            }
        }
        User user = new User(name, username, password, field, map, id);
        return user;
    }

    @Override
    public boolean setUser(User data) {
        UUID id = data.getId();
        HashMap<Enum, String> map = new HashMap<>();
        map.put(Fields.UserFields.NAME, data.getName());
        map.put(Fields.UserFields.PASSWORD, data.getPassword());
        map.put(Fields.UserFields.USERNAME, data.getUsername());
        map.put(Fields.UserFields.USERROLES, data.getField().toString());
        map.put(Fields.ID, id.toString());

        //if (CRUD.readFromKey(Tables.USERS, id, null) == null) {
            CRUD.create(Tables.USERS, map, null);
            return true;
        //} else {
         //   CRUD.update(Tables.USERS, id, map, null);
           // return true;
        //}
    }

    @Override
    public Diary getDiary(UUID patientId) {
        //    public Notation(String content, Date date, Notation.Field field) {
        HashMap<Enum, String>[] array = CRUD.readAll(Tables.NOTATIONS, null);
        ArrayList<Notation> notations = new ArrayList<>();
        for (HashMap<Enum, String> map : array) {
            if (patientId.toString().equals(map.get(Fields.NotationFields.PATIENTID))) {
                String content = map.get(Fields.NotationFields.CONTENT);
                String sDate = map.get(Fields.NotationFields.DATE);
                Date date;
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                } catch (ParseException ex) {
                    System.out.println("Parse expection while parsing to date");
                    return null;
                }
                Notation.Field field = Notation.Field.valueOf(map.get(Fields.NotationFields.FIELD));
                UUID id = UUID.fromString(map.get(Fields.ID));
                Notation notation = new Notation(content, date, field, id);
                notations.add(notation);
            }
        }
        Diary diary = new Diary(notations);

        return diary;
    }

    @Override
    public boolean setNotation(UUID patientId, Notation data) {
        UUID id = data.getId();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sDate = dateFormat.format(data.getDate());
        
        HashMap<Enum, String> map = new HashMap<>();
        map.put(Fields.NotationFields.CONTENT, data.getContent());
        map.put(Fields.NotationFields.DATE, sDate);
        map.put(Fields.NotationFields.FIELD, data.getField().toString());
        map.put(Fields.NotationFields.PATIENTID, patientId.toString());
        map.put(Fields.ID, id.toString());

        if (CRUD.readFromKey(Tables.NOTATIONS, id, null) == null) {
            CRUD.create(Tables.NOTATIONS, map, null);
            return true;
        } else {
            CRUD.update(Tables.NOTATIONS, id, map, null);
            return true;
        }
    }

    @Override
    public boolean setAssignment(UUID userId, UUID patientId) {
        String name = CRUD.readFromKey(Tables.USERS, patientId, null).get(Fields.UserFields.NAME);
        Map<Enum, String> map = new HashMap<>();
        map.put(Fields.AssignmentFields.PATIENT_ID, patientId.toString());
        map.put(Fields.AssignmentFields.PATIENT_NAME, name);
        map.put(Fields.AssignmentFields.USER_ID, userId.toString());
        map.put(Fields.ID, UUID.randomUUID().toString());
        System.out.println(patientId.toString() + " : " + userId.toString());
        CRUD.create(Tables.ASSIGNMENTS, map, null);
        return true;
    }
    
    public void purgeAll(){
        CRUDFacade CRUDInstance = (CRUDFacade) CRUD;
        CRUDInstance.purgeAll(Tables.USERS, null);
        CRUDInstance.purgeAll(Tables.ASSIGNMENTS, null);
        CRUDInstance.purgeAll(Tables.PATIENTS, null);
        CRUDInstance.purgeAll(Tables.NOTATIONS, null);
    }

}

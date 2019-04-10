/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import sensum_bosted.Notation;
import sensum_bosted.Patient;
import sensum_bosted.User;
import sensum_bosted.UserRoles;

/**
 *
 * @author Simon Holland Flarup
 */
public class TEST {

    public static void main(String[] args) throws Exception {
        //public Patient(String name, String username, String password, UserRoles field, String cpr, String info, UUID id) {
        String name = "Jonas";
        String username = "jona";
        String password = "xxx";
        String cpr = "291298-xxxx";
        String info = "It's a boy! Maybe";
        UserRoles field = UserRoles.PATIENT_BOTH;
        UUID id = UUID.randomUUID();
        Patient p1 = new Patient(name, username, password, field, cpr, info, id);
        name = "Marie";
        username = "Mari";
        password = "xxx";
        cpr = "010101-xxxx";
        info = "It's a girl! Maybe";
        field = UserRoles.PATIENT_BOTH;
        id = UUID.randomUUID();
        Patient p2 = new Patient(name, username, password, field, cpr, info, id);
        
        //public User(String name, String username, String password, UserRoles field, Map<UUID, String> patients, UUID id) {
        name = "Erik";
        username = "erso";
        password = "xxx";
        field = UserRoles.CARETAKER_BOTH;
        HashMap<UUID, String> map = new HashMap<>();
        id = UUID.fromString("dfc0a570-df86-42ba-920a-fd13619edef5");
        map.put(p1.getId(), p1.getName());
        map.put(p2.getId(), p2.getName());
        User user = new User(name, username, password, field, map, id);
        StorageInterface storage = StorageFacade.getInstance();
        
        StorageFacade storageFacade = (StorageFacade) storage;
        storageFacade.purgeAll();
        
        storage.setUser(user);
        storage.setPatient(p1);
        storage.setPatient(p2);
        storage.setAssignment(id, p1.getId());
        storage.setAssignment(id, p2.getId());
        
        /*Date date = new Date();
        System.out.println("Date.Tostring(): " + date.toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sDate = dateFormat.format(date);
        System.out.println("dateFormat.format(date): " + sDate);
        date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        System.out.println(date.toString());*/
        //public Notation(String content, Date date, Notation.Field field, UUID id) {
        String content = "Patienten opfører sig som forventet. Bla bla.\nMultiline test\n\nDone!";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("09/04/2019");
        Notation.Field nField = Notation.Field.DISABLED;
        id = UUID.randomUUID();
        Notation notat1 = new Notation(content, date, nField, id);
        
        content = "Patienten opfører sig overhovedet ikke som forventet. Bla bla.\nMultiline test\n\nDone!";
        date = new Date();
        nField = Notation.Field.DISABLED;
        id = UUID.randomUUID();
        Notation notat2 = new Notation(content, date, nField, id);
        id = UUID.randomUUID();
        Notation notat3 = new Notation(content, date, nField, id);
        
        storage.setNotation(p1.getId(), notat1);
        storage.setNotation(p1.getId(), notat2);
        storage.setNotation(p2.getId(), notat3);
        /*Map<Enum, String> map;
        map = new HashMap<>();
        UUID id = UUID.randomUUID();
        map.put(Fields.PatientFields.NAME, "Ida-Marie");
        map.put(Fields.PatientFields.CPR, "030598-xxxx");
        map.put(Fields.ID, id.toString());
        map.put(Fields.PatientFields.FIELDS, "DRUGS");
        CRUDFacade CRUD = new CRUDFacade();
        CRUD.create(Tables.PATIENTS, map, null);
        map = new HashMap<>();
        map.put(Fields.PatientFields.NAME, "Ida-Marie123");
        map.put(Fields.PatientFields.FIELDS, "DISABLED");
        CRUD.update(Tables.PATIENTS, id, map, null);
        
        map = new HashMap<>();
        UUID id2 = UUID.randomUUID();
        map.put(Fields.PatientFields.NAME, "Luckas");
        map.put(Fields.PatientFields.CPR, "260699-xxxx");
        map.put(Fields.ID, id2.toString());
        map.put(Fields.PatientFields.FIELDS, "DISABLED");
        CRUD.create(Tables.PATIENTS, map, null);

        map = CRUD.readFromKey(Tables.PATIENTS, id, null);

        for (Map.Entry<Enum, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey().toString() + ", Value = " + entry.getValue());
        }

        HashMap<Enum, String>[] array = CRUD.readAll(Tables.PATIENTS, null);
        for (HashMap<Enum, String> singleMap : array) {
            for (Map.Entry<Enum, String> entry : singleMap.entrySet()) {
                System.out.println("Key = " + entry.getKey().toString() + ", Value = " + entry.getValue());
            }
        }*/
    }
}

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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Simon Holland Flarup
 */
public class TEST {

    public static void main(String[] args) throws Exception {
        Map<Enum, String> map;
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
        }
    }
}

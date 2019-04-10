/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import sensum_bosted.User;

/**
 *
 * @author Simon Holland Flarup
 */
public class CRUDFacade implements CRUDInterface {

    private static CRUDFacade instance;

    private CRUDFacade() {
    }

    public static CRUDFacade getInstance() {
        if (instance == null) {
            instance = new CRUDFacade();
        }
        return instance;
    }

    private boolean isUUID(String s) {
        try {
            UUID.fromString(s); //Throws IllegalArgumentException if not a string representation of a UUID
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (NullPointerException ex) {
            return false;
        }
    }

    private void createDir(Tables table) {
        File dir = new File(table.getPath());
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    @Override
    public void create(Tables table, Map<Enum, String> data, User user) {
        if (!isUUID(data.get(Fields.ID))) {
            System.out.println("Invalid UUID");
            return;
        }
        createDir(table);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(table.getPath() + data.get(Fields.ID) + ".sbdf"))) {
            out.writeObject(data);
            out.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    @Override
    public HashMap<Enum, String> readFromKey(Tables table, UUID primaryKey, User user) { //UUID is, in filebased storage, the file name (Primary key)
        HashMap<Enum, String> map;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(table.getPath() + primaryKey + ".sbdf"))) {
            map = (HashMap) in.readObject();
            return map;
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassCastExpection");
        }
        return null;
    }

    public HashMap<Enum, String>[] readAll(Tables table, User user) {
        ArrayList<HashMap<Enum, String>> returnArray = new ArrayList<>();
        HashMap<Enum, String> map;

        File[] files = new File(table.getPath()).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".sbdf");
            }
        });

        for (File file : files) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                map = (HashMap) in.readObject();
                returnArray.add(map);
                System.out.println("Read file: " + file.getName());
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            } catch (IOException ex) {
                System.out.println("IOException");
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassCastExpection");
            }
        }
        if (returnArray.isEmpty()) {
            return null;
        }
        return returnArray.toArray(new HashMap[returnArray.size()]);
    }

    @Override
    public void update(Tables table, UUID primaryKey, Map<Enum, String> data, User user) {
        HashMap<Enum, String> currentData = readFromKey(table, primaryKey, user);
        currentData.putAll(data);
        if (primaryKey != null) {
            currentData.put(Fields.ID, primaryKey.toString());
        } else if (!isUUID(data.get(Fields.ID))) {
            System.out.println("Invalid UUID");
            return;
        }
        create(table, currentData, user);
    }

    public void purgeAll(Tables table, User user) {
        File[] files = new File(table.getPath()).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".sbdf");
            }
        });

        for (File file : files) {
            file.delete();
        }
    }

}

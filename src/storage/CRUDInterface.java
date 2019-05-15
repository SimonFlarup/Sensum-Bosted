/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import sensum_bosted.User;

/**
 *
 * @author Simon Holland Flarup
 */
public interface CRUDInterface {

    //Create (C)
    public void create(Tables table, Map<Enum, String> data, User user);

    //Read (R)
    public HashMap<Enum, String>[] readFromKey(Tables table, String[] primaryKey, User user);

    //Update (U)
    public void update(Tables table, String[] primaryKey, Map<Enum, String> data, User user);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;


import java.util.HashMap;
import java.util.Map;
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

    private String quoteValues(String string) {
        return "'" + string + "'";
    }

    private String doubleQuoteValues(String string) {
        return "\"" + string + "\"";
    }

    private String conditionFromKeys(Tables table, String[] primaryKey) {
        String condition = "";
        switch (table) {
            case ASSIGNMENTS:
                if (primaryKey.length == 2) {
                    condition = (doubleQuoteValues(Fields.AssignmentFields.USER_ID.toString().toLowerCase())
                            + " = " + quoteValues(primaryKey[0])
                            + " AND "
                            + doubleQuoteValues(Fields.AssignmentFields.PATIENT_ID.toString().toLowerCase())
                            + " = "
                            + quoteValues(primaryKey[1]));
                } else {
                    condition = (doubleQuoteValues(Fields.AssignmentFields.USER_ID.toString().toLowerCase())
                            + " = " + quoteValues(primaryKey[0]));
                }
                break;
            case NOTATIONS:
                if (primaryKey.length == 2) {
                    condition = (doubleQuoteValues(Fields.NotationFields.DATE.toString().toLowerCase())
                            + " = " + quoteValues(primaryKey[0])
                            + " AND "
                            + doubleQuoteValues(Fields.NotationFields.PATIENT_ID.toString().toLowerCase())
                            + " = "
                            + quoteValues(primaryKey[1]));
                } else {
                    condition = (doubleQuoteValues(Fields.NotationFields.PATIENT_ID.toString().toLowerCase())
                            + " = " + quoteValues(primaryKey[0]));
                }

                break;
            case PATIENTS:
                condition = (doubleQuoteValues(Fields.PatientFields.CPR.toString().toLowerCase())
                        + " = " + quoteValues(primaryKey[0]));
                break;
            case USERS:
                condition = (doubleQuoteValues(Fields.UserFields.USERNAME.toString().toLowerCase())
                        + " = " + quoteValues(primaryKey[0]));
                break;
            default:
                break;
        }
        return condition;
    }

    @Override
    public void create(Tables table, Map<Enum, String> data, User user) {
        String values = "";
        switch (table) {
            case ASSIGNMENTS:
                values = ("" + quoteValues(data.get(Fields.AssignmentFields.PATIENT_ID)) + "," + quoteValues(data.get(Fields.AssignmentFields.USER_ID)));
                break;
            case NOTATIONS:
                values = ("'" + data.get(Fields.NotationFields.DATE) + "'," + quoteValues(data.get(Fields.NotationFields.CONTENT)) + "," + quoteValues(data.get(Fields.NotationFields.FIELD)) + "," + quoteValues(data.get(Fields.NotationFields.PATIENT_ID)) + "," + quoteValues(data.get(Fields.NotationFields.LAST_USER)) + "," + quoteValues(data.get(Fields.NotationFields.TIME_STAMP)));
                break;
            case PATIENTS:
                values = ("" + quoteValues(data.get(Fields.PatientFields.CPR)) + "," + quoteValues(data.get(Fields.PatientFields.INFO)));
                break;
            case USERS:
                values = ("" + quoteValues(data.get(Fields.UserFields.USERNAME)) + ", " + quoteValues(data.get(Fields.UserFields.PASSWORD)) + ", " + quoteValues(data.get(Fields.UserFields.NAME)) + ", " + quoteValues(data.get(Fields.UserFields.USERROLES)) + "");
                break;
            default:
                break;
        }

        CRUD.getInstance().create(table.getTableName(), values);

    }

    @Override
    public HashMap<Enum, String>[] readFromKey(Tables table, String[] primaryKey, User user) {
        HashMap<Enum, String>[] map;
        String condition = this.conditionFromKeys(table, primaryKey);

        map = CRUD.getInstance().read(table.getTableName(), condition);
        return map;
    }

    private String valueCreation(String values, Enum field, String data) {
        if (!values.isEmpty()) {
            values += ", ";
        }
        values += doubleQuoteValues(field.toString().toLowerCase()) + " = " + quoteValues(data);
        return values;
    }

    @Override
    public void update(Tables table, String[] primaryKey, Map<Enum, String> data, User user) {
        HashMap<Enum, String> currentData = readFromKey(table, primaryKey, user)[0];
        currentData.putAll(data);

        String condition = this.conditionFromKeys(table, primaryKey);

        String values = "";
        switch (table) {
            case ASSIGNMENTS:
                for (Enum field : Fields.AssignmentFields.values()) {
                    values = valueCreation(values, field, currentData.get(field));
                }
                break;
            case NOTATIONS:
                for (Enum field : Fields.NotationFields.values()) {
                    values = valueCreation(values, field, currentData.get(field));
                }
                break;
            case PATIENTS:
                for (Enum field : Fields.PatientFields.values()) {
                    values = valueCreation(values, field, currentData.get(field));
                }
                break;
            case USERS:
                for (Enum field : Fields.UserFields.values()) {
                    values = valueCreation(values, field, currentData.get(field));
                }
                break;
            default:
                break;
        }

        CRUD.getInstance().update(table.getTableName(), values, condition);
    }
}

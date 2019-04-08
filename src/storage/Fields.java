/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author Simon Holland Flarup
 */
public enum Fields {
    ID;

    public static enum DiaryFields {
        PATIENT,
        DATE,
        DRUG_ENTRY,
        DISABLED_ENTRY;
    }

    public enum PatientFields {
        NAME,
        CPR,
        GENERAL_INFO;
    }

    public enum UserFields {
        USERROLES,
        USERNAME,
        PASSWORD,
        NAME;
    }
    
    public enum AssignmentFields {
        PATIENT_ID,
        USER_ID,
        PATIENT_NAME; //Redundant information introduced to save implementing a psudo join.
    }
}

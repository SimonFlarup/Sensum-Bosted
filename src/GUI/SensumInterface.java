/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author KV
 */
public interface SensumInterface {

//    /**
//     *
//     * @param userName String with user name.
//     * @param password String with password.
//     * @return true if correct.
//     */
//    boolean login(String userName, String password);
    
//    /**
//     *
//     * @return true if the user is logged out.
//     */
//    boolean logout();
    
//    /**
//     *
//     * @param userName String with user name.
//     * @param password String with password.
//     * @return true if the user was created.
//     */
//    boolean createUser(String userName, String password);
    
    /**
     *
     * @return String with the users name.
     */
    String getUserName();

    /**
     *
     * @return Map containing UUIDs of all patients along with the associated
     * names.
     */
    Map<UUID, String> getPatientsMap();

    /**
     *
     * @param patientId the UUID associated with the patient.
     */
    void initializePatient(UUID patientId);

    /**
     *
     * @return String with the patients name.
     */
    String getPatientName();

    /**
     *
     * @return String with patients CPR.
     */
    String getPatientCPR();

    /**
     *
     * @return String with path to patient image.
     */
    String getPatientImage();

    /**
     *
     * @return String with the general information about the patient.
     */
    String getPatientInfo();
    
    /**
     * 
     * @param name String with name of the patient.
     * @param cpr String with CPR of the patient.
     * @param info String with general info about the patient.
     * @return true if the patient was created.
     */
    boolean createPatient(String name, String cpr, String info);

    /**
     *
     * @return Map containing dates of all diaries along with the associated id.
     */
    Map<Date, UUID> getNotationsMap();

    void initializeDiary();

    /**
     *
     * @param notationId the UUID associated with the notation you want to
     * initialize.
     */
    void initializeNotation(UUID notationId);
    
    /**
     *
     * @return String with the content for the currently initialized notation.
     */
    String getNotation();
    
    /**
     * 
     * @return the date associated with the notation.
     */
    Date getNotationDate();
    
    /**
     *
     * @param content String with the content to be saved.
     * @return true if the notation was saved successfully.
     */
    boolean saveNotation(String content);
    
    /**
     * 
     * @return true if the notation is created.
     */
    UUID createNotation();
    
    /**
     *
     * @return map containing Date and String array with user who made the 
     * notation/edit on [0] and notation content on [1].
     */
    //Map<Date, String[]> notationLog();

    /**
     *
     * @param notationId id of notation to be locked.
     * @return true if the notation is locked successfully.
     */
    //boolean lockNotation();
    
    /**
     *
     * @param notationId id of notation to be unlocked.
     * @return true if the notation is unlocked successfully.
     */
    //boolean unlockNotation();
}

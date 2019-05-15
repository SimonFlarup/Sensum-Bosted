/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author KV
 */
public interface SensumInterface {

    /**
     *
     * @param userName String with user name.
     * @param password String with password.
     * @return true if correct.
     */
    boolean login(String userName, String password);
    
    /**
     *
     * @return true if the user is logged out.
     */
    boolean logout();
    
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
    public Map<String, String> getPatientsMap();

    /**
     *
     * @param cpr the cpr associated with the patient.
     */
    public void initializePatient(String cpr);

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
    public List<LocalDate> getNotationsList();

    void initializeDiary();

    /**
     *
     * @param date the date associated with the notation you want to
     * initialize.
     * @return 
     */
    public boolean initializeNotation(LocalDate date);
    
    /**
     *
     * @return String with the content for the currently initialized notation.
     */
    String getNotation();
    
    /**
     * 
     * @return the date associated with the notation.
     */
    public LocalDate getNotationDate();
    
    /**
     *
     * @param content String with the content to be saved.
     * @return true if the notation was saved successfully.
     */
    boolean saveNotation(String content);
    
    /**
     * 
     * @param date
     * @return true if the notation is created.
     */
    public LocalDate createNotation(LocalDate date);
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

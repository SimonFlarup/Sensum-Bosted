/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    
    /**
     *
     * @return true if the user is privileged.
     */
    boolean isPrivileged();
    
    /**
     *
     * @param userName String with user name.
     * @param password String with password.
     * @param field String with the field associated with the user.
     * @param name String with the users name.
     * @return true if the user was created.
     */
    boolean createUser(String userName, String password, String field, String name);
    
    /**
     *
     * @return String with the users name.
     */
    String getUserName();

    /**
     *
     * @return Map containing CPR of all patients along with the associated
     * name.
     */
    public Map<String, String> getPatientsMap();

    /**
     *
     * @param cpr the CPR associated with the patient.
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
     * @return List containing dates of all notations.
     */
    public List<LocalDate> getNotationsList();

    void initializeDiary();

    /**
     *
     * @param date the date associated with the notation you want to
     * initialize.
     * @return true if successful.
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
     * @param date creation date for the notation.
     * @return date for the created notation.
     */
    public LocalDate createNotation(LocalDate date);
    
    /**
     *
     * @return a Map containing the timestamps of all versions of the notation along with a String[] that has username on index 0 and content on index 1.
     */
    public Map<LocalDateTime,String[]> getNotationHistory();
    
    /**
     *
     * @return true if the notation is locked successfully.
     */
    //boolean lockNotation();
    
    /**
     *
     * @return true if the notation is unlocked successfully.
     */
    //boolean unlockNotation();
}

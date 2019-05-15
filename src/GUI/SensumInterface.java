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
     * @return String with the users name.
     */
    public String getUserName();

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
    public String getPatientName();

    /**
     *
     * @return String with patients CPR.
     */
    public String getPatientCPR();

    /**
     *
     * @return String with path to patient image.
     */
    public String getPatientImage();

    /**
     *
     * @return String with the general information about the patient.
     */
    public String getPatientInfo();
    
    /**
     * 
     * @param name String with name of the patient.
     * @param cpr String with CPR of the patient.
     * @param info String with general info about the patient.
     * @return true if the patient was created.
     */
    public boolean createPatient(String name, String cpr, String info);

    /**
     *
     * @return Map containing dates of all diaries along with the associated id.
     */
    public List<LocalDate> getNotationsList();

    public void initializeDiary();

    /**
     *
     * @param date the date associated with the notation you want to
     * initialize.
     */
    public void initializeNotation(LocalDate date);
    
    /**
     *
     * @return String with the content for the currently initialized notation.
     */
    public String getNotation();
    
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
    public boolean saveNotation(String content);
    
    /**
     * 
     * @return true if the notation is created.
     */
    public LocalDate createNotation();

    /**
     *
     * @param notationId id of notation to be locked.
     * @return true if the notation is locked successfully.
     */
    //public boolean lockNotation();
    
    /**
     *
     * @param notationId id of notation to be unlocked.
     * @return true if the notation is unlocked successfully.
     */
    //public boolean unlockNotation();
}

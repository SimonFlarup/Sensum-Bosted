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
    public Map<UUID, String> getPatientsMap();

    /**
     *
     * @param patientId the UUID associated with the patient.
     */
    public void initializePatient(UUID patientId);

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
    public Map<Date, UUID> getNotationsMap();

    public void initializeDiary();

    /**
     *
     * @param notationId the UUID associated with the notation you want to
     * initialize.
     */
    public void initializeNotation(UUID notationId);
    
    /**
     *
     * @return String with the content for the currently initialized notation.
     */
    public String getNotation();
    
    /**
     * 
     * @return the date associated with the notation.
     */
    public Date getNotationDate();
    
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
    public boolean createNotation();

    /**
     *
     * @param diaryId id of diary to be locked.
     * @return true if the diary is locked successfully.
     */
    //public boolean lockDiary(UUID diaryId);
    /**
     *
     * @param diaryId id of diary to be unlocked.
     * @return true if the diary is unlocked successfully.
     */
    //public boolean unlockDiary(UUID diaryId);
}

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
     * @param patientId
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
     * @return Map containing dates of all diaries along with the associated id.
     */
    public Map<Date, UUID> getNotationsMap();

    public void initializeDiary();

    /**
     *
     * @return Map with Enum as key along with the entries for the diary.
     */
    public String getNotation();
    
        /**
     *
     * @param notationId id of the notation you want to initialize.
     */
    public void initializeNotation(UUID notationId);

    /**
     *
     * @param diaryId id of diary to be locked.
     * @return true if the diary is locked successfully.
     */
    //public boolean lockDiary(UUID diaryId);
    
    /**
     *
     * @param diaryId id of the diary where data is saved.
     * @param data Map with enum as key and a String with the data to be saved.
     * @return true if the diary was saved successfully.
     */
    //public boolean saveDiary(UUID diaryId, Map<Enum, String> data);

    /**
     *
     * @param diaryId id of diary to be unlocked.
     * @return true if the diary is unlocked successfully.
     */
    //public boolean unlockDiary(UUID diaryId);
}

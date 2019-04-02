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
     * @return Map containing Enum as key along with the associated user description.
     */
    public Map<Enum, String> getUserData();
    
    /**
     * 
     * @return Map containing UUIDs of all patients along with the associated names.
     */
    public Map<UUID, String> getPatientsMap();
    
    /**
     * 
     * @param patientId id of patient from which the data is acquired.
     * @return Map with Enum as key along with the associated patient data.
     */
    public Map<Enum, String> getPatientsData(UUID patientId);
    
    /**
     * 
     * @param patientId id of patient from which the diaries are acquired.
     * @return Map containing dates of all diaries along with the associated id.
     */
    public Map<Date, UUID> getDiariesMap(UUID patientId);
    
     /**
     * 
     * @param diaryId id of the diary from wich the entries are acquired.
     * @return Map with Enum as key along with the entries.
     */
    public Map<Enum, String> getDiaryEntries(UUID diaryId);
    
    /**
     * 
     * @param diaryId id of diary to be locked.
     * @return true if the diary is locked successfully.
     */
    public boolean lockDiary(UUID diaryId);
    
    /**
     * 
     * @param diaryId id of the diary where data is saved.
     * @param data 
     * @return true if the diary was saved successfully.
     */
    public boolean saveDiary(UUID diaryId, Map<Enum, String> data);
    
    /**
     * 
     * @param diaryId id of diary to be unlocked.
     * @return true if the diary is unlocked successfully.
     */
    public boolean unlockDiary(UUID diaryId);
    
    /**
     * 
     * @param patientId id of patient the diary belongs to.
     * @return id of the diary.
     */
    public UUID createDiary(UUID patientId);
    
}

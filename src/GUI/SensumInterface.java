/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import javafx.scene.image.Image;

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
     * @return a map with Enum as key along with the associated patient data.
     */
    public Map<Enum, String> getPatientsData(UUID patientId);
    
    /**
     * 
     * @param patientId id of patient from which the diaries are acquired.
     * @return Map containing dates of all diaries along with the associated id.
     */
    public Map<Date, UUID> getDiariesMap(UUID patientId);
    
    public Map<Enum, String> getDiaryEntries(UUID diaryId);
    
    public boolean lockDiary(UUID diaryId);
    
    public boolean saveDiary(UUID diaryId, Map<Enum, String> data);
    
    public boolean unlockDiary(UUID diaryId);
    
    /**
     * 
     * @param patientId id of patient the diary belongs to.
     * @return id of the diary.
     */
    public UUID createDiary(UUID patientId);
    
}

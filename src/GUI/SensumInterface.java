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
     * @return Map containing UUIDs of all patients along with the associated names
     */
    public Map<UUID, String> getPatientMap();
    
    /**
     * 
     * @param patientId id of patient from which the diaries are acquired
     * @return Map containing dates of all diaries along with the associated description (i.e. notes)
     */
    public Map<Date, String> getDiaryMap(UUID patientId);
    
    /**
     * 
     * @param patientId id of patient from which the civil registration number is acquired
     * @return String containing the CPR-number
     */
    public String getCpr(UUID patientId);
    
    /**
     * 
     * @param patientId id of patient from which the image is acquired
     * @return image of the patient
     */
    public Image getPatientImage(UUID patientId);
    
    /**
     * 
     * @param patientId id of patient from which the info is acquired
     * @return String containing patient info
     */
    public String getPatientInfo(UUID patientId);
    
    /**
     * 
     * @param patientID id of patient the diary belongs to
     * @param date date associated with the diary
     * @return true if the save was successful
     */
    public Boolean saveDiary(UUID patientID, Date date);
    
    /**
     * 
     * @param patientID id of patient the diary belongs to
     * @return the current date
     */
    public Date createDiary(UUID patientID);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import GUI.SensumInterface;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import storage.StorageFacade;
import storage.StorageInterface;

/**
 *
 * @author jakob
 */
public class DomainFacade implements SensumInterface {

    private User user;
    private Patient patient;
    private Diary diary;
    private StorageInterface sf = new StorageFacade();

    public DomainFacade() {
        user = sf.getUser(UUID.fromString("dfc0a570-df86-42ba-920a-fd13619edef5"));

    }

    public static void main(String[] args) {

    }

    @Override
    public String getUserName() {
        return user.getName();
    }

    @Override
    public Map<UUID, String> getPatientsMap() {
        Map<UUID, String> patientsMap = null;
        
        List<Patient> temp = user.getPatients();
        for (Patient p : temp) {
            patientsMap.put(p.getId(), p.getName());
        }
        return patientsMap;
    }

    @Override
    public void initializePatient(UUID patientId) {
        patient = sf.getPatient(patientId);
    }

    @Override
    public String getPatientName() {
        return patient.getName();

    }

    @Override
    public String getPatientCPR() {
        return patient.getCpr();
    }

    @Override
    public String getPatientImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPatientInfo() {
        return patient.getInfo();
    }

    @Override
    public Map<Date, UUID> getNotationsMap() {
        Map<Date, UUID> notationsMap = null;
        List<Notation> temp = diary.getNotations();
        for (Notation n : temp) {
            notationsMap.put(n.getDate(), n.getId());
        }
        return notationsMap;
    }

    @Override
    public void initializeDiary() {
        diary = sf.getDiary(patient.getId());
    }

    @Override
    public String getNotation(UUID notationId) {
        List<Notation> temp = diary.getNotations();
        String finalValue = "This entry does not exist.";
        for (Notation not : temp) {

            if (notationId == not.getId()) {
                finalValue = not.toString();
            }
        }
        return finalValue;
    }

}

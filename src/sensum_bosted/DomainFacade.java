/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import GUI.SensumInterface;
import java.util.Date;
import java.util.HashMap;
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

    private static DomainFacade instance;

    private DomainFacade() {
        user = sf.getUser(UUID.fromString("dfc0a570-df86-42ba-920a-fd13619edef5"));
    }

    public static DomainFacade getInstance() {
        if (instance == null) {
            instance = new DomainFacade();
        }
        return instance;
    }

    private User user;
    private Patient patient;
    private Diary diary;
    private Notation notation;
    private StorageInterface sf = StorageFacade.getInstance();

    public static void main(String[] args) {

    }

    @Override
    public String getUserName() {
        return user.getName();
    }

    @Override
    public Map<UUID, String> getPatientsMap() {
        return user.getPatients();
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
    public boolean createPatient(String name, String cpr, String info) {
        //public Patient(String name, String username, String password, UserRoles field, String cpr, String info, UUID id) {
        this.patient = new Patient(name, name + "_user", "test1234", UserRoles.PATIENT, cpr, info, UUID.randomUUID());
        sf.setPatient(this.patient);
        sf.setAssignment(this.user.getId(), this.patient.getId());
        this.user = sf.getUser(this.user.getId());
        return true;
    }

    @Override
    public Map<Date, UUID> getNotationsMap() {
        Map<Date, UUID> notationsMap = new HashMap<>();
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
    public void initializeNotation(UUID notationId) {
        List<Notation> temp = diary.getNotations();
        for (Notation notat : temp) {
            if (notationId.toString().equals(notat.getId().toString())) {
                this.notation = notat;
                return;
            }
        }
    }

    @Override
    public String getNotation() {
        System.out.println(this.notation.getContent());
        return this.notation.getContent();
    }

    @Override
    public boolean saveNotation(String content) {
        notation.setContent(content);
        return sf.setNotation(patient.getId(), notation);
    }

    @Override
    public UUID createNotation() {
        
        UUID patientId = this.patient.getId();

        if (this.patient.getField() == UserRoles.PATIENT) {
            this.notation = new Notation("", new Date(), Notation.Field.DISABLED, UUID.randomUUID());
        } else {
            this.notation = new Notation("", new Date(), Notation.Field.DRUG, UUID.randomUUID());
        }
        sf.setNotation(patientId, this.notation);
        initializeDiary();
        return this.notation.getId();
    }

    @Override
    public Date getNotationDate() {
        return this.notation.getDate();
    }

}

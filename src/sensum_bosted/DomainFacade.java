/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import GUI.SensumInterface;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private String userName = "erik";

    private DomainFacade() {
        user = sf.getUser("erik");
        this.userName = userName;
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
        PasswordHashing hashing = new PasswordHashing();
        String password = hashing.hash("VOP");
        System.out.println(password);
        byte[] salt = PasswordHashing.extractSalt(password);
        hashing = new PasswordHashing(salt);
        System.out.println(hashing.compare("VOP", password));
    }

    @Override
    public String getUserName() {
        return user.getName();
    }

    @Override
    public Map<String, String> getPatientsMap() {
        Map<String, String> patientMap = new HashMap<>();
        for (String s : user.getPatients()){
            patientMap.put(s, sf.getPatient(s).getName());
        }
        return patientMap;
    }

    @Override
    public void initializePatient(String cpr) {
        patient = sf.getPatient(cpr);
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
        this.patient = new Patient(name, "test1234", UserRoles.PATIENT, cpr, info);
        sf.setPatient(this.patient);
        sf.setAssignment(this.user, this.patient);
        this.user = sf.getUser(this.user.getUsername());
        return true;
    }

    @Override
    public List<LocalDate> getNotationsList() {
        List<LocalDate> notationsList = new ArrayList<>();
        List<Notation> temp = diary.getNotations();
        for (Notation n : temp) {
            notationsList.add(n.getDate());
        }
        return notationsList;
    }

    @Override
    public void initializeDiary() {
        diary = sf.getDiary(patient);
    }

    @Override
    public void initializeNotation(LocalDate date) {
        List<Notation> temp = diary.getNotations();
        for (Notation notat : temp) {
            if (notat.getDate() == date) {
                this.notation = notat;
                return;
            }
        }
    }

    @Override
    public String getNotation() {
        return this.notation.getContent();
    }

    @Override
    public boolean saveNotation(String content) {
        notation.setContent(content, user.getUsername());
        return sf.setNotation(patient, notation);
    }

    @Override
    public LocalDate createNotation() {
        if (this.patient.getField() == UserRoles.PATIENT) {
            this.notation = new Notation("", LocalDate.now(), Notation.Field.DISABLED, user.getUsername());
        } else {
            this.notation = new Notation("", LocalDate.now(), Notation.Field.DRUG, user.getUsername());
        }
        sf.setNotation(patient, this.notation);
        initializeDiary();
        return this.notation.getDate();
    }

    @Override
    public LocalDate getNotationDate() {
        return this.notation.getDate();
    }

    /**
     * sf.getUser(lol)
     *
     * @param userName String with user name.
     * @param password String with password.
     * @return true if correct.
     */
    @Override
    public boolean login(String userName, String password) {
        user = sf.getUser(UUID.fromString(userName)); //PLACEHOLDER

        System.out.println(user.getPassword());
        PasswordHashing pw = new PasswordHashing(PasswordHashing.extractSalt(user.getPassword()));
        String pwH = pw.hash(password);
        if (pwH.equals(user.getPassword())) {
            System.out.println(pwH);
            return true;
        } else {
            user = null;
            pwH = null;
            return false;
            
        }
    }

    /**
     *
     * @return true if the user is logged out.
     */
    @Override
    public boolean logout() {
        return true;
    }

}

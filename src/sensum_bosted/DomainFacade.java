/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import GUI.SensumInterface;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import storage.StorageFacade;
import storage.StorageInterface;

/**
 *
 * @author jakob
 */
public class DomainFacade implements SensumInterface {

    private static DomainFacade instance;

    private DomainFacade() {
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
    private Diary historyDiary;
    private Notation notation;
    private StorageInterface sf = StorageFacade.getInstance();


    @Override
    public String getUserName() {
        return user.getName();
    }

    @Override
    public Map<String, String> getPatientsMap() {
        Map<String, String> patientMap = new HashMap<>();
        for (String s : user.getPatients()) {
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
        String password = new PasswordHashing().hash("test1234");
        this.patient = new Patient(name, password, UserRoles.PATIENT, cpr, info);
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
    public boolean initializeNotation(LocalDate date) {
        List<Notation> temp = diary.getNotations();
        for (Notation notat : temp) {
            if (notat.getDate().equals(date)) {
                this.notation = notat;
                return true;
            }
        }
        return false;
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
    public LocalDate createNotation(LocalDate date) {
        initializeDiary();
        if (!(initializeNotation(LocalDate.now()))) {
            System.out.println((initializeNotation(LocalDate.now())));
            if (this.patient.getField() == UserRoles.PATIENT) {
                this.notation = new Notation("", date, Notation.Field.DISABLED, user.getUsername());
            } else {
                this.notation = new Notation("", date, Notation.Field.DRUG, user.getUsername());
            }
            sf.setNotation(patient, this.notation);
            initializeDiary();

        }
        return this.notation.getDate();
    }

    @Override
    public LocalDate getNotationDate() {
        return this.notation.getDate();
    }

    /**
     * @param userName String with user name.
     * @param password String with password.
     * @return true if correct.
     */
    @Override
    public boolean login(String userName, String password) {
        if (userName.length() < 1 | password.length() < 1) {
            return false;
        }
        user = sf.getUser(userName);
        if (user == null) {
            return false;
        }

        sensum_bosted.PrintHandler.println(user.getPassword());

        PasswordHashing pw = new PasswordHashing(PasswordHashing.extractSalt(user.getPassword()));
        String pwH = pw.hash(password);
        if (pwH.equals(user.getPassword())) {
            sensum_bosted.PrintHandler.println(pwH);
            return true;
        } else {
            user = null;
            return false;

        }
    }

    /**
     *
     * @return true if the user is logged out.
     */
    @Override
    public boolean logout() {
        user = null;
        return true;
    }

    @Override
    public boolean isPrivileged() {
        return user.getField() == UserRoles.PRIVILEGED;
    }

    @Override
    public boolean createUser(String userName, String password, String field, String name) {
        password = new PasswordHashing().hash(password);
        User user = new User(name, userName, password, UserRoles.valueOf(field), new ArrayList<>());
        sf.setUser(user);
        return true;
    }

    @Override
    public String getLastUser() {
        return notation.getLastUser();
    }

    @Override
    public List<LocalDateTime> getNotationsHistoryList() {
        historyDiary = sf.getDiaryHistory(patient, notation.getDate());
        
        List<LocalDateTime> notationsList = new ArrayList<>();
        List<Notation> temp = historyDiary.getNotations();
        for (Notation n : temp) {
            notationsList.add(n.getTimestamp());
        }
        return notationsList;
    }

    @Override
    public boolean initializeNotationHistory(LocalDateTime timestamp) {
        List<Notation> temp = historyDiary.getNotations();
        for (Notation notat : temp) {
            if (notat.getTimestamp().equals(timestamp)) {
                this.notation = notat;
                return true;
            }
        }
        sensum_bosted.PrintHandler.println("Couldn't initializeNotationHistory", true);
        return false;
    }

    @Override
    public String getTime() {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        return notation.getTimestamp().format(timeFormat);
    }
}

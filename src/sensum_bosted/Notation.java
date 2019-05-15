/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Ryge
 */
public class Notation {
    private String content;
    private LocalDate date;
    private Field field;
    private String lastUser;
    private LocalDateTime timestamp;
    //Date
    //Field <- Område

    public Notation(String content, LocalDate date, Notation.Field field, String lastUser) {
        this(content, date, field, lastUser, LocalDateTime.now());
    } 
    
    public Notation(String content, LocalDate date, Notation.Field field, String lastUser, LocalDateTime timestamp) {
        this.content = content;
        this.date = date;
        this.field = field;
        this.lastUser = lastUser;
        this.timestamp = timestamp;
    }
    
    public static enum Field {
        DISABLED,
        DRUG;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @return the field
     */
    public Field getField() {
        return field;
    }
    
    public void setContent(String content, String lastUser) {
        this.content = content;
        this.lastUser = lastUser;
        LocalDate.now();
    }

    public String getLastUser() {
        return lastUser;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
}

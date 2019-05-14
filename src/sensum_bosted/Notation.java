/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Ryge
 */
public class Notation {
    private String content;
    private Date date;
    private Field field;
    private String lastUser;
    private java.sql.Date timestamp;
    //Date
    //Field <- Område

    public Notation(String content, Date date, Notation.Field field, String lastUser) {
        this(content, date, field, lastUser, new java.sql.Date(new Date().getTime()));
    } 
    
    public Notation(String content, Date date, Notation.Field field, String lastUser, java.sql.Date timestamp) {
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
    public Date getDate() {
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
        new java.sql.Date(new Date().getTime());
    }
    
}

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
    private UUID id;
    //Date
    //Field <- Område

    public Notation(String content, Date date, Notation.Field field, UUID id) {
        this.content = content;
        this.date = date;
        this.field = field;
        this.id = id;
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

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
}

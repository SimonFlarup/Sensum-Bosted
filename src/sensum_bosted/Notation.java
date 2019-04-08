/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.Date;

/**
 *
 * @author Ryge
 */
public class Notation {
    private String content;
    private Date date;
    private Field field;
    //Date
    //Field <- Område

    public Notation(String content, Date date, Notation.Field field) {
        this.content = content;
    } 
    
    public static enum Field {
        DISABLED,
        DRUG;
    }
}

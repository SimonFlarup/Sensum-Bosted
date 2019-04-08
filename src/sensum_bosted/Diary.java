/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Ryge
 */
public class Diary {
    private Date date;
    private List<Notation> notations;

    public Diary(List<Notation> notations) {
        this.notations = notations;
    }

    public Date getDate() {
        return date;
    }

    public List<Notation> getNotations() {
        return notations;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNotations(List<Notation> notations) {
        this.notations = notations;
    }
    
}

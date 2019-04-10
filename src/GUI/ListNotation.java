/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author sebastian
 */
public class ListNotation {

    private UUID id;
    private Date date;

    public ListNotation(Date date, UUID id) {
        this.date = date;
        this.id = id;
    }
//    @Override
//    public String toString() {
//        return date.toString();
//    }

    public Date getDate() {
        return date;
    }

    public UUID getId() {
        return id;
    }

}

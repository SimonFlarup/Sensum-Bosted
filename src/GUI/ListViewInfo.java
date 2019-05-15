/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;

/**
 *
 * @author sebastian
 */
public class ListViewInfo {

    private String id;
    private String name;
    private LocalDate date;
    public static final Comparator<ListViewInfo> BY_DATE = new SortByDate();

    public ListViewInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public ListViewInfo(LocalDate date) {
        this.name = date.toString();
        this.date = date;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    private static class SortByDate implements Comparator<ListViewInfo> {

        @Override
        public int compare(ListViewInfo o1, ListViewInfo o2) {
            return o2.date.compareTo(o1.date);
        }

    }
}

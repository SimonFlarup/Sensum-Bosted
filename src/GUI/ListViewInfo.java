/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

/**
 *
 * @author sebastian
 */
public class ListViewInfo {

    private String id;
    private String name;
    private String userName;
    private String content;
    private LocalDate date;
    private LocalDateTime timestamp;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final Comparator<ListViewInfo> BY_DATE = new SortByDate();
    public static final Comparator<ListViewInfo> BY_TIME = new SortByTime();

    public ListViewInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public ListViewInfo(LocalDate date) {
        this.name = date.format(dateFormat);
        this.date = date;
    }
    
    public ListViewInfo(LocalDateTime timestamp, String[] info) {
        this.name = timestamp.format(timeFormat);
        this.userName = info[0];
        this.content = info[1];
        this.timestamp = timestamp;
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
    
    public String getUsername() {
        return userName;
    }
    
    public String getContent() {
        return content;
    }

    private static class SortByDate implements Comparator<ListViewInfo> {

        @Override
        public int compare(ListViewInfo o1, ListViewInfo o2) {
            return o2.date.compareTo(o1.date);
        }

    }
    
    private static class SortByTime implements Comparator<ListViewInfo> {

        @Override
        public int compare(ListViewInfo o1, ListViewInfo o2) {
            return o2.timestamp.compareTo(o1.timestamp);
        }

    }
}

package org.example.Lab_5;

import java.io.Serializable;
import java.util.*;

public class DateEntity implements Serializable, Comparable {
    private String event;
    private String date;
    private List<String> guests;

    public DateEntity(){}
    public void setDate(String date) {
        this.date = date;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }

    public List<String> getGuests() {
        return guests;
    }

    public String getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "DateEntity{" +
                "event='" + event + '\'' +
                ", date='" + date + '\'' +
                ", nameList=" + guests +
                '}';
    }

    @Override
    public int compareTo(Object o){
        DateEntity o1 = (DateEntity)this;
        DateEntity o2 = (DateEntity)o;

        return o1.getEvent().compareTo(o2.getEvent());
    }

}
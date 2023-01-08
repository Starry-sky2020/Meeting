package com.starry_sky.yang.bean;

import java.util.Date;

public class Appoint {
    private Integer appoint_id;
    private String start_time;
    private String end_time;
    private int people;
    private Integer room_id;
    private Integer department_id;
    private String staff_id;

    public Appoint(){

    }

    public Appoint(Integer appoint_id, Date start_time, Date end_time, int people, Integer room_id, Integer department_id, String staff_id) {
        this.appoint_id = appoint_id;
        this.start_time = String.valueOf(start_time);
        this.end_time = String.valueOf(end_time);
        this.people = people;
        this.room_id = room_id;
        this.department_id = department_id;
        this.staff_id = staff_id;
    }

    @Override
    public String toString() {
        return "Appoint{" +
                "appoint_id=" + appoint_id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", people=" + people +
                ", room_id=" + room_id +
                ", department_id=" + department_id +
                ", staff_id=" + staff_id +
                '}';
    }

    public Integer getAppoint_id() {
        return appoint_id;
    }

    public void setAppoint_id(Integer appoint_id) {
        this.appoint_id = appoint_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
}

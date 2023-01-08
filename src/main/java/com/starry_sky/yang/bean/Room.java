package com.starry_sky.yang.bean;

import java.util.Date;

public class Room {

    private String room_id;
    private Date start_time;
    private Date end_time;
    private int people;
    private String address;
    private String department_id;
    private int max_people;

    public Room(){

    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id='" + room_id + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", people=" + people +
                ", address='" + address + '\'' +
                ", department_id='" + department_id + '\'' +
                ", max_people=" + max_people +
                '}';
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public Room(String room_id, Date start_time, Date end_time, int people, String address, String department_id, int max_people) {
        this.room_id = room_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.people = people;
        this.address = address;
        this.department_id = department_id;
        this.max_people = max_people;
    }
}

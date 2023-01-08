package com.starry_sky.yang.bean;

import java.util.Date;

public class Record {

    private Integer record_id;
    private Date start_time;
    private Date end_time;
    private Integer department_id;

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
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

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Record(){

    }
    public Record(Integer record_id, Date start_time, Date end_time, Integer department_id) {
        this.record_id = record_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "record_id=" + record_id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", department_id=" + department_id +
                '}';
    }
}

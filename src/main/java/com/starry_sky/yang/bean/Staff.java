package com.starry_sky.yang.bean;

public class Staff {

    private String staff_id;
    private String staff_name;
    private Integer staff_age;
    private String staff_phone;
    private String staff_address;

    public Staff(){

    }

    public Staff(String staff_id, String staff_name, Integer staff_age, String staff_phone, String staff_address) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.staff_age = staff_age;
        this.staff_phone = staff_phone;
        this.staff_address = staff_address;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public Integer getStaff_age() {
        return staff_age;
    }

    public void setStaff_age(Integer staff_age) {
        this.staff_age = staff_age;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public String getStaff_address() {
        return staff_address;
    }

    public void setStaff_address(String staff_address) {
        this.staff_address = staff_address;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", staff_age=" + staff_age +
                ", staff_phone=" + staff_phone +
                ", staff_address='" + staff_address + '\'' +
                '}';
    }
}

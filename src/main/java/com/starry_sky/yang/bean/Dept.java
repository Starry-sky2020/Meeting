package com.starry_sky.yang.bean;

public class Dept {

    private String id;
    private String dep_name;
    private String person_num;
    private String manage_id;
    private String manage_name;

    public Dept(){

    }

    public Dept(String id, String dep_name, String person_num, String manage_id, String manage_name) {
        this.id = id;
        this.dep_name = dep_name;
        this.person_num = person_num;
        this.manage_id = manage_id;
        this.manage_name = manage_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getPerson_num() {
        return person_num;
    }

    public void setPerson_num(String person_num) {
        this.person_num = person_num;
    }

    public String getManage_id() {
        return manage_id;
    }

    public void setManage_id(String manage_id) {
        this.manage_id = manage_id;
    }

    public String getManage_name() {
        return manage_name;
    }

    public void setManage_name(String manage_name) {
        this.manage_name = manage_name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", dep_name='" + dep_name + '\'' +
                ", person_num='" + person_num + '\'' +
                ", manage_id='" + manage_id + '\'' +
                ", manage_name='" + manage_name + '\'' +
                '}';
    }
}

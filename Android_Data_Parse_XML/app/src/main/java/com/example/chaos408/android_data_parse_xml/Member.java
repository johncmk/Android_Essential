package com.example.chaos408.android_data_parse_xml;

/**
 * Created by chaos408 on 2/10/2016.
 */
public class Member {

    private String name;
    private int age;
    private String[] hobbys;
    private String u_id;
    private String u_pw;

    public Member() {

    }

    public Member(String name, int age, String[] hobbys, String u_id, String u_pw) {
        this.name = name;
        this.age = age;
        this.hobbys = hobbys;
        this.u_id = u_id;
        this.u_pw = u_pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pw() {
        return u_pw;
    }

    public void setU_pw(String u_pw) {
        this.u_pw = u_pw;
    }


}

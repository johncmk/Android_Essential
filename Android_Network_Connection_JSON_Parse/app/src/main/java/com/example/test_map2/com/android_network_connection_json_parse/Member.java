package com.example.test_map2.com.android_network_connection_json_parse;

import java.util.ArrayList;

/**
 * Created by chaos408 on 2/12/2016.
 */
public class Member {

    private String name;
    private int age;
    private ArrayList<String> hobbys;
    private int no;
    private String id;
    private int pw;

    public Member() {
    }

    public Member(String name, int age, ArrayList<String> hobbys, int no, String id, int pw) {
        this.name = name;
        this.age = age;
        this.hobbys = hobbys;
        this.no = no;
        this.id = id;
        this.pw = pw;
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

    public ArrayList<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(ArrayList<String> hobbys) {
        this.hobbys = hobbys;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }
}

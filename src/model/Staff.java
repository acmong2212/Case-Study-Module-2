package model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String name;
    private int age;
    private String address;
    private boolean status;

    public Staff(int id, String name, int age, String address, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.status = status;
    }

    public Staff() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", name= " + name +
                ", age= " + age +
                ", address= " + address +
                ", status= " + status +
                ", ";
    }
}

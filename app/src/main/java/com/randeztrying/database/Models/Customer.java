package com.randeztrying.database.Models;

public class Customer {

    private String id = "";
    private String type = "";
    private String fio = "";
    private String name = "";
    private String inn = "";
    private String chief = "";
    private String phone = "";
    private String address = "";
    private String bank = "";
    private String district = "";
    private String discont = "";

    public Customer(String id, String type, String fio, String name, String inn, String chief, String phone, String address, String bank, String district, String discont) {
        this.id = id;
        this.type = type;
        this.fio = fio;
        this.name = name;
        this.inn = inn;
        this.chief = chief;
        this.phone = phone;
        this.address = address;
        this.bank = bank;
        this.district = district;
        this.discont = discont;
    }

    public Customer() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDiscont() {
        return discont;
    }

    public void setDiscont(String discont) {
        this.discont = discont;
    }
}
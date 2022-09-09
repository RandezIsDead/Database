package com.randeztrying.database.Models;

public class Type {

    private String id;
    private String customerId;
    private String masterId;
    private String type;
    private String country;
    private String company;
    private String picture;
    private String age;
    private String dateStart;
    private String dateStop;
    private String summa;
    private String period;
    private String guarantee;
    private String comment;

    public Type(String id, String customerId, String masterId, String type,
                String country, String company, String picture, String age, String dateStart,
                String dateStop, String summa, String period, String guarantee, String comment) {
        this.id = id;
        this.customerId = customerId;
        this.masterId = masterId;
        this.type = type;
        this.country = country;
        this.company = company;
        this.picture = picture;
        this.age = age;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.summa = summa;
        this.period = period;
        this.guarantee = guarantee;
        this.comment = comment;
    }

    public Type() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateStop() {
        return dateStop;
    }

    public void setDateStop(String dateStop) {
        this.dateStop = dateStop;
    }

    public String getSumma() {
        return summa;
    }

    public void setSumma(String summa) {
        this.summa = summa;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

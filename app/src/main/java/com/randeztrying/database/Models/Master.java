package com.randeztrying.database.Models;

public class Master {

    private String id;
    private String fio;
    private String experience;
    private String defect;
    private String repairAll;

    public Master(String id, String fio, String experience, String defect, String repairAll) {
        this.id = id;
        this.fio = fio;
        this.experience = experience;
        this.defect = defect;
        this.repairAll = repairAll;
    }

    public Master() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public String getRepairAll() {
        return repairAll;
    }

    public void setRepairAll(String repairAll) {
        this.repairAll = repairAll;
    }
}

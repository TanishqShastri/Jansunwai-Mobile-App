package com.example.tanishqshastri_mppolice.jansunwai;

public class complaint {

    private String id,name,aadhaar,phone,subject,date,description,chairpersonRemark,ApplicationStatus,officername,officerRemark,lastupdate;




    public complaint(String id, String name, String aadhaar, String phone, String subject, String date, String description, String chairpersonRemark, String ApplicationStatus, String officerName, String officerRemark, String lastupdate) {
        this.id = id;
        this.name = name;
        this.aadhaar = aadhaar;
        this.phone = phone;
        this.subject = subject;
        this.date = date;
        this.description = description;
        this.chairpersonRemark = chairpersonRemark;
        this.ApplicationStatus = ApplicationStatus;
        this.officername = officerName;
        this.officerRemark = officerRemark;
        this.lastupdate = lastupdate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public String getPhone() {
        return phone;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getChairpersonRemark() {
        return chairpersonRemark;
    }

    public String getApplicationStatus() {
        return ApplicationStatus;
    }

    public String getOfficername() {
        return officername;
    }

    public String getOfficerRemark() {
        return officerRemark;
    }

    public String getLastupdate() {
        return lastupdate;
    }

}

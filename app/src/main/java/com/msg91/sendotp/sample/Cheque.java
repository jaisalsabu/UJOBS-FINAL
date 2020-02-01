package com.msg91.sendotp.sample;

public class Cheque {

    private String comname;
    private String position;
    private String noofvacc;
    private String experience;
    private String contact;
    private String image;



    public Cheque(String comname,String position,String noofvacc,String experience,String contact,String image) {

        this.comname = comname;
        this.position= position;
        this.noofvacc= noofvacc;
        this.experience = experience;
        this.contact=contact;
        this.image = image;


    }

    public Cheque() {
    }


    public String getComname() {
        return comname;
    }
    public String getPos() { return position; }
    public String getNoofvacc() {
        return noofvacc;
    }
    public String getExperience(){return experience;}
    public String getContact(){return contact;}
    public String getImage() { return  image; }}

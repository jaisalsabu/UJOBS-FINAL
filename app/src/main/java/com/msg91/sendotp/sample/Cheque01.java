package com.msg91.sendotp.sample;

public class Cheque01 {

    private String comname;
    private String position;
    private String noofvacc;
    private String experience;
    private String image;



    public Cheque01(String comname,String position,String noofvacc,String experience,String image){

        this.comname = comname;
        this.position= position;
        this.noofvacc= noofvacc;
        this.experience = experience;
        this.image = image;

    }

    public Cheque01() {
    }


    public String getComname() {
        return comname;
    }
    public String getPos() { return position; }
    public String getNoofvacc() {
        return noofvacc;
    }
    public String getExperience(){return experience;}
    public String getImage() { return  image; }}

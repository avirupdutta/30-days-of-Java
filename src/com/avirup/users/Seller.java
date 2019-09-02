package com.avirup.users;

public class Seller extends User{

    public void info (){
        System.out.println("I am a user + seller!");
    }
    public void setAd(){ ads++; }
    public void getAllAds(){
        System.out.println("Total "+ ads +" ads posted");
    }
}

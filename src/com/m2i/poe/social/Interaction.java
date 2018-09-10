package com.m2i.poe.social;

import java.util.ArrayList;
import java.util.Date;

public abstract class Interaction {
    private int id;
    protected User author;
    protected Date date;

    public Interaction(User author){
        this.author = author;
        this.date = new Date();
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // private methods

    protected String getClassName(){
        String className = this.getClass().toString();
        className = className.substring(className.lastIndexOf(".") + 1);
        if(className.substring(0, 4).equals("Like")){
            className = "Like";
        }
        return className;
    }

    // toString

    @Override
    public String toString() {
        return this.getClassName() + ". On " + this.date.toString() + " " + this.author.getNickName() + " ";
    }
}
package com.m2i.poe.social;

import java.util.ArrayList;
import java.util.Date;

public abstract class Message extends Interaction {
    protected String text;
    protected ArrayList<Like> likeList = new ArrayList<>();

    public Message(User author, String text){
        super(author);
        this.text = text;
    }

    // getters & setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Like> getLikeList() {
        return this.likeList;
    }

    public void setLikeList(ArrayList<Like> likeList) {
        this.likeList = likeList;
    }

    // public methods

    public void delete(){
        this.likeList.clear();
    }

    // toString

    @Override
    public String toString() {
        String res = super.toString() + "wrote:\n";
        if(this.getClassName().equals("Comment")){
            res += "\t";
        }
        res += this.text + "\n";
        for (Like l : this.likeList) {
            res += l.toString();
        }
        return res;
    }
}



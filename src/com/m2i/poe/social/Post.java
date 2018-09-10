package com.m2i.poe.social;

import java.util.ArrayList;
import java.util.Date;

public class Post extends Message {
    private static int counter = 1;
    private int id;
    private ArrayList<Comment> commentList = new ArrayList<>();

    public Post(User author, String text){
        super(author, text);
        this.author.getPostList().add(this);
        this.id = counter;
        ++counter;
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Comment> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }

    // public methods

    @Override
    public void delete(){
        super.delete();
        this.commentList.clear();
        this.author.getPostList().remove(this);
    }

    // toString

    @Override
    public String toString() {
        String res = super.toString();
        for (Comment c : this.commentList) {
            res += c.toString();
        }
        return res;
    }
}


package com.m2i.poe.social;

import java.util.Date;

public class Comment extends Message {
    private static int counter;
    private int id;
    private Post post;

    public Comment(User author, Post post, String text){
        super(author, text);
        this.id = counter;
        ++counter;
        this.post = post;
        this.post.getCommentList().add(this);
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    // public methods

    @Override
    public void delete(){
        super.delete();
        this.post.getCommentList().remove(this);
    }
    // toString

    @Override
    public String toString() {
        return "\t" + super.toString();
    }
}

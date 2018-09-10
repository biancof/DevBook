package com.m2i.poe.social;

import java.util.ArrayList;

public class MockRepository {
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Post> postList = new ArrayList<>();
    private ArrayList<Comment> commentList = new ArrayList<>();
    private ArrayList<Like> likeList = new ArrayList<>();

    public MockRepository(){
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<Like> getLikeList() {
        return likeList;
    }

    public void setLikeList(ArrayList<Like> likeList) {
        this.likeList = likeList;
    }

    public User isLoginRight(String login){
        for(User u : this.userList){
            if(u.getEmail() == login){
                return u;
            }
        }
        return null;
    }

    public boolean isPasswordRight(User u, String password){
        if(u.getPassword() == password){
            return true;
        } else return false;
    }
}

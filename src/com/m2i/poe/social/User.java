package com.m2i.poe.social;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class User {
    private static int counter = 1;
    private int id;
    private String email;
    private String password;
    private String nickName;
    private String bestLang;
    private HashSet<User> friendList = new HashSet<>();
    private ArrayList<Post> postList = new ArrayList<>();

    // constructors

    public User(){};

    public User(String email, String password, String nickName){
        this.id = counter;
        ++counter;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBestLang() {
        return bestLang;
    }

    public void setBestLang(String bestLang) {
        this.bestLang = bestLang;
    }

    public HashSet<User> getFriendList() {
        return friendList;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    // public methods

    /*
    To do: adding a friend should pass through
    a friendship request, maybe an object itself?
    */

    public void addFriend(User user){
        if(this.friendList.contains(user)){
            System.out.println(user.nickName + " is already friend of " + this.nickName);
        } else {
            this.friendList.add(user);
            user.getFriendList().add(this);
            System.out.println(user.nickName + " is now friend of " + this.nickName);
        }
    }

    public void removeFriend(User user){
        if(this.friendList.contains(user)){
            this.friendList.remove(user);
            user.getFriendList().remove(this);
            System.out.println(user.nickName + " is not friend of " + this.nickName + " anymore");
        } else {
            System.out.println(user.nickName + " was not friend of " + this.nickName);
        }
    }

    // Add a post

    public void postMessage(String text){
        Post p = new Post(this, text);
        System.out.println(this.nickName + " added a post");
    }

    // Add a comment

    public void postMessage(String text, Post post){
        if(this.friendList.contains(post.getAuthor()) || this == post.getAuthor()){
            Comment c = new Comment(this, post, text);
            System.out.println(this.nickName + " added a comment");
        } else {
            System.out.println(this.nickName +
                    " tried to post a comment on " +
                    post.getAuthor().nickName + ", but they are not friends");
        }
    }

    // Give a like (remove it if given)

    public void unLike(Message m){
        if(m.getAuthor().getFriendList().contains(this) || this == m.getAuthor()){
            for(Like l : m.getLikeList()){
                if(l.getAuthor() == this){
                    m.getLikeList().remove(l);
                    System.out.println(nickName + " unliked this " + m.getClassName());
                    return;
                }
            }
            Like l = new Like(this, m);
            System.out.println(nickName + " liked this " + m.getClassName());
        } else {
            System.out.println(nickName + " can't like this " + m.getClassName());
        }
    }

    // Update post or comment

    public void updateMessage(Message m, String text){
        if(m.getAuthor() == this) {
            m.setText(text);
            m.setDate(new Date());
            System.out.println(this.nickName + " changed a " + m.getClassName());
        } else {
            System.out.println(this.nickName + " can't change the " + m.getClassName());
        }
    }

    // Remove post or comment

    public void removeMessage(Message m){
        if(this == m.getAuthor()){
            System.out.println(this.nickName + " deleted the " + m.getClassName());
            m.delete();
        } else {
            System.out.println(this.nickName + " can't delete the " + m.getClassName());
        }
    }

    // toString

    @Override
    public String toString() {
        return "User # " + this.id + ": " + this.nickName +
                "\nEmail: " +
                this.email +"\nPassword: " +
                this.password + "\nFavourite language: " +
                this.bestLang + "\nFriends: "
                + this.friendList.size() +
                "\nPosts: " + this.postList.size();
    }
}

package com.m2i.poe.social;

public class Like extends Interaction {
    private static int counter = 1;
    private int id;
    private Message message;

    public Like(User author, Message message){
        super(author);
        this.id = counter;
        ++counter;
        this.message = message;
        this.message.getLikeList().add(this);
    }

    // getters & setters

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String res = "\t";
        if(this.getMessage().getClassName().equals("Comment")){
            res += "\t";
        };
        return res += super.toString() + "liked this " + this.getMessage().getClassName() + "\n";
    }
}

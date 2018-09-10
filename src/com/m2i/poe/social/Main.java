package com.m2i.poe.social;

import java.sql.SQLException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a mock repository with 4 users
        User user1 = new User("bianco@francescobianco.net","test", "kranio77");
        User user2 = new User("tbl@cern.ch", "worldwideweb", "tim.berners.lee");
        User user3 = new User("contact@cyrilvincent.com", "ilovejava", "cyril_vincent");
        User user4 = new User("linus.torvald@gmail.com", "linux", "linus");
        MockRepository repo = new MockRepository();
        repo.getUserList().add(user1);
        repo.getUserList().add(user2);
        repo.getUserList().add(user3);
        repo.getUserList().add(user4);
        System.out.println(repo.getUserList());

        System.out.println();

        // Users establish and break friendships
        user1.addFriend(user2);
        user2.addFriend(user3);
        user3.addFriend(user1);
        user4.addFriend(user3);
        user3.removeFriend(user4);
        user4.addFriend(user1);

        System.out.println();

        // User 1 publish a post
        user1.postMessage("Php is the best language");
        // User 2 comments on this post
        user2.postMessage("I think python is better", user1.getPostList().get(0));
        // User 3 also comments on this post
        user3.postMessage("However, Java is the king of languages!", user1.getPostList().get(0));
        // User 4 likes the post
        user4.unLike(user1.getPostList().get(0));
        // User 4 tries to like User 3's comment
        user4.unLike(user1.getPostList().get(0).getCommentList().get(1));
        // User 2 likes User 3's comment
        user2.unLike(user1.getPostList().get(0).getCommentList().get(1));
        // User 1 changes his post
        user1.updateMessage(user1.getPostList().get(0), "All languages are nice!");
        // All users like this post
        user2.unLike(user1.getPostList().get(0));
        user3.unLike(user1.getPostList().get(0));
        // User 2 removes his comment
        user2.removeMessage(user1.getPostList().get(0).getCommentList().get(0));

        System.out.println();

        // Finally, the post ("All languages are nice!")
        // is supposed to have 1 comment and 3 likes;
        // The comment is supposed to have 1 like
        System.out.println(user1.getPostList().get(0));

        System.out.println();

        // User 3 add a post
        user3.postMessage("I like this new social network!");
        // User 1 likes User 3's post
        user1.unLike(user3.getPostList().get(0));
        // User 1 unlikes User 3's post
        user1.unLike(user3.getPostList().get(0));
        // User 4 tries to like User 3's post
        user4.unLike(user3.getPostList().get(0));
        // User 4 tries to comment on User 3's post;
        user4.postMessage("Me too!", user3.getPostList().get(0));
        // User 4 tries to remove User 3 from friends
        user4.removeFriend(user3);
        // User 4 adds User 3 to friends
        user4.addFriend(user3);
        // User 4 adds a comment on User 3's post
        user4.postMessage("I hate you, Cyril!", user3.getPostList().get(0));
        // User 4 changes his comment
        user4.updateMessage(user3.getPostList().get(0).getCommentList().get(0), "You're not very polite, Cyril");
        // User 3 adds a comment on his post
        user3.postMessage("Yes, I am!", user3.getPostList().get(0));
        // User 4 try to change User 3's post
        user4.updateMessage(user3.getPostList().get(0), "Linus Torvalds is the best developer in the world");
        // User 3 tries to remove User 4's comment
        user3.removeMessage(user3.getPostList().get(0).getCommentList().get(0));
        // User 3 removes his comment
        user3.removeMessage(user3.getPostList().get(0).getCommentList().get(1));

        System.out.println();

        // Finally, the post ("I like this social network!")
        // is supposed to have 1 comment and 0 likes;
        // The comment is supposed to have 0 likes
        System.out.println(user3.getPostList().get(0));

        System.out.println();

        // User 1 has now 1 post
        System.out.println(user1);

        System.out.println();

        // User 1 tries to remove User 3's post
        user1.removeMessage(user3.getPostList().get(0));
        // User 1 removes his post
        user1.removeMessage(user1.getPostList().get(0));

        System.out.println();

        // User 1 has now 0 posts
        System.out.println(user1);

    }
}

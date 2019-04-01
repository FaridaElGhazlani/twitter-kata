package com.zenika.decathlon.coding.school.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class User implements Comparable<User>{

    String login;
    Set<User> usersFollowed;
    List<Message> messageList;

    public User(String login) {
        this.login = login;
        this.usersFollowed = new TreeSet<>();
        this.messageList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public int compareTo(User u) {
        return this.login.compareTo(u.login);
    }
}

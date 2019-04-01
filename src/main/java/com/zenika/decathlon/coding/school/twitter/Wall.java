package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

import java.util.Set;

public class Wall implements Command {
    @Argument
    String login;

    @Override
    public void perform(Store store) {

        User user = store.getOrCreateUser(login);
        Set<User> usersFollowed = user.usersFollowed;

        Read read = new Read();
        read.login = this.login;
        read.perform(store);

        for(User currentUser : usersFollowed){
            read.login = currentUser.login;
            read.perform(store);
        }

    }
}

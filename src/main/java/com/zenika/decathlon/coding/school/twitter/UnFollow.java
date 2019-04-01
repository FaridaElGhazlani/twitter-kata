package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

public class UnFollow implements Command {
	@Argument String login;
	@Argument String loginToRemove;

    @Override
    public void perform(Store store) {

        User user = store.getOrCreateUser(login);
        User userToRemove = store.getOrCreateUser(loginToRemove);

        user.usersFollowed.remove(userToRemove);

    }

}

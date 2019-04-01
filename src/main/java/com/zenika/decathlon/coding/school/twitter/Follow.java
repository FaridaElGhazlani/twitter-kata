package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

public class Follow implements Command {
	@Argument String loginFollower;
	@Argument String loginFollowed;

	@Override
	public void perform(Store store) {

        User userFollower = store.getOrCreateUser(loginFollower);
        User userFollowed = store.getOrCreateUser(loginFollowed);

        userFollower.usersFollowed.add(userFollowed);

	}

}

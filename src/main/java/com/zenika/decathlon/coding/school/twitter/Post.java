package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

public class Post implements Command {
	@Argument String login;
	@Argument String message;

    @Override
	public void perform(Store store) {


	    User user = store.getOrCreateUser(login);

        user.messageList.add(new Message(this.message));
	}

}

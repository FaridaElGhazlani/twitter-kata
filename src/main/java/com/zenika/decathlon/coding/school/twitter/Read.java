package com.zenika.decathlon.coding.school.twitter;

import org.kohsuke.args4j.Argument;

import java.util.List;

public class Read implements Command {
    @Argument
    String login;

    @Override
    public void perform(Store store) {

        User user = store.getOrCreateUser(login);
        List<Message> messageList = user.messageList;

        for (Message message : messageList) {
            System.out.println(user.login + " - " + message.text);
        }
    }

}

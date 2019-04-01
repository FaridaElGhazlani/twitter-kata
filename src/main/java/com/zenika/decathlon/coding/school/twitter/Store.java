package com.zenika.decathlon.coding.school.twitter;

import java.util.TreeMap;

public class Store {
    TreeMap<String, User> usersTreeMap = new TreeMap<>();

    public User getOrCreateUser(String login){
        if(!usersTreeMap.containsKey(login)){
            usersTreeMap.put(login, new User(login));
        }
        return usersTreeMap.get(login);
    }
}

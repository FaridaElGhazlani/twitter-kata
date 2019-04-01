package com.zenika.decathlon.coding.school.twitter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;

public class FollowTest {



    @Test
    public void can_read_cedric_message(){

        Store store = new Store();
        Follow follow = new Follow();
        follow.loginFollower = "cedric";
        follow.loginFollowed = "farida";
        follow.perform(store);

        Set<User> userSet = store.usersTreeMap.get("cedric").usersFollowed;

        Assertions.assertThat(userSet.contains(new User("farida"))).isTrue();

    }


}

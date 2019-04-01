package com.zenika.decathlon.coding.school.twitter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PostTest {

    public static Command of(String login, String message) {
        Post post = new Post();
        post.login = login;
        post.message = message;
        return post;
    }

    @Test
    public void cedric_can_post_test1(){
        Store store = new Store();

        of("cedric","test1").perform(store);

        Assertions.assertThat(store.usersTreeMap).containsKey("cedric");
        Assertions.assertThat(store.usersTreeMap.get("cedric").messageList.get(0).text).isEqualTo("test1");
    }
}

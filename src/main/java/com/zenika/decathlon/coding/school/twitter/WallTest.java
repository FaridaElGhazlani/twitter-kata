package com.zenika.decathlon.coding.school.twitter;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WallTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void test1(){
        Store store = initTest();

        Wall wall = new Wall();
        wall.login = "cedric";
        wall.perform(store);

        Assertions.assertThat(outContent.toString()).contains("cedric - test1", "cedric - test2", "guillaume - test_guillaume1", "guillaume - test_guillaume2");
    }


    @Test
    public void test2(){
        Store store = initTest();
        //Cedric suit guillaume

        Wall wall = new Wall();
        wall.login = "guillaume";
        wall.perform(store);

        Assertions.assertThat(outContent.toString()).contains("guillaume - test_guillaume1", "guillaume - test_guillaume2");
    }

    private Store initTest() {
        Store store = new Store();
        Post post = new Post();

        post.login = "cedric";
        post.message = "test1";
        post.perform(store);

        post.message = "test2";
        post.perform(store);


        post.login = "guillaume";
        post.message = "test_guillaume1";
        post.perform(store);

        post.message = "test_guillaume2";
        post.perform(store);

        Follow follow = new Follow();
        follow.loginFollower = "cedric";
        follow.loginFollowed = "guillaume";
        follow.perform(store);
        //Cedric suit guillaume
        return store;
    }
}

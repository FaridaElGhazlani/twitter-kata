package com.zenika.decathlon.coding.school.twitter;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ReadTest {

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
    public void can_read_cedric_message(){

        Store store = new Store();
        PostTest.of("cedric","test1").perform(store);

        Read read = new Read();
        read.login = "cedric";

        read.perform(store);


        Assertions.assertThat(outContent.toString()).isEqualTo("cedric - test1\n");
    }

    @Test
    public void can_read_cedric_two_messages(){

        Store store = new Store();
        PostTest.of("cedric","test1").perform(store);
        PostTest.of("cedric","test2").perform(store);

        Read read = new Read();
        read.login = "cedric";

        read.perform(store);


        Assertions.assertThat(outContent.toString()).isEqualTo("cedric - test1\ncedric - test2\n");
    }

}

package cn.codeyang.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by meicai on 2016/1/19
 */
public class AssertThatTest {

    @Test
    public void test_matcher_behavior(){
        int myAge = 30;

        //examine the exact match with equalTo and is
        assertThat(myAge, equalTo(30));
        assertThat(myAge, is(30));

        //examine partial match with not()
        assertThat(myAge, not(equalTo(33)));
        assertThat(myAge, is(not(33)));
    }

    @Test
    public void verify_multiple_values(){
        double myMarks = 100.00;

        assertThat(myMarks, either(is(100.00)).or(is(90.9)));
        assertThat(myMarks, both(not(99.99)).and(not(60.00)));

        assertThat(myMarks, anyOf(is(100.00), is(55.00), is(1.00)));

        assertThat(myMarks, not(anyOf(is(0.00), is(200.00))));

        assertThat(myMarks, not(allOf(is(1.00), is(100.00), is(30.00))));

    }

    @Test
    public  void verify_collection_values(){
        List<Double> salary = Arrays.asList(50.0, 200.0, 500.0);

        assertThat(salary, hasItem(50.00));
        assertThat(salary, hasItems(50.00, 200.00));
        assertThat(salary, not(hasItem(1.00)));
    }

    @Test
    public void verify_Strings(){
        String myName = "John Jr Dale";

        assertThat(myName, startsWith("John"));
        assertThat(myName, endsWith("Dale"));
        assertThat(myName, containsString("Jr"));
    }
}

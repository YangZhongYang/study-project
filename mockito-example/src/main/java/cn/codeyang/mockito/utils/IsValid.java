package cn.codeyang.mockito.utils;

import org.mockito.ArgumentMatcher;

import java.util.List;

/**
 * Created by meicai on 2016/1/18
 */
public class IsValid extends ArgumentMatcher<List> {

    @Override
    public boolean matches(Object o) {
        return o.equals(1) || o.equals(2);
    }
}

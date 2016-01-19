package cn.codeyang.test;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * Created by meicai on 2016/1/19
 */
public class LessThanOrEqual<T extends Comparable<T>> extends BaseMatcher<Comparable<T>> {
    private final Comparable<T> expValue;

    public LessThanOrEqual(T expValue){
        this.expValue = expValue;
    }

    public boolean matches(Object o) {
        int compareTo = expValue.compareTo((T)o);
        return compareTo > -1;
    }

    public void describeTo(Description description) {
        description.appendText(" less than or equals(<=)" + expValue);
    }
}

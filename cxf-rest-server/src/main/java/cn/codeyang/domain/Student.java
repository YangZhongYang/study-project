package cn.codeyang.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author YangZhongYang
 */
@XmlRootElement(name = "student")
public class Student {
    private long id;
    private String name;
    private Date birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

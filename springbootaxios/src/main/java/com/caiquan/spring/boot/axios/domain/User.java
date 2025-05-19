package com.caiquan.spring.boot.axios.domain;

import java.io.Serializable;

/**
 * @ClassName User
 * @Auther: CarpCap
 * @Date: 2020-01-11 16:00
 * @Description:
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

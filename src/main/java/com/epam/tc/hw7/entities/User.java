package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;

public class User extends DataClass<User> {
    private String userName;
    private String password;

    public static User ROMAN = new User().set(c -> {
        c.userName = "Roman";
        c.password = "Jdi1234";
    });
}

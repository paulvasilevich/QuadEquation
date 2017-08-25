package com.belhard.utils;

import java.util.*;

public class DatabaseUsers {

    public static Map<String, User> usersMap = new LinkedHashMap<>();

    public DatabaseUsers() {
    }

    public static Map<String, User> getUsersMap() {
        return usersMap;
    }

    public static void setUsersMap(Map<String, User> usersMap) {
        DatabaseUsers.usersMap = usersMap;
    }
}

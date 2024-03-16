package com.example.fragmentapp.Data;


import java.util.HashMap;
import java.util.Map;

public class MyData {
    private static class UserInfo {
        String password;
        String phoneNumber;

        UserInfo(String password, String phoneNumber) {
            this.password = password;
            this.phoneNumber = phoneNumber;
        }
    }

    private final Map<String, UserInfo> users = new HashMap<>();

    public MyData() {
        // Add a mock user for testing purposes
        addUser("omer", "1234", "0508334100");
    }

    public boolean addUser(String username, String password, String phoneNumber) {
        if (users.containsKey(username)) {
            return false;
        } else {
            users.put(username, new UserInfo(password, phoneNumber));
            return true;
        }
    }

    public boolean checkUserCredentials(String username, String password) {
        UserInfo user = users.get(username);
        return user != null && user.password.equals(password);
    }

}

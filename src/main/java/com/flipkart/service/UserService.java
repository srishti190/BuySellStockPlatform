package com.flipkart.service;

import com.flipkart.models.Stock;
import com.flipkart.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    public static List<User> userList = new ArrayList<>();
    public static Map<String, User> userMap = new HashMap<>();

    public void createUser(String userName, Double initialWalletAmount){
        if(userMap.containsKey(userName)){
            System.out.println("user " + userName + "already created");
            return;
        }
        User user = new User(userName, initialWalletAmount);
        userList.add(user);
        userMap.put(userName, user);
        System.out.println("User successfully created");
    }

    public static List<User> getUserList() {
        return userList;
    }

    public static Map<String, User> getUserMap() {
        return userMap;
    }
}

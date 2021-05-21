package com.example.demo.controller;

import com.example.demo.entity.UserData;
import com.example.demo.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDataController {

    @Autowired
    UserDataRepository userDataRepository;

    @GetMapping("/getAll")
    public void getAll() {
        List<UserData> userDataLists = userDataRepository.findAll();
        for (UserData userDataList : userDataLists) {
            System.out.println("getUserId = " + userDataList.getUserId());
            System.out.println("getUserName = " + userDataList.getUserName());
        }
    }

}

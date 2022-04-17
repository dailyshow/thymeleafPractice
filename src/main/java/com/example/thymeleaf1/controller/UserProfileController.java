package com.example.thymeleaf1.controller;

import com.example.thymeleaf1.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<>();
        userMap.put("1", new UserProfile("1", "cis1", "010-1234-1234", "ansan1"));
        userMap.put("2", new UserProfile("2", "cis2", "010-5678-5678", "ansan2"));
        userMap.put("3", new UserProfile("3", "cis3", "010-9876-9876", "ansan3"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUerProfileList() {
        return new ArrayList<>(userMap.values());
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = userMap.get(id);
        userProfile.setName(name);
        userProfile.setPhone(phone);
        userProfile.setAddress(address);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userMap.put(id, userProfile);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        userMap.remove(id);
    }
}

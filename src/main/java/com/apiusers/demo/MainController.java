package com.apiusers.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping()
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/user/add")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {


        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/user/byID")
    public @ResponseBody Optional<User> getUserByID(@RequestParam("id") int id) {
        return userRepository.findById(id);
    }

    @GetMapping(path="/user/")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/test")
    public @ResponseBody String testPage() {
        return "Test page, nothing more.";
    }
}
package com.grupa5.biblioteka.controller;

import com.grupa5.biblioteka.model.Book;
import com.grupa5.biblioteka.model.User;
import com.grupa5.biblioteka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public User deleteUserById(@PathVariable Long id) {
        //tworzymy usera do usuniecia
        return userService.deleteUser(id);
    }

    @PostMapping
    @ResponseBody
    public User addUser(@RequestBody User user) {
       return userService.saveUser(user);
    }


    @GetMapping("/add")
    @ResponseBody
    public User addMockUser() {
        return userService.saveMockUser();
    }

    @PostMapping("/{user_id}/add_book")
    public void addBook(@PathVariable Long user_id, @RequestBody Book book) {
        userService.addBook(user_id, book.getId());
    }

}

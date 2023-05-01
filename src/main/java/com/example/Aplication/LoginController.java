package com.example.Aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Users login(
                       @RequestParam("email") String email,
                       @RequestParam("password") String password
    ){
        return userService.findEmail(email,password);
    }

    @GetMapping("/findUser/{id}")
    public Users findUser(@PathVariable("id") Long userId){
        return userService.findUser(userId);
    }

    @GetMapping("/fetchUserList")
    public List<Users> fetchUserList(){
        return userService.fetchUserList();
    }

    @PutMapping("/updateUser/{id}")
    public Users
    updateUser(@RequestBody Users user,
                     @PathVariable("id") Long userId)
    {

        return userService.updateUser(
                user, userId);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable("id")
                                       Long userId)
    {

        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }

    @PostMapping(value="/saveUser",consumes = {"application/json"})
    public Users saveUser(
             @RequestBody Users user)
    {

        return userService.saveUser(user);
    }

}
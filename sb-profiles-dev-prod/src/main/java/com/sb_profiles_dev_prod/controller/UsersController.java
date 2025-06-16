package com.sb_profiles_dev_prod.controller;

import com.sb_profiles_dev_prod.entity.Users;
import com.sb_profiles_dev_prod.repo.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersRepo usersRepo;

    @PostMapping
    public Users saveUser(@RequestBody Users users){
        return usersRepo.save(users);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersRepo.findAll();
    }
}

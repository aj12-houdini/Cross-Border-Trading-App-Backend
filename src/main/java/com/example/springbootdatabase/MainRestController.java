package com.example.springbootdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1")
@CrossOrigin
public class MainRestController {

    @Autowired
    CredentialRepository credentialRepository;

    @Autowired
    UsertypeRepository usertypeRepository;

    @GetMapping("getusertype")
    public List<Usertype> getUserType(@RequestParam("username") String username){
        return usertypeRepository.findByUsername(username);
    }

    @GetMapping("getdummy")
    public Userdetail getDummyUser(){
        Userdetail userdetail = new Userdetail();
        userdetail.setUsername("aj10");
        userdetail.setFname("Aayush");
        userdetail.setLname("Juyal");
        userdetail.setEmail("@gmail.com");
        return userdetail;
    }

    @GetMapping("/save")
    public String save(){
        Credential credential = new Credential();
        credential.setUsername("aayush");
        credential.setPassword("1234");
        credentialRepository.save(credential);
        return "new credential saved";
    }

    @GetMapping("find")
    public String find_by_id(){
        Optional<Credential> credential = credentialRepository.findById("aayush");
        if(credential.isPresent())
            return "Value is present";
        return "value is not present ";
    }



}

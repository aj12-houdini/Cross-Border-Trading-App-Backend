package com.example.springbootdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MainRestController {

    @Autowired
    CredentialRepository credentialRepository;
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

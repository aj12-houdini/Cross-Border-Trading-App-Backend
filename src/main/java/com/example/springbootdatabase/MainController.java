    package com.example.springbootdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

    @Controller
public class MainController {
        @Autowired //Object of some type
        CredentialRepository credentialRepository;
        @Autowired
        UserdetailRepository userdetailRepository;

        @Autowired
        UsertypeRepository usertypeRepository;

    @GetMapping("/landing")
    public String landing_page(){
        return "landingpage";
    }

    @PostMapping("/signup")
    public String singup(@RequestParam("username") String username, @RequestParam("password") String password){
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        credentialRepository.save(credential);
        return "dashboard";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model){
        Credential credential = new Credential();
        Optional<Credential> finduser =  credentialRepository.findById(username);
        if(finduser.isPresent()){
            if(finduser.get().getPassword().equals(password)){
                session.setAttribute("username",username);
                List<Usertype> usertype = usertypeRepository.findAll();
                Optional <Userdetail> userdetail = userdetailRepository.findById(username);
                if(userdetail.isPresent()){
                }
                return "dashboard";
            }
            else
                return "landingpage";
        }
        else
            return "landingpage";
    }
    @PostMapping("signing")
        public String dashboard(@RequestParam("username") String username, @RequestParam("fName") String fName, @RequestParam("lName") String lName, @RequestParam("email") String email){
            Userdetail userdetail = new Userdetail();
            userdetail.setUsername(username);
            userdetail.setFname(fName);
            userdetail.setLname(lName);
            userdetail.setEmail(email);
            userdetailRepository.save(userdetail);
            return "home_page";
    }

}

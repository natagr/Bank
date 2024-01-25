package com.security.springSecurityBasic.controller;

import com.security.springSecurityBasic.model.Customer;
import com.security.springSecurityBasic.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    final CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer=null;
        ResponseEntity response=null;
        try{
            savedCustomer=customerRepository.save(customer);
            if(savedCustomer.getId()>0){
                response=ResponseEntity.status(HttpStatus.CREATED).body("given user details are successfully registered");
            }
        }catch(Exception ex){
            response=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an exception occured due to " + ex.getMessage());
        }
        return response;
    }

}

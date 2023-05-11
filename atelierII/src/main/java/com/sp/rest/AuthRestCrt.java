package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.service.AuthService;

@RestController
public class AuthRestCrt {
      @Autowired
      AuthService aService;
      
      @RequestMapping(method=RequestMethod.POST,value="/auth")
      public void login(@RequestBody String username, String passwd) {
          aService.login(username, passwd);
      }
      
      @RequestMapping(method=RequestMethod.POST,value="/user")
      public Integer signup(@RequestBody User user) {
          int newId = aService.signup(user);
          aService.assignStarterCards(user);
          return newId;
      }

}
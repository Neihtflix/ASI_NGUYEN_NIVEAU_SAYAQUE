package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.service.UserService;

@RestController
public class UserRestCrt {
      @Autowired
      UserService uService;
      
      
      @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
      public User getUser(@PathVariable String id) {
    	  User u = uService.getUser(Integer.valueOf(id));
          return u;
      }
}
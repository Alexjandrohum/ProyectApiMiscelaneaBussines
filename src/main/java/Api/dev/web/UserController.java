/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api.dev.web;

import Api.dev.contract.MessageErrorContract;
import Api.dev.contract.UserContract;
import Api.dev.entities.TypeUser;
import Api.dev.entities.User;
import Api.dev.util.Constant;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author alexjandrohum
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserContract service;
    
    @GetMapping("/getListUser")
    public ResponseEntity<List<User>> getListUser() {
        
        try {
            return new ResponseEntity<>(service.getListUser(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping("/getListTypeUser")
    public ResponseEntity<List<TypeUser>> getListTypeUser() {
        List<TypeUser> list = null;
        try {
            list = service.getListTypeUser();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            //log.error(e.getMessage());
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        }
        
    }
    
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        try {
            User user = service.getUserById(id);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/getTypeUserById/{id}")
    public ResponseEntity<TypeUser> getTypeUserById(@PathVariable("id") int id) {
        try {
            TypeUser typeUser = service.getTypeUser(id);
            if (typeUser == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(typeUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            user = service.createUser(user);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            } else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        try {
            if (service.updateUser(user) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        try {
            if (service.deleteUser(id) == Constant.isEnabled) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}

package bo.ucb.edu.pulpa.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import bo.ucb.edu.pulpa.domain.PulpaGarage;
import bo.ucb.edu.pulpa.domain.PulpaUser;
import bo.ucb.edu.pulpa.dto.PulpaAuxiliaryDto;
import bo.ucb.edu.pulpa.service.UserService;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
//@RequestMapping(value = "/home", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PutMapping(value = "/update/{id}")
    public PulpaUser UserUpdateOne (@RequestBody PulpaUser parkingUser, @PathVariable int id) {
        return userService.UpdateOne(id, parkingUser);
    }




}

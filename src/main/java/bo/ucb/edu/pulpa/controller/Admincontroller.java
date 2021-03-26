package bo.ucb.edu.pulpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import bo.ucb.edu.pulpa.domain.PulpaUser;
import bo.ucb.edu.pulpa.domain.PulpaItem;
import bo.ucb.edu.pulpa.service.ItemService;
import bo.ucb.edu.pulpa.service.UserService;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/admin")


public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    //list all users
    @GetMapping(value = "/list")
    public List<PulpaUser> FindAll() {
        return userService.FindAll();
    }

    //find user by iduser
    @GetMapping(value = "/list/{id}")
    public Optional<PulpaUser> FindOneUser(@PathVariable int id){
        return userService.FindOne(id);
    }

    //register user
    @PostMapping(value = "/register")
    public ResponseEntity<PulpaUser> AdminSaveUser (@RequestBody PulpaUser pulpaUser) {
        return new ResponseEntity<PulpaUser>(userService.Save(pulpaUser), HttpStatus.CREATED);
    }

    //delete user
    @DeleteMapping(value = "/delete/{id}")
    public void DeleteOne (@PathVariable int id) {
        userService.DeleteOne(id);
    }

    //update user
    @PutMapping(value = "/update/{id}")
    public PulpaUser AdminUpdateUser (@RequestBody PulpaUser pulpaUser, @PathVariable int id) {
        return userService.UpdateOne(id, pulpaUser);
    }

    //find all Item
    @GetMapping(value = "/Item/list")
    public List<PulpaGarage> FindAllItem() {
        return itemService.FindAllItem();
    }

    //find all Item by iduser
    @GetMapping(value = "/item/list/{id}")
    public List<PulpaItem> FindByIduser(@PathVariable int id) {
        return itemService.FindItem(id);
    }

    //register Item
    @PostMapping(value = "/item/register")
    public ResponseEntity<PulpaItem> AdminGarageSave (@RequestBody PulpaItem pulpaItem) {
        return new ResponseEntity<PulpaItem>(itemService.Save(pulpaItem), HttpStatus.CREATED);
    }

    //update Item
    @PutMapping(value = "/item/update/{id}")
    public PulpaItme AdminUpdateItem (@RequestBody PulpaItem pulpaItem, @PathVariable int id) {
        return itemService.UpdateFreeSpaces(id, pulpaItem);
    }

    //delete garage
    @DeleteMapping(value = "/item/delete/{id}")
    public void DeleteItem (@PathVariable int id) {
        itemService.DeleteOne(id);
    }
}

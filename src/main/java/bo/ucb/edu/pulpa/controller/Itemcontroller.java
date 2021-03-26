package bo.ucb.edu.pulpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bo.ucb.edu.parking.domain.ParkingBooking;
import bo.ucb.edu.parking.domain.ParkingGarage;
import bo.ucb.edu.parking.domain.ParkingUser;
import bo.ucb.edu.parking.service.UserService;
import bo.ucb.edu.parking.service.BookingService;
import bo.ucb.edu.parking.service.GarageService;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/garageowner")


public class Itemtroller {

    @Autowired
    private UserService userService;

    @Autowired
    private GarageService itemService;

    @PutMapping(value = "/update/{id}")
    public PulpsUser GownerUpdate (@RequestBody PulpaUser pulpaUser, @PathVariable int id) {
        return userService.UpdateOne(id, pulpaUser);
    }

    @PostMapping(value = "/item/register")
    public ResponseEntity<PulpaItem> ItemSave (@RequestBody PulpaItem pulpaItem) {
        return new ResponseEntity<PulpaItem>(itemService.Save(pulpaItem), HttpStatus.CREATED);
    }

    @GetMapping(value = "/item/list/{id}")
    public List<PulpaItem> FindByIduser(@PathVariable int id) {
        return itemService.FindItem(id);
    }

    @PutMapping(value = "/item/update/{id}")
    public PulpaItem GownerUpdateSpaces (@RequestBody PulpaItem pulpaItem, @PathVariable int id) {
        return itemService.UpdateFreeSpaces(id, pulpaItem);
    }




}

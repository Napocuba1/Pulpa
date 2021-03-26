package bo.ucb.edu.pulpa.controller;

import bo.ucb.edu.parking.dto.ParkingUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bo.ucb.edu.pulpa.domain.PulpaUser;
import bo.ucb.edu.ulpa.service.UserService;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/home")

public class HomeLoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public PulpaUserDto login(@RequestBody PulpaUser pulpaUser, HttpServletResponse response){

        System.out.println("--------------------------------  USER EMAIL  --------------------------------"+pulpaUser.getEmail());

        PulpaUserDto pulpaUserDto = new PulpaUserDto();
        if (userService.verifyUser(pulpaUser)){
            PuplpaUser foundUser = userService.searchUser(pulpaUser);
            pulpaUserDto.setIduser(foundUser.getIduser());
            pulpaUserDto.setIdstatus(foundUser.getIdstatus());
            pulpaUserDto.setIduserType(foundUser.getIduserType());
            pulpaUserDto.setName(foundUser.getName());
            pulpaUserDto.setLastName(foundUser.getLastName());
            pulpaUserDto.setCi(foundUser.getCi());
            pulpaUserDto.setEmail(foundUser.getEmail());
            pulpaUserDto.setPassword(foundUser.getPassword());
            foundUser = new ParkingUser();
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            pulpaUserDto=null;
        }

        return pulpaUserDto;

    }

    @PostMapping(value = "/register")
    public ResponseEntity<PulpaUser> ClientSave (@RequestBody PulpaUser pulpaUser) {
        return new ResponseEntity<PulpaUser>(userService.Save(pulpaUser), HttpStatus.CREATED);
    }
}

public class HomeloginController {
}

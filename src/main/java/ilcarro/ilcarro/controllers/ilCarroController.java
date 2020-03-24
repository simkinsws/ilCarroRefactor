package ilcarro.ilcarro.controllers;

import ilcarro.ilcarro.api.ilCarroReturnCode;
import ilcarro.ilcarro.dto.Comment;
import ilcarro.ilcarro.dto.bookingDto.BookedPeriodDto;
import ilcarro.ilcarro.dto.carDto.CarRequestDto;
import ilcarro.ilcarro.dto.carDto.CarResponseDto;
import ilcarro.ilcarro.dto.carDto.CarResponseOwnerDto;
import ilcarro.ilcarro.dto.commentDto.CommentRequestDto;
import ilcarro.ilcarro.dto.reservationDto.ReservationRequestDto;
import ilcarro.ilcarro.dto.reservationDto.ReservationResponseDto;
import ilcarro.ilcarro.dto.userDto.UserRequestDto;
import ilcarro.ilcarro.dto.userDto.UserResponseDto;
import ilcarro.ilcarro.entities.UserMongo;
import ilcarro.ilcarro.service.ilCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ilCarroController {

    @Autowired
    private ilCarroService ilCarroService;
    private String getEmail(String authHeader) {
        if(authHeader != null) {
            return authHeader;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/registration")
    public UserResponseDto registerUser(@RequestHeader(value = "email") String authHeader,
            @RequestBody UserRequestDto userRequestDto) {
        return ilCarroService.registerUser(getEmail(authHeader),userRequestDto);
    }

    @PutMapping("/user")
    public UserResponseDto updateUser(@RequestHeader(value = "email") String authHeader,
                                                      @RequestBody UserRequestDto userRequestDto){
        return ilCarroService.updateUser(getEmail(authHeader), userRequestDto);
    }

    @DeleteMapping("/user/{email}")
    public ilCarroReturnCode deleteUser(@PathVariable("email") String email) {
            ilCarroService.deleteUser(email);
            return ilCarroReturnCode.OK;
    }

    @PostMapping("/car")
    public CarResponseOwnerDto addCar(@RequestBody CarRequestDto carRequestDto,
                                      @RequestHeader("email") String authHeader) {
        return ilCarroService.addCar(carRequestDto, getEmail(authHeader));
    }

    @GetMapping("/user/cars/periods/serialNumber=")
    public List<BookedPeriodDto> ownerGetCarBookedPeriods(@RequestHeader(value = "email") String authHeader,
                                                          @RequestParam("serialNumber") String serialNumber) {
        return ilCarroService.getOwnerCarBookedPeriods(getEmail(authHeader),serialNumber);
    }

    @GetMapping("/user/cars/")
        public List<CarResponseDto> getOwnerCarsByEmail(@RequestHeader("email") String authHeader){
            return ilCarroService.getOwnerCarsById(getEmail(authHeader));
        }

    @GetMapping("/user/cars/car/serialNumber=") // owner get car by id
    public CarResponseDto getOwnerCarById(@RequestHeader(value = "email") String authHeader ,
                                          @RequestParam String serialNumber) {
            return ilCarroService.getOwnerCarById(getEmail(authHeader),serialNumber);
    }

    @PutMapping("/car/update")
    public CarResponseOwnerDto updateCar(@RequestHeader(value = "email") String authHeader,
                                         @RequestParam(value = "serialNumber") String serialNumber,
                                         @RequestBody CarRequestDto carRequestDto) {
        return ilCarroService.updateCar(getEmail(authHeader),serialNumber,carRequestDto);
    }

    @GetMapping("/car/{serialNumber}")
    public CarResponseOwnerDto getCar(@PathVariable String serialNumber) {
        return ilCarroService.getCar(serialNumber);
    }

    @DeleteMapping("/car/delete/serialNumber=")
    public void deleteCar(@RequestHeader(value = "email") String authHeader,
                                       @RequestParam String serialNumber) {
        ilCarroService.deleteCar(getEmail(authHeader),serialNumber);
    }

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return ilCarroService.getComments();
    }

    @PostMapping("/comment/add")
    public Comment addComment(
            @RequestHeader(value = "email") String authHeader,
            @RequestParam("serialNumber") String serialNumber,
            @RequestBody CommentRequestDto commentRequestDto) {
        return ilCarroService.addComment(serialNumber,getEmail(authHeader), commentRequestDto);
    }

    @PostMapping("/car/reservation/")
    public ReservationResponseDto makeReservation(@RequestHeader(value = "email") String authHeader,
                                                  @RequestParam("serialNumber") String serialNumber,
                                                  @RequestBody ReservationRequestDto requestDto) {
        return ilCarroService.makeReservation(getEmail(authHeader),serialNumber,requestDto);

    }

    @GetMapping("/car/best")
    public List<UserResponseDto> getBestCars() {
        return ilCarroService.getThreePopularCars();
    }


    @GetMapping("/car/comments/latest")
    public List<Comment> getLatestComments() {
        return ilCarroService.comments();
    }

    @GetMapping("/car/best/cars/")
    public List<BookedPeriodDto> getBest() {
        return ilCarroService.findBestCars();
    }
}

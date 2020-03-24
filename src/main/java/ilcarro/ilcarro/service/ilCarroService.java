package ilcarro.ilcarro.service;

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
import ilcarro.ilcarro.entities.CarMongo;
import ilcarro.ilcarro.entities.UserMongo;

import java.util.List;


public interface ilCarroService {
    UserResponseDto registerUser(String email, UserRequestDto userRequestDto);
    UserResponseDto updateUser(String email, UserRequestDto userRequestDto);
    ilCarroReturnCode deleteUser(String email);
    CarResponseOwnerDto addCar(CarRequestDto carRequestDto, String email);
    Comment addComment(String serialNumber, String email, CommentRequestDto commentRequestDto);
    CarResponseDto getOwnerCarById(String email, String serialNumber);
    List<CarResponseDto> getOwnerCarsById(String email);
    CarResponseOwnerDto updateCar(String ownerEmail,String serialNumber,CarRequestDto carRequestDto);
    List<BookedPeriodDto> getOwnerCarBookedPeriods(String email, String serialNumber);
    CarResponseOwnerDto getCar(String serialNumber);
    UserResponseDto getUser(String email);
    void deleteCar(String email, String serialNumber);
    List<Comment> getComments();
    Comment getComment();
    ReservationResponseDto makeReservation(String email, String serialNumber, ReservationRequestDto reservationRequestDto);
    List<UserResponseDto> getThreePopularCars();
    List<Comment> comments();
    List<BookedPeriodDto> findBestCars();
}

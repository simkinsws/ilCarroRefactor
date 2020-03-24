package ilcarro.ilcarro.exceptions;

import ilcarro.ilcarro.exceptions.errors.CarNotFoundException;
import ilcarro.ilcarro.exceptions.errors.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    private String USER_NOT_FOUND = "User not found with this email.";
    private String CAR_NOT_FOUND = "No Car Found.";

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException
            (UserNotFoundException e, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(e.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(USER_NOT_FOUND,details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleCarNotFoundException
            (CarNotFoundException e, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(e.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(CAR_NOT_FOUND, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

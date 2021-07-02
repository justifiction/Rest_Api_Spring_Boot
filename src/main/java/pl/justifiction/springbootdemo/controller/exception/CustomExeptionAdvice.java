package pl.justifiction.springbootdemo.controller.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class CustomExeptionAdvice {

    @ExceptionHandler(CustomExeption.class)
    public ResponseEntity<Object> customExceptionHandler(CustomExeption ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.httpStatus);
    }

}

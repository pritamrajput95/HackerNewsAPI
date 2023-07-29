package com.hacker.news.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(StoryNotFoundException.class)
    public ResponseEntity<Object> handleCourseNotFoundException(StoryNotFoundException ex)
 {
        // Create a custom error response
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", "story not found");
        responseBody.put("message", ex.getMessage());
        
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }
}

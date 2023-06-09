package springbootBlog202321.demo.Exception.manager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import springbootBlog202321.demo.Exception.handler.ResourceNotFoundException;
import springbootBlog202321.demo.Exception.format.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ApiError(ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String error = String.format("Failed to convert value of type '%s' to required type '%s'; For input string: '%s'",
                ex.getValue().getClass().getSimpleName(), ex.getRequiredType().getSimpleName(), ex.getValue());
        return new ApiError(error);
    }

}

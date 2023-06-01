package springbootBlog202321.demo.Exception;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiError {
    private final String error;
    private final String timestamp;

    public ApiError(String error) {
        this.timestamp = LocalDateTime.now().toString();
        this.error = error;
    }

}



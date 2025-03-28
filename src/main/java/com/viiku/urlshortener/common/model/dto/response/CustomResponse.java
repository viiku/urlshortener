package com.viiku.urlshortener.common.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Generic class for API responses.
 *
 * @param <T> Type of response payload.
 */
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields from response
public class CustomResponse<T> {

    private final LocalDateTime timestamp;
    private final HttpStatus httpStatus;
    private final int statusCode;
    private final boolean success;
    private final String message;
    private final T data;

    @Builder
    public CustomResponse(LocalDateTime timestamp, HttpStatus httpStatus, int statusCode, boolean success, String message, T data) {
        this.timestamp = (timestamp != null) ? timestamp : LocalDateTime.now();
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * Creates a success response with data.
     */
    public static <T> CustomResponse<T> success(T data, String message) {
        return CustomResponse.<T>builder()
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * Creates a response for successful resource creation.
     */
    public static <T> CustomResponse<T> created(T data, String message) {
        return CustomResponse.<T>builder()
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    /**
     * Creates an error response.
     */
    public static CustomResponse<String> error(HttpStatus httpStatus, String message) {
        return CustomResponse.<String>builder()
                .httpStatus(httpStatus)
                .statusCode(httpStatus.value())
                .success(false)
                .message(message)
                .build();
    }
}

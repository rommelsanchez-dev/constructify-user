package com.dice.constructify.user.dto;

import com.dice.constructify.user.constants.Severity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonPropertyOrder({
        "httpStatus",
        "attribute",
        "message",
        "severity",
        "timestamp"
})
public class ErrorDTO {

    @JsonProperty("httpStatus")
    private HttpStatus httpStatus;

    @JsonProperty("attribute")
    private String attribute;

    @JsonProperty("message")
    private String message;

    @JsonProperty("severity")
    private Severity severity;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;
}

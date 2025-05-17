package com.example.datilera.dto.errors;

public record ErrorDtoNotFound(
    String path,
    
    String message
) {

}
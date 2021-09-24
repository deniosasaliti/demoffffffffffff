package com.example.demo.dto;

public class ErrorDto {
    private String ErrorMessage;

    public ErrorDto() {
    }

    public ErrorDto(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}




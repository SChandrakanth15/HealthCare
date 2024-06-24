package com.theelixrlabs.healthcare.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
    private Boolean success;
    private int statusCode;
    private T data;
    private List<String> errors;

    public CommonResponse(Boolean success, int statusCode, T data) {
        this.success = success;
        this.statusCode = statusCode;
        this.data = data;
    }

    public CommonResponse(Boolean success, int statusCode, List<String> errors) {
        this.success = success;
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public CommonResponse(Boolean success, int statusCode) {
        this.success = success;
        this.statusCode = statusCode;
    }
}

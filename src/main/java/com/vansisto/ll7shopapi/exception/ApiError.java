package com.vansisto.ll7shopapi.exception;

import java.time.LocalDateTime;

public record ApiError (
        String path,
        String message,
        int satusCode,
        LocalDateTime dateTime
) {}

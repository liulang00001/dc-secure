package com.payermax.data.secure.client.support;

import com.payermax.common.lang.model.dto.Result;
import com.payermax.data.secure.domain.err.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;


/**
 * @Date 2022/2/22
 * @Author cyy
 */
@Slf4j
@RestControllerAdvice
@ResponseStatus(HttpStatus.OK)
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Result<?> uniqueKeyException(SQLIntegrityConstraintViolationException e) {
        return new Result<>(null, e.getMessage(), ExceptionCode.SOURCE_ID_TABLE_SCHEMA_TABLE_NAME_FIELD_NAME_UNIQUE.name());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> exception(Exception e) {
        log.error(e.getMessage(), e);
        return new Result<>(null, e.getMessage(), ExceptionCode.BAD_REQUEST.name());
    }
}

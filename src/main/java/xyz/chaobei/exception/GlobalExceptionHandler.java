package xyz.chaobei.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理参数不匹配异常
     * @param e 异常
     * @return 异常信息
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {

        log.error("methodArgumentNotValidException",e);

        StringBuilder sb = new StringBuilder();

        for (var err : e.getBindingResult().getFieldErrors()) {
            sb.append(String.format("%s:%s",err.getField(),err.getDefaultMessage()));
        }

        return ResponseEntity.badRequest().body(sb.toString());
    }

}

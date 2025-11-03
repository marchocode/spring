package xyz.chaobei.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author mrc
 */
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

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception e) {
        log.error("exception",e);
        var message = String.format("系统繁忙 [%s]", MDC.get("traceId"));
        return ResponseEntity.status(500).body(message);
    }

}

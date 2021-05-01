package cn.litman.fist.interceptor;


import cn.litman.fist.common.ReturnMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常拦截类
 * @author SoyungTong
 * @email litman@126.com
 * @date 2021/5/2 1:08
 */
@Slf4j
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ReturnMsg exceptionHandler(Exception e){
        e.printStackTrace();
        return new ReturnMsg(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ReturnMsg bindException(BindException e) {
        e.printStackTrace();
        FieldError fieldError = e.getFieldError();
        Validate.notNull(fieldError, "参数类型校验错误");
        return new ReturnMsg(fieldError.getDefaultMessage());
    }

}

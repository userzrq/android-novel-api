package com.rockymobi.common.handler;



import com.rockymobi.common.Exception.RockyException;
import com.rockymobi.common.util.ExceptionUtils;
import com.rockymobi.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
//@RestControllerAdvice = @ResponseBody + @ControllerAdvice
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        //e.printStackTrace();
        log.error(e.getMessage());
        return R.error();
    }

    //
    @ExceptionHandler(RockyException.class)
    public R error(RockyException e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}

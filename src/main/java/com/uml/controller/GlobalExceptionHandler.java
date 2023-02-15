package com.uml.controller;

import com.uml.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理思路：
 * 遇到异常后由异常处理类统一处理，但是异常信息可以在异常抛出时给出，在异常处理类中通过异常的url和信息给前端返回异常信息。
 * 该类中每一个方法应该处理不同的异常，返回的result中要在msg信息中给出异常原因和异常从url（这里可以考虑单独创建一个异常结果返回类）
 * 在创建的时候根据项目中可能产生的异常，或者检验用户的输入是否合法，若不合法可以统一抛出异常，交给该异常处理类来处理
 * 一些例子：用户上传的新闻长度过于长，数据库可能保存不了，后端检测出该问题后抛出异常（这里的异常类建议自定义异常，因为Java可能没有自带合适的异常类）
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 该方法处理所有异常
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e){
        System.out.println(e.getMessage());
        return new Result(false,null,e.getMessage());
    }
}


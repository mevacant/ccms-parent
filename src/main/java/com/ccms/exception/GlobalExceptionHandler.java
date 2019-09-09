package com.ccms.exception;/*package com.cm.pdms.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cm.pdms.common.constant.Errors;
import com.cm.pdms.common.vo.AppRspObject;
import com.cm.pdms.common.vo.ItRspObject;
*//**
 * 全局异常机制，暂无用到
 * @author JianguoChen
 *
 *//*
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public AppRspObject jsonErrorHandler(HttpServletRequest req, BizException e) throws Exception {
       
        return AppRspObject.createFailRsp(e.getCode(), e.getMessage());
    }
    
    @ExceptionHandler(value = ITBizException.class)
    @ResponseBody
    public ItRspObject jsonItErrorHandler(HttpServletRequest req, ITBizException e) throws Exception {
       
        return ItRspObject.createFailRsp(e.getCode(), e.getMessage());
    }
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AppRspObject jsonExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
       
        return AppRspObject.createFailRsp(Errors.ERROR_INNER, e.getMessage());
    }
}*/
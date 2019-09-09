package com.ccms.aspect;

import com.ccms.annotation.RequestLimit;
import com.ccms.constant.Errors;
import com.ccms.exception.RequestLimitException;
import com.ccms.vo.AppRspObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Aspect
@Component
public class RequestLimitAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLimitAspect.class);
    private Map<String , Integer> redisTemplate = new HashMap<>();

    @Around("@annotation(limit)")
    public Object requestLimit(ProceedingJoinPoint pdj, RequestLimit limit) throws RequestLimitException {
        try {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();



            String ip = request.getLocalAddr();
            String url = request.getRequestURL().toString();
            String key = "req_limit_".concat(url).concat(ip);
            if (redisTemplate.get(key) == null || redisTemplate.get(key) == 0) {
                redisTemplate.put(key, 1);
            } else {
                redisTemplate.put(key, redisTemplate.get(key) + 1);
            }
            int count = redisTemplate.get(key);
            if (count > 0) {
                //创建一个定时器
                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        redisTemplate.remove(key);
                    }
                };
                //这个定时器设定在time规定的时间之后会执行上面的remove方法，也就是说在这个时间后它可以重新访问
                timer.schedule(timerTask, limit.time());
            }
            if (count > limit.count()) {
                logger.info("用户IP[" + ip + "]访问地址[" + url + "]超过了限定的次数[" + limit.count() + "]");
                throw new RequestLimitException();
            }

            return pdj.proceed();
        }catch (RequestLimitException rle){
            return AppRspObject.createFailRsp(Errors.ERROR,rle.getMessage());
        }catch (Exception e){
            logger.error("exception异常:{}",e);
            return AppRspObject.createFailRsp(Errors.ERROR,"未知异常");
        }catch (Throwable t){
            logger.error("Throwable异常:{}",t);
            return AppRspObject.createFailRsp(Errors.ERROR,"未知异常");
        }
    }
}

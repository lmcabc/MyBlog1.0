package com.lmc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect //切面
@Component//spring组件
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //切面
    @Pointcut("execution(* com.lmc.controller.*.*(..))")//*.*(..)web下的所有类的所有方法
    public void log() {}

    @Before("log()")//在切面之前执行，传递切面
    public void doBefore(JoinPoint joinPoint) {//joinPoint切面对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //调用了哪个类的哪个方法
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "."+ joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();//请求参数
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}", requestLog);
    }

    @After("log()")//在切面之后执行
    public void doAfter() {
//        logger.info("----------------doAfter--------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}

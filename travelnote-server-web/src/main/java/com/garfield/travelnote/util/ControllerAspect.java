package com.garfield.travelnote.util;

import com.alibaba.fastjson.JSON;
import com.garfield.travelnote.api.bean.ResultEnum;
import com.zhexinit.ov.common.bean.RequestBean;
import com.zhexinit.ov.common.bean.ResponseBean;
import com.zhexinit.ov.common.exception.CommonException;
import com.zhexinit.ov.common.util.ResponseUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by frank on 2016-12-05 14:29.
 */
@Aspect
@Component
public class ControllerAspect {

    private Logger log = LoggerFactory.getLogger(getClass());

    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.garfield.travelnote.action..*.*(..))")
    private void controllerAspect() {
    }
        // 请求method前打印内容
        @Around(value = "controllerAspect()")
        public ResponseBean methodBefore(ProceedingJoinPoint joinPoint) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String methodName = joinPoint.getSignature().toShortString();
            long beginTime = System.currentTimeMillis();

            // 打印请求内容
            log.info("===============请求内容===============");
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            Object[] args = joinPoint.getArgs();
            log.info("请求类方法参数:" + Arrays.toString(args));
            log.info("===============请求内容===============");
            RequestBean requestBean = new RequestBean();
            for (Object arg : args){
                if (arg instanceof RequestBean){
                    requestBean = (RequestBean) arg;
                    break;
                }
            }
            ResponseBean responseBean = null;
            try {
                Object result = joinPoint.proceed();
                if (result instanceof ResponseBean){
                    responseBean = (ResponseBean) result;
                    responseBean.setReqId(requestBean.getReqId());
                }
            } catch (Throwable throwable) {
                if (throwable instanceof CommonException) {
//                log.warn("异常捕获:", throwable);
                    return ResponseUtil.fail(requestBean.getReqId(),(CommonException) throwable);
                } else {
                    log.error("异常捕获:", throwable);
                }
                return ResponseUtil.fail(requestBean.getReqId(), ResultEnum.systemError);
            }
            long endTime = System.currentTimeMillis();
            log.info("耗时：" + (endTime - beginTime));
            log.info("返回结果：" + JSON.toJSONString(responseBean));
            return responseBean;
        }
    }

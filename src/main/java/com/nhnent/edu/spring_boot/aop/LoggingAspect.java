package com.nhnent.edu.spring_boot.aop;

import com.nhnent.edu.spring_boot.domain.Member;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// TODO : #5 @EnableAspectJAutoProxy(proxyTargetClass=true) is set by default.
@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution(* com.nhnent.edu.spring_boot.service.MemberService.subscribe(..))")
    public void log(JoinPoint joinPoint) {
        Member member = retrieveArgument(joinPoint, Member.class, "member");
        LOGGER.debug("subscribe method is called with member={}", member);

    }

    private static <T> T retrieveArgument(JoinPoint joinPoint, Class<T> argType, String argName) {
        String[] keys = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] vals = joinPoint.getArgs();

        if (isArrayEmpty(keys) || isArrayEmpty(vals) || keys.length != vals.length) {
            return null;
        }

        for (int i = 0; i < vals.length; i++) {
            if (argName.equals(keys[i])) {
                return argType.cast(vals[i]);
            }
        }

        return null;
    }

    private static boolean isArrayEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

}

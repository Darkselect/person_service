package uz.darkselect.person_service.asspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class MethodLoggingAspect {

    @Before("@annotation(uz.darkselect.person_service.asspect.annotation.LoggingAspectBeforeMethod) || @annotation(uz.darkselect.person_service.asspect.annotation.AllAspect)")
    public void loggingBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        log.info("Starting method with name: {}", methodName);
        if (args.length > 0) {
            log.info("Parameters: {}", Arrays.toString(args));
        }
    }

    @After("@annotation(uz.darkselect.person_service.asspect.annotation.LoggingAspectAfterMethod) || @annotation(uz.darkselect.person_service.asspect.annotation.AllAspect)")
    public void loggingAfterMethod(JoinPoint joinPoint) {
        log.info("Finished method {}", joinPoint.getSignature().getName());
    }
}

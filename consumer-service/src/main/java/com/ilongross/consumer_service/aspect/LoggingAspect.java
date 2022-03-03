package com.ilongross.consumer_service.aspect;

import com.ilongross.consumer_service.model.CarModel;
import com.ilongross.consumer_service.model.CarModelClassified;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @AfterReturning("loggingCarModel()")
    public void loggingCarModelAdvice(JoinPoint joinPoint) {
        for (var arg : joinPoint.getArgs()) {
            if(arg instanceof CarModel) {
                log.info("CONSUMER: Added to storage CAR MODEL: {}", arg);
            }
        }
    }

    @Pointcut("@annotation(com.ilongross.consumer_service.aspect.LoggingCarModel))")
    public void loggingCarModel() {
    }

}

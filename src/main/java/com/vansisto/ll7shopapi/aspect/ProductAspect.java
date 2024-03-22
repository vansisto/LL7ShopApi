package com.vansisto.ll7shopapi.aspect;


import com.vansisto.ll7shopapi.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ProductAspect {

    @Before("execution(* com.vansisto.ll7shopapi.service.ProductService.create(..)) && args(dto)")
    public void logCreating(ProductDTO dto) {
        log.info("Creating product: {}", dto);
    }

    @Before("execution(* com.vansisto.ll7shopapi.service.ProductService.*(..)))")
    public void logAllProductMethods(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Execution method: {}", methodName);
        for (Object arg : args) {
            if (arg instanceof ProductDTO productDTO && productDTO.getPrice().doubleValue() < 0) {
                throw new IllegalStateException("Price can not be less than zero");
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.vansisto.ll7shopapi.service.ProductService.getById(..))", returning = "dto")
    public void logResult(ProductDTO dto) {
        log.info("Result: {}", dto);
    }

    @Around("execution(* com.vansisto.ll7shopapi.service.ProductService.*(..))")
    public Object measuringExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        log.info("Execution method: {}, wit time: {}", joinPoint.getSignature().getName(), (endTime - startTime));
        return result;
    }

}

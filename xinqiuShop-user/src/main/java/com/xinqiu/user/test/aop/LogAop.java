package com.xinqiu.user.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LogAop {

    /**
     * 定义切入点，切入点为com.lluozh.fagent.controller中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.xinqiu.user.controller..*(..))")
    public void allController() {
    }

    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("allController()")
    public void doBeforeGame(){
        System.out.println("连接点执行之前执行的通知");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("allController()")
    public void doAfterGame(){
        System.out.println("连接点执行之后执行的通知(返回通知和异常通知的异常)");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("allController()")
    public void doAfterReturningGame(){
        System.out.println("接点执行之后执行的(正常通知)");
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("allController()")
    public void doAfterThrowingGame(){
        System.out.println("接点执行之后执行的(异常通知)");
    }

    /**
     * @description 参数必须是ProceedingJoinPoint，通过该对象的proceed()方法来执行目标函数
     * proceed()的返回值就是环绕通知的返回值，proceedingJoinPoint是个接口
     * implement JoinPoint,所以也可以获得目标函数的类名，方法名等参数
     */
    @Around("allController()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String requestArgs = Arrays.toString(pjp.getArgs());
        String requestURI = request.getRequestURI();
        log.info("URI：{}, 参数:{}", requestURI, requestArgs);
        Object result = pjp.proceed();
        log.info("URI：{}, 返回: {}", requestURI, result);
        return result;
    }
}

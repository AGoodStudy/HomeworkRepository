package cn.dsh.service.cn.dsh.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志的工具类，提供了公共代码
 */
public class logger {

    /**
     * 前置通知
     */
    public void beforePrintLog() {
        System.out.println("前置通知beforePrintLog:开始记录日志.................");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog() {
        System.out.println("后置通知afterReturningPrintLog:开始记录日志.................");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog() {
        System.out.println("异常通知afterThrowingPrintLog:开始记录日志.................");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog() {
        System.out.println("最终通知afterPrintLog:开始记录日志.................");
    }

    /**
     * 环绕通知
     * 当配置了环绕通知之后，切入点方法没有执行，通知方法执行了
     * 通过对比动态代理的环绕通知
     * 动态代理中有明确的业务层切入点方法调用
     * spring为我们提供了一个接口:ProceedingJoinPonit,其中一个方法是proceed,此方法相当于明确调用切入点方法
     * 该接口可以作为环绕通知的方法参数，程序执行时，spring会提供该接口的实现类
     *
     * spring环绕通知：
     *      spring为我们提供的可以在代码中手动控制增强代码何时执行的方式
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object returnValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("环绕通知.................前置");
            returnValue = pjp.proceed(args);//调用业务层方法
            System.out.println("环绕通知.................后置");
            return returnValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知.................异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("环绕通知.................最终");
        }
    }
}

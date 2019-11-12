package cn.dsh.test;

import cn.dsh.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as = (IAccountService) ac.getBean("accountService");

        as.saveAccount();
        System.out.println("------------------------");
        System.out.println("------------------------");
        as.updateAccount(1);
        System.out.println("------------------------");
        System.out.println("------------------------");
        as.delete();
    }
}

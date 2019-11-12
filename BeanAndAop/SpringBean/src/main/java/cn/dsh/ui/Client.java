package cn.dsh.ui;

import cn.dsh.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        //ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\IdeaProject\\SpringIoc\\src\\main\\resources\\bean.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");

        as.saveAccount();

        //手动关闭容器
//        ac.close();
    }

}

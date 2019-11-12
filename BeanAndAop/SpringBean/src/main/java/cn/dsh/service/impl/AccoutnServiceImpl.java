package cn.dsh.service.impl;


import cn.dsh.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccoutnServiceImpl implements IAccountService {

    public AccoutnServiceImpl() {
        System.out.println("对象创建");
    }

    public void saveAccount() {
        System.out.println("service:saveAccount执行了");
    }

    public void init() {
        System.out.println("service:初始化了");
    }

    public void destrot() {
        System.out.println("service:销毁了");
    }
}

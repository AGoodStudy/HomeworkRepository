package cn.dsh.factory;

import cn.dsh.service.IAccountService;
import cn.dsh.service.impl.AccoutnServiceImpl;

/**
 * 模拟一个工厂类（该类可能存在于一个jar包中，我们无法通过修改源码的方式提供默认构造函数）
 */

public class Instancefactory {
    public IAccountService getAccountService() {
        return new AccoutnServiceImpl();
    }
}

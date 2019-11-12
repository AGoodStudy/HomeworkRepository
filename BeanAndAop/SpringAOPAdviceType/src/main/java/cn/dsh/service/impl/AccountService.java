package cn.dsh.service.impl;

import cn.dsh.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 业务层实现类
 */
@Service("accountService")
public class AccountService implements IAccountService {

    public void saveAccount() {
        System.out.println("保存");
    }

    public void updateAccount(int i) {
        System.out.println("更新了"+i);

    }

    public int delete() {
        System.out.println("删除");
        return 0;
    }
}

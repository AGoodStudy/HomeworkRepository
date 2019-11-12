package cn.dsh.service;

/**
 * 业务层接口
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 更新
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除
     */
    int delete();
}


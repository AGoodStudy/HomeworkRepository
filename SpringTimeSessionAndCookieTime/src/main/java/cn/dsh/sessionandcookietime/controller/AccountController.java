package cn.dsh.sessionandcookietime.controller;

import cn.dsh.sessionandcookietime.domain.Account;
import cn.dsh.sessionandcookietime.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/accountLogin")
    public Account accountLogin(@RequestBody Account loginAccount){
        Account account = new Account();
        account = accountService.findAccount(loginAccount);
        return account;
    }

    @PostMapping("/accountRegister")
    public String accountRegister(@RequestBody Account account) {
        String result = accountService.insertOne(account);
        return result;
    }

    @PostMapping("/getLastTime")
    public String getLastTime(@RequestBody Account account) {
        String result = accountService.getLastTime(account.getNumber());
        return result;
    }

    @RequestMapping("/filterUser")
    public void filterUser() {
        accountService.filterUser();
    }

    @PostMapping("/checkSession")
    public String check() {
        String check = accountService.check();
        return check;
    }
}

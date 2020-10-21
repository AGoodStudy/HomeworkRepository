package cn.dsh.shixun.service;

import cn.dsh.shixun.entity.VerCodeInfo;
import cn.dsh.shixun.utils.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;


/**
 * 发送邮箱业务层
 *
 * @author dsh
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService {

    private final VerCodeService verCodeService;

    /**
     * 管理员名字
     */
    public static final String EMAILNAME = "管理员";

    /**
     * 指明邮件的发件人
     */
    private static String EMAILFROM = "2359721314@qq.com";

    /**
     * 密码
     */
    private static String PASSWORD = "zdoowfzbfygyebhe";

    /**
     * 指明邮件的收件人
     */
    private static String MAILTO = null;

    /**
     * 邮件的标题
     */
    private static String MAILTITLE = "认真学习网通知";

    /**
     * 邮件的文本内容
     */
    private static String MAILTEXT = null;

    /**
     * 邮件的服务器域名
     */
    private static String MAILHOST = "smtp.qq.com";

    public String sendEmail(String emailAddress, String when, VerCodeInfo codeInfo) {

        int verCode = ThreadLocalRandom.current().nextInt(100000, 1000000);
        codeInfo.setVerCode(String.valueOf(verCode));

        MAILTO = emailAddress;
        MAILTEXT = "本次验证码为:" + verCode;

        Properties prop = new Properties();
        prop.setProperty("mail.host", MAILHOST);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");

        //创建邮件的session
        Session session = Session.getInstance(prop);

        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        // 2、通过session得到transport对象
        Transport ts = null;
        try {
            ts = session.getTransport();
        } catch (NoSuchProviderException e) {
            return Constant.FALSE;
        }

        try {
            // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
            ts.connect(MAILHOST, EMAILFROM, PASSWORD);

            // 4、创建邮件
            MimeMessage mail = createMail(session, EMAILFROM, MAILTO, MAILTITLE, MAILTEXT);

            // 5、发送邮件
            ts.sendMessage(mail, mail.getAllRecipients());

            ts.close();
        } catch (Exception e) {
            return Constant.FALSE;
        }

        verCodeService.addCodeInfo(emailAddress + when, codeInfo);

        return Constant.SUCCESS;
    }

    private MimeMessage createMail(Session session, String mailfrom, String mailTo, String mailTittle,
                                   String mailText) throws MessagingException {

        //创建邮件对象
        MimeMessage message = new MimeMessage(session);

        // 指明邮件的发件人
        message.setFrom(new InternetAddress(mailfrom));

        // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));

        // 邮件的标题
        message.setSubject(mailTittle);

        // 邮件的文本内容
        message.setContent(mailText, "text/html;charset=UTF-8");
        // 返回创建好的邮件对象
        return message;
    }
}

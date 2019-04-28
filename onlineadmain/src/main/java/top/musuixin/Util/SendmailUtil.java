package top.musuixin.Util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;

/**
 * @date 3.27
 * <p>
 * 发送邮箱逻辑
 */


public class SendmailUtil extends Thread {
    String toEmail;
    int code;

    public void setToemailECode(String toEmail, int code) {
        this.toEmail = toEmail;
        this.code = code;
    }
    @Override
    public void run() {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp"); // 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com"); // 主机名
        properties.put("mail.smtp.port", 465);  // 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");  // 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true"); // 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        try {
            message.setFrom(new InternetAddress("1804125652@qq.com"));
            // 设置收件人地址
            message.setRecipients(RecipientType.TO, new InternetAddress[]{new InternetAddress(toEmail)});
            // 设置邮件标题
            message.setSubject("慕随心系统验证码！");
            // 设置邮件内容
            message.setText("欢迎您注册慕随心java在线学习平台管理员！您的验证码为：" + code + "\n温馨提醒：请随意输入注册密码，本网站不进行密码保护工作！");
            // 得到邮差对象
            Transport transport = session.getTransport();
            // 连接自己的邮箱账户
            transport.connect("1804125652@qq.com", "lmtpxokrpufdcddj");// 密码为刚才得到的授权码
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

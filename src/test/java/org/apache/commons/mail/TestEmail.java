package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class TestEmail {
    public static void main(String[] args) {
        try {
            // 创建邮件对象
            Email email = new SimpleEmail();
            // 设置SMTP服务器
            email.setHostName("smtp.qq.com");
            // 设置SMTP服务器端口
            email.setSmtpPort(465);
            // 开启SSL加密
            email.setSSLOnConnect(true);
            // 设置登录SMTP服务器的用户名和密码
            email.setAuthentication("2993946158@qq.com", "tnwfdadcxmjhdhec");
            // 设置发送源邮箱
            email.setFrom("2993946158@qq.com");
            // 设置目标邮箱
            email.addTo("2411943306@qq.com");
            // 设置邮件主题
            email.setSubject("测试邮件");
            // 设置邮件内容
            email.setMsg("这是一封测试邮件，请忽略。");
            // 发送邮件
            email.send();
            System.out.println("邮件发送成功！");
        } catch (EmailException e) {
            e.printStackTrace();
            System.out.println("邮件发送失败！");
        }
    }
}

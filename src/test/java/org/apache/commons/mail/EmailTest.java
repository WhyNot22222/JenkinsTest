package org.apache.commons.mail;

import static org.junit.Assert.*;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

    private static class ConcreteEmail extends Email {
        @Override
        public Email setMsg(String msg) throws EmailException {
            this.setContent(msg, "text/plain");
            return this;
        }
    }

    private Email email;

    @Before
    public void setUp() {
        email = new ConcreteEmail();
        System.out.println("测试初始化完成，创建了一个新的 Email 实例。");
    }

    @Test
    public void testValidPort_ShouldNotThrowException() throws Exception {
        System.out.println("开始测试合法端口 25...");
        email.setSmtpPort(25);
        assertEquals("25", email.getSmtpPort());
        System.out.println("合法端口 25 测试通过。");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPort_ShouldThrowException() throws Exception {
        System.out.println("开始测试非法端口 -1...");
        email.setSmtpPort(-1);
        System.out.println("非法端口 -1 测试失败，未抛出预期异常。");
    }

    @Test
    public void testBoundaryPort1_ShouldNotThrowException() throws Exception {
        System.out.println("开始测试边界端口 1...");
        email.setSmtpPort(1);
        assertEquals("1", email.getSmtpPort());
        System.out.println("边界端口 1 测试通过。");
    }
}
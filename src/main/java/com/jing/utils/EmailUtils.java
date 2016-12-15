package com.jing.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailUtils {

	public static void sendEmail(String email, String emailMsg) throws AddressException, MessagingException {

		// 1.创建一个程序与邮件服务器会话对象Session
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");

		// 设置发送邮箱的smtp地址****
		props.setProperty("mail.host", "smtp.sina.com");

		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				// 邮箱账号密码****
				return new PasswordAuthentication("jing620139", "jingbo**906XL5");
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress("jing620139@sina.com")); // 设置发送者****

		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

		message.setSubject("用户激活");
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送
		Transport.send(message);
	}
}

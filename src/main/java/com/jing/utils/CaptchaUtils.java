package com.jing.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class CaptchaUtils {

	public static String create(OutputStream os) throws IOException {
		int width = 100;
		int height = 20;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width - 1, height - 1);
		g.setColor(Color.BLACK);
		Random rand = new Random();
		for (int i = 0; i < 4; i++) {
			int x1 = rand.nextInt(width - 1);
			int x2 = rand.nextInt(width - 1);
			int y1 = rand.nextInt(height - 1);
			int y2 = rand.nextInt(height - 1);
			g.drawLine(x1, y1, x2, y2);
		}
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		int x = 15;
		int y = 15;
		g.setColor(Color.RED);
		g.setFont(new Font("Monaco", Font.BOLD, 18));
		for (int i = 0; i < 4; i++) {
			char ch = str.charAt(rand.nextInt(str.length()));
			sb.append(ch);
			double theta = (Math.random() - 0.5) * Math.PI / 3;
			g.rotate(theta, x, y);
			g.drawString(ch + "", x, y);
			g.rotate(-theta, x, y);
			x += 20;
		}
		ImageIO.write(img, "png", os);
		os.close();
		return new String(sb);
	}

}

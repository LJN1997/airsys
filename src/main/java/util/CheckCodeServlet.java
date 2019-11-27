package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 提供验证码服务的Servlet
 * @author Administrator
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/vcode")
public class CheckCodeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//-- 1.图片的大小
		int width = 200;
		int height = 100;
		//-- 2.图片对象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//-- 3.美化图片（画笔）
		Graphics g = image.getGraphics();
		//-- 4.给画笔设置颜色
		g.setColor(Color.ORANGE);
		//-- 5.1填充矩形
		g.fillRect(0, 0, width, height);
		//-- 5.2画边框
		g.setColor(Color.white);
		g.drawRect(0, 0, width-2, height-2);
		//-- 5.3画验证码
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		//-- 随机生成4个字符
		/* String verifyCode=""; */
		StringBuilder verifyCode = new StringBuilder();
		Random r = new Random();
		g.setColor(Color.BLACK);
		g.setFont(new Font("宋体",Font.BOLD, 20));
		for (int i = 1; i <= 4; i++) {
			//-- 随机一个下标
			int index = r.nextInt(str.length());
			//-- 获取到某个下标的随机字符
			char c = str.charAt(index);
			
			//-- 画字符给定位置
			g.drawString(c+"", width/5*i, height/2);
			verifyCode.append(c);
		}
		HttpSession session = req.getSession();
		session.setAttribute("verifyCode", verifyCode.toString());
		//-- 5.4 画干扰线
		g.setColor(Color.BLUE);
		for (int i = 0; i < 10; i++) {
			int x1 = r.nextInt(width);
			int x2 = r.nextInt(width);
			
			int y1 = r.nextInt(height);
			int y2 = r.nextInt(height);
			
			g.drawLine(x1, y1, x2, y2);
		}
		//-- 6.发送给客户端
		//-- 参数1：哪张图片   参数2：图片的格式  参数3：你要通过那个流来往出发
		ImageIO.write(image, "jpg", resp.getOutputStream());
		
	}

}

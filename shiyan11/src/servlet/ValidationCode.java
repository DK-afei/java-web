package servlet;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
 
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class ValidationCode extends HttpServlet {
 
	/**
	 * ��֤����ַ����ϡ�
	 */
	private static String codeChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * �����������ɫ
	 * @param minColor
	 * @param maxColor
	 * @return
	 */
	private static Color getRandomColor(int minColor,int maxColor)
	{
		Random r = new Random();
		int red = minColor + r.nextInt(maxColor-minColor);
		int green = minColor + r.nextInt(maxColor-minColor);
		int blue = minColor + r.nextInt(maxColor-minColor);		
		return new Color(red,green,blue);
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�رտͻ���������Ļ�������
		response.setHeader("ragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Expirse", "0");
		//����ͼ�δ�С��
		int width = 111 , height = 20*2;
		//����ͼ�λ�������
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();//���	Graphics ����	
		g.setColor(getRandomColor(180, 250));//���ñ���ɫ��
		g.fillRect(0, 0, width, height);//��䱳����
		
		StringBuilder validationCode = new StringBuilder();//���ڱ���������֤��
		String[] fontNames = {"Times New Roman","Book antiqua","Arial"};//�������������ļ���
		
		Random r = new Random();
		//�������3-5����֤��
		for(int i = 0; i<3+r.nextInt(3); i++)
		{
			g.setFont(new Font(fontNames[r.nextInt(3)] , Font.ITALIC , height));
			char codeChar = codeChars.charAt(r.nextInt(codeChars.length()));
			validationCode.append(codeChar);			
			g.setColor(getRandomColor(10, 100));
			g.drawString(String.valueOf(codeChar), 16 * i+ r.nextInt(7) ,height - r.nextInt(6));//��ͼ���������֤��
		}
		//�����������
		for(int i = 0; i<30 ; i++)
		{
			g.setColor(getRandomColor(90, 200));
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			g.drawLine(x,y , x+r.nextInt(10), y+r.nextInt(5));
		}
		
		HttpSession session = request.getSession();//�õ�HttpSession����
		session.setMaxInactiveInterval(10*60);//����session����10����ʧЧ��
		session.setAttribute("validation_code", validationCode.toString());//����֤�뱣����session��
		g.dispose();//�ر�Graphics����
		OutputStream os = response.getOutputStream();//�õ������
		ImageIO.write(image, "JPEG", os);//��JPEG��ʽ��ͻ��˷���ͼ����֤��
		
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		doGet(request, response);
	}
 
}
package com.zhiyun.servlets;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            int width = 170;
            int height = 50;
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();

            g.setColor(Color.pink);
            g.fillRect(0,0,width,height);

            g.setColor(Color.black);
            g.drawRect(0,0,width-1,height-1);

            Font f = new Font("宋体", Font.BOLD, 40);
            g.setFont(f);
            g.setColor(Color.BLUE);

            StringBuilder sb = new StringBuilder();
            for (char i='a',j='A';i<='z';i++,j++){
                sb.append(i);
                sb.append(j);
            }
            for (int i=0;i<=9;i++){
                sb.append(i);
            }
            String check = "";
            String s = sb.toString();
            Random r = new Random();
            for (int i = 1; i < 5; i++) {
                int index = r.nextInt(s.length());
                String result = s.charAt(index) + "";
                g.drawString(result,width/6*i,height-height/4);
                check += result;
            }
            session.setAttribute("check",check);
            ServletOutputStream os = response.getOutputStream();
            ImageIO.write(image,"jpg",os);

//            ImageIO.write(image,"jpg",new FileOutputStream("C:/Users/13768/Desktop/aaa/a.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

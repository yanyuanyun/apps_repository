package com.zhiyun.servlets;

import com.zhiyun.dao.FindUser;
import com.zhiyun.domian.User;
import com.zhiyun.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check");
        Service service = new Service();
        User user = new User(username, password);
        User result = service.check(user);
        String check = (String) request.getSession().getAttribute("check");
        try {
            if (checkCode.equalsIgnoreCase(check)){
                if (result != null){
                    request.setAttribute("msg",user.getUsername());
                    request.getRequestDispatcher("/successLogin").forward(request,response);
    //            PrintWriter writer = response.getWriter();
    //
                }else {
                    request.getRequestDispatcher("/failLogin").forward(request,response);
                }
            }else {
                request.getRequestDispatcher("/errorcheck").forward(request,response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}

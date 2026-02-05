package com.twitter.servlet;

import com.twitter.entity.User;
import com.twitter.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "RegisterUserServlet", urlPatterns = {"/RegisterUserServlet"})
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatpassword = req.getParameter("repeatpassword");
        if(!password.equals(repeatpassword)) {
            getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(req,resp);
        }
        else{
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            HttpSession session = req.getSession();
            session.setAttribute("user",  ApplicationContext.getUserService().save(user));
            getServletContext().getRequestDispatcher("/welcome.jsp").forward(req,resp);
        }
    }
}

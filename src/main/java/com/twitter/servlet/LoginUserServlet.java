package com.twitter.servlet;


import com.twitter.entity.User;
import com.twitter.util.ApplicationContext;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginUserServlet", urlPatterns = {"/LoginUserServlet"})
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   resp.setContentType("text/html");/* تعیین نوع پاسخ */
   String user=req.getParameter("username");
   String pass=req.getParameter("password");
        HttpSession session = req.getSession();
        try {
        User loginedUser = ApplicationContext.getUserService().loginToSystem(user, pass);
        session.setAttribute("user", loginedUser);
            getServletContext().getRequestDispatcher("/welcome.jsp").forward(req,resp);
        }
       catch (NoResultException | NullPointerException e){
           getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(req,resp);
       }

    }
}

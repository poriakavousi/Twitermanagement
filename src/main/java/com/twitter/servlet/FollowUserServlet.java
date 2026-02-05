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
@WebServlet(name = "FollowUserServlet", urlPatterns = {"/FollowUserServlet"})
public class FollowUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long idUser = Long.parseLong(id);
        User followedUser = ApplicationContext.getUserService().findById(idUser);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        user.getFollowing().add(followedUser);
        ApplicationContext.getUserService().save(user);
        getServletContext().getRequestDispatcher("/showTimeLine.jsp").forward(req,resp);
    }
}

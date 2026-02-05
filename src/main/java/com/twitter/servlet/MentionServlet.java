package com.twitter.servlet;

import com.twitter.entity.Twitt;
import com.twitter.entity.User;
import com.twitter.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MentionServlet", urlPatterns = {"/MentionServlet"})
public class MentionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String twittId = req.getParameter("id");
        String userId = req.getParameter("userId");
        Long twittIdLong = Long.parseLong(twittId);
        Twitt twitt = ApplicationContext.getTwittService().findById(twittIdLong);
        HttpSession session = req.getSession();
        session.setAttribute("twitt", twitt);
        getServletContext().getRequestDispatcher("/mention.jsp").forward(req, resp);
    }
}

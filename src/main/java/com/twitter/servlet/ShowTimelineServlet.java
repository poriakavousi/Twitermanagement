package com.twitter.servlet;

import com.mysql.cj.Session;
import com.twitter.entity.Twitt;
import com.twitter.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "ShowTimelineServlet", urlPatterns = {"/ShowTimelineServlet"})
public class ShowTimelineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Twitt> twittList = ApplicationContext.getTwittService().findAll();
        System.out.println(twittList.size());
        HttpSession session = req.getSession();
        session.setAttribute("twittList", twittList);
        getServletContext().getRequestDispatcher("/showTimeLine.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Twitt> twittList = ApplicationContext.getTwittService().findAll();
        System.out.println(twittList.size());
        HttpSession session = req.getSession();
        session.setAttribute("twittList", twittList);
        getServletContext().getRequestDispatcher("/showTimeLine.jsp").forward(req,resp);
    }
}

package com.twitter.servlet;

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

@WebServlet(name = "SearchTwittServlet", urlPatterns = {"/SearchTwittServlet"})
public class SearchTwittServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchContent = req.getParameter("input-search");
        List<Twitt> twitts = ApplicationContext.getTwittService().findByContent(searchContent);
        HttpSession session = req.getSession();
        session.setAttribute("twittList", twitts);
        getServletContext().getRequestDispatcher("/showTimeLine.jsp").forward(req, resp);

    }
}

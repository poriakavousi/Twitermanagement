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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchUserServlet", urlPatterns = {"/SearchUserServlet"})
public class SearchUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user-search");
        User user = ApplicationContext.getUserService().findByUsername(username);
        List<Twitt> twittList = ApplicationContext.getTwittService().findAll();
        List<Twitt> twitts=new ArrayList<>();
        for (Twitt twitt : twittList) {
            if(twitt.getUser()==user){
               twitts.add(twitt);
            }
        }
HttpSession session = req.getSession();
        session.setAttribute("twittList", twitts);
        getServletContext().getRequestDispatcher("/showTimeLine.jsp").forward(req,resp);

    }
}

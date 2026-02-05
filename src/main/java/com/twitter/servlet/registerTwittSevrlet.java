package com.twitter.servlet;

import com.twitter.entity.Twitt;
import com.twitter.entity.User;
import com.twitter.util.ApplicationContext;
import com.twitter.util.DateAndTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registerTwittSevrlet", urlPatterns = {"/registerTwittSevrlet"})
public class registerTwittSevrlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        System.out.println("yessssssssssssssssssssssss");
        String contentTwitt = req.getParameter("contentTwitt");
        Twitt twitt = new Twitt();
        twitt.setTwittContent(contentTwitt);
        twitt.setLikeTwitt(0L);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        twitt.setUser(user);
        DateAndTime date=new DateAndTime();
        twitt.setTwittDate(date.CurrentDate());
        ApplicationContext.getTwittService().save(twitt);
getServletContext().getRequestDispatcher("/ShowTimelineServlet").forward(req,resp);

    }
}

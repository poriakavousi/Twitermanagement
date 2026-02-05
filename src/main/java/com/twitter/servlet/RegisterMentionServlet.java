package com.twitter.servlet;

import com.twitter.entity.Mention;
import com.twitter.entity.Twitt;
import com.twitter.util.ApplicationContext;
import com.twitter.util.DateAndTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "RegisterMentionServlet", urlPatterns = {"/RegisterMentionServlet"})
public class RegisterMentionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mentionContent = req.getParameter("mentionText");
        System.out.println(mentionContent);
        String twittId = req.getParameter("id");
        Long twittIdLong = Long.parseLong(twittId);
        System.out.println(twittIdLong);
        Twitt twitt = ApplicationContext.getTwittService().findById(twittIdLong);
        Mention mention = new Mention();
        mention.setMentionContent(mentionContent);
        DateAndTime time= new DateAndTime();
        mention.setMentionDate(time.CurrentDate());
        mention.setTwitt(twitt);
        ApplicationContext.getMentionService().save(mention);
        getServletContext().getRequestDispatcher("/mention.jsp").forward(req, resp);

    }
}

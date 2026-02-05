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
@WebServlet(name = "ShowPageUserServlet", urlPatterns = {"/ShowPageUserServlet"})
public class ShowPageUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        Long id = Long.parseLong(userId);
        User userSelected = ApplicationContext.getUserService().findById(id);
        List<Twitt> twittList = ApplicationContext.getTwittService().findAll();
        List<Twitt> userSelectedTwitt=new ArrayList<>();
        for (Twitt twitt : twittList) {
            if(twitt.getUser()==userSelected){
                userSelectedTwitt.add(twitt);
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("twittUserList", userSelectedTwitt);
        session.setAttribute("userSelected", userSelected);
        getServletContext().getRequestDispatcher("/showPageUser.jsp").forward(req,resp);
    }
}

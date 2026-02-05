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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowFollowerServlet", urlPatterns = {"/ShowFollowerServlet"})
public class ShowFollowerServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        Long idUser = Long.parseLong(userId);//تبدیل رشته به عدد صحیح بزرگ
        User userLogined = ApplicationContext.getUserService().findById(idUser);
        List<User> allUser = ApplicationContext.getUserService().findAll();//پیدا کردن کل کاربران
   List<User> followerList=new ArrayList<>();
       for (User user : allUser) {
          if(user.getFollowing().contains(userLogined)){
              followerList.add(user);
          }
       }
        System.out.println(followerList.size());
  HttpSession session = req.getSession();
       session.setAttribute("followerList", followerList);
        getServletContext().getRequestDispatcher("/showFollowerList.jsp").forward(req,resp);
    }
}

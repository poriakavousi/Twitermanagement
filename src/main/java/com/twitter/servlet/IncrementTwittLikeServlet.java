package com.twitter.servlet;
import com.twitter.entity.Twitt;
import com.twitter.entity.User;
import com.twitter.util.ApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IncrementTwittLikeServlet", urlPatterns = {"/IncrementTwittLikeServlet"})
public class IncrementTwittLikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String userId = req.getParameter("userId");

            // Basic validation for parameters
            if (id == null || userId == null || id.isEmpty() || userId.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing tweet or user ID.");
                return;
            }

            Long idTwitt = Long.parseLong(id);
            Long idUser = Long.parseLong(userId);

            Twitt twitt = ApplicationContext.getTwittService().findById(idTwitt);
            User user = ApplicationContext.getUserService().findById(idUser);

            if (twitt == null || user == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Tweet or user not found.");
                return;
            }

            // --- Defensive Programming: Initialize null fields ---
            // Initialize like count if it's null
            Long like = twitt.getLikeTwitt();
            if (like == null) {
                like = 0L;
            }

            // Initialize the list of users who liked the tweet if it's null
            if (twitt.getLikedTwitt() == null) {
                twitt.setLikedTwitt(new ArrayList<>());
            }

            // --- Logic for liking/unliking ---
            if (twitt.getLikedTwitt().contains(user)) {
                // User has already liked, so unlike
                like--;
                twitt.getLikedTwitt().remove(user);
            } else {
                // User has not liked yet, so like
                like++;
                twitt.getLikedTwitt().add(user);
            }
            
            twitt.setLikeTwitt(like);

            ApplicationContext.getTwittService().save(twitt);
            getServletContext().getRequestDispatcher("/ShowTimelineServlet").forward(req, resp);

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format.");
        } catch (Exception e) {
            // Log the exception and send a generic server error
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
        }
    }
}

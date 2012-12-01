package by.minsler.infokadr.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: dzmitry.misiuk
 * Date: 11/4/12
 * Time: 6:57 PM
 */
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = UserServiceFactory.getUserService();

        User user = userService.getCurrentUser();

        String forwardUrl;

        if (user == null) {
            String loginUrl = userService.createLoginURL(request.getRequestURI());
            request.setAttribute("loginUrl", loginUrl);
            forwardUrl = "/WEB-INF/jsp/login.jsp";
        } else {
            String logoutUrl = userService.createLogoutURL(request.getRequestURI());
            request.setAttribute("logoutUrl", logoutUrl);
            request.setAttribute("email", user.getEmail());

            // todo get admin user from db;
            String adminEmail = getServletContext().getInitParameter("admin");
            if (user.getEmail().equals(adminEmail) || userService.isUserAdmin()) {
                forwardUrl = "/WEB-INF/jsp/adminPanel.jsp";
            } else {
                forwardUrl = "/WEB-INF/jsp/errorLogin.jsp";
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forwardUrl);
        view.forward(request, response);
    }
}

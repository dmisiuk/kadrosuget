package by.minsler.kadrosuget.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

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

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("<h2>Admin panel</h2>");

        if(user == null){
            String loginUrl = userService.createLoginURL(request.getRequestURI());
            response.getWriter().println("<h3>Please login with google " +"<br><a href='"+loginUrl+"'>login</h3>");
        } else{
            String logoutUrl = userService.createLogoutURL(request.getRequestURI());
            response.getWriter().print("<h3>You login as " +user.getEmail() +" <br><a href='"+logoutUrl+"'>logout</h3>");
        }

        response.getWriter().println("<hr><h4><a href='/'>На главную</h4>");

    }
}

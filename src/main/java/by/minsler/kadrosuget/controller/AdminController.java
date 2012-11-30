package by.minsler.kadrosuget.controller;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        PrintWriter out = response.getWriter();

        if(user == null){
            String loginUrl = userService.createLoginURL(request.getRequestURI());
            response.getWriter().println("<h3>Please login with google " +"<br><a href='"+loginUrl+"'>login</a></h3>");
        } else{
            String logoutUrl = userService.createLogoutURL(request.getRequestURI());
            response.getWriter().print("<h3>You login as " +user.getEmail() +" <br><a href='"+logoutUrl+"'>logout</a></h3>");
            response.getWriter().print("<hr>");
            String adminEmail = getServletContext().getInitParameter("admin");
            if(user.getEmail().equals(adminEmail) || userService.isUserAdmin()){
                response.getWriter().print("Вы админ");
                response.getWriter().print("<hr>");
                String op = request.getParameter("op");
                exec(op,out);

            } else{
                response.getWriter().print("Вы обычный пользователь");
            }

        }

        response.getWriter().println("<hr><h4><a href='/'>На главную</a></h4>");

    }

    private void exec(String op, PrintWriter out) {
        if ( op == null){
            out.print("<a href='/admin?op=add'>Добавить фильм</a>");
        } else if ("add".equals(op)){
            out.print("<h4>Добавление нового фильма</h4>");
            out.print("<form action='/admin' method='get'>" +
                    "Название фильма:<input type='text' size ='50' name='name'><br>" +
                    "<input type='hidden' name='op' value='create'>" +
                    "<input type='submit' value='добавить фильм'>" +
                    "</form>");
        } else if ("create".equals(op)){
            out.print("Фильм добавлен");
        }

    }
}

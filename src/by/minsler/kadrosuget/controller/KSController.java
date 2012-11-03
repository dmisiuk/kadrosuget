package by.minsler.kadrosuget.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: dzmitry.misiuk
 * Date: 11/4/12
 * Time: 12:09 AM
 */
public class KSController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get ks from db
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/ks/result.jsp");
        view.forward(request,response);
    }
}

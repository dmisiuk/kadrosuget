package by.minsler.infokadr.controller;

import by.minsler.infokadr.json.JsonError;
import by.minsler.infokadr.json.JsonErrorResponse;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 11:40 AM
 */
public class JsonErrorServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        JsonError jsonError = new JsonError();
        Gson gson = new Gson();
        int code;

        if (user == null) {
            jsonError.setMesssage("you are not authenticated");
            code = resp.SC_UNAUTHORIZED;
        } else {
            jsonError.setMesssage("you don't have admin privileges");
            code = resp.SC_FORBIDDEN;
        }

        JsonErrorResponse jsonResponse = new JsonErrorResponse(jsonError);
        String str = gson.toJson(jsonResponse);

        resp.setContentType("application/json");
        resp.sendError(code, str);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}

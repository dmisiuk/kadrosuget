package by.minsler.infokadr.controller;

import by.minsler.infokadr.bean.Trailer;
import by.minsler.infokadr.dao.TrailerDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:39 AM
 */
public class TrailerController extends HttpServlet {

    TrailerDao dao = new TrailerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        List<Trailer> list = dao.readAllTrailers();
        out.println("<html><body>");
        out.println("Trailer:<br><ul>");
        for (Trailer tr : list) {
            out.println("<li>" + tr.description + " --  " + tr.added.toString() + "</li>");
        }
        out.println("</ul>");
        out.println("<form action='trailers' method='post' >" +
                "<input type='text' name='description'>" +
                "<input type='submit' value='save trailer'>" +
                "</form>"
        );
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Trailer tr = new Trailer();
        tr.description = description;
        tr.added = new Date();
        dao.createTrailer(tr);
        this.doGet(req, resp);
    }
}

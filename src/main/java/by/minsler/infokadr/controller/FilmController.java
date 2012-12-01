package by.minsler.infokadr.controller;

import by.minsler.infokadr.bean.Film;
import by.minsler.infokadr.dao.FilmDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:39 AM
 */
public class FilmController extends HttpServlet {

    FilmDao dao = new FilmDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        List<Film> list = dao.readAllFilms();
        out.println("<html><body>");
        out.println("Films:<br><ul>");
        for (Film film : list) {
            out.println("<li>" + film.engName + "</li>");
        }
        out.println("</ul>");
        out.println("<form action='films' method='post' >" +
                "<input type='text' name='name'>" +
                "<input type='submit' value='save film'>" +
                "</form>"
        );
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Film film = new Film();
        film.engName = name;
        dao.createFilm(film);
        this.doGet(req, resp);
    }
}

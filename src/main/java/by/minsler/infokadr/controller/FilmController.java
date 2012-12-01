package by.minsler.infokadr.controller;

import by.minsler.infokadr.bean.Film;
import by.minsler.infokadr.dao.FilmDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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

        String id = req.getParameter("id");
        System.out.println("film id: " + id);

        String forwardUrl = "/WEB-INF/jsp/films.jsp";

        if (id != null) {
            try {
                int lid = Integer.valueOf(id);
                Film film = dao.readFilm(lid);
                forwardUrl = "/WEB-INF/jsp/film.jsp";
                req.setAttribute("film", film);
            } catch (NumberFormatException e) {
                System.out.println("error parse id");
                List<Film> list = dao.readAllFilms();
                req.setAttribute("list", list);
            }
        } else {
            List<Film> list = dao.readAllFilms();
            req.setAttribute("list", list);
        }
        RequestDispatcher view = req.getRequestDispatcher(forwardUrl);
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String engName = req.getParameter("engName");
        String rusName = req.getParameter("rusName");

        Film film = new Film();
        film.engName = engName;
        film.rusName = rusName;
        film.added = new Date();

        dao.createFilm(film);
        resp.sendRedirect("/films");
    }
}

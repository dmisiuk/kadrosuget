package by.minsler.infokadr.controller;

import by.minsler.infokadr.dao.FilmDao;
import by.minsler.infokadr.dto.FilmDto;
import by.minsler.infokadr.service.RpcServiceImpl;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 1:39 AM
 */
public class VideoController extends HttpServlet {

    private RpcServiceImpl service = new RpcServiceImpl();

    FilmDao dao = new FilmDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        FilmDto fdto = service.getFilmDto(key);

        Gson gson = new Gson();
        String str = gson.toJson(fdto);

        req.setAttribute("film", str);
        RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/jsp/video.jsp");
        view.forward(req, resp);

    }
}

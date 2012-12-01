package by.minsler.infokadr.controller;

import by.minsler.infokadr.service.AdminService;
import by.minsler.infokadr.service.AdminServiceImpl;
import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.googlecode.jsonrpc4j.ProxyUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServiceController extends HttpServlet {

    private JsonRpcServer jsonRpcServer;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        jsonRpcServer.handle(request, response);
    }

    @Override
    public void init(ServletConfig config) {
        AdminService service = new AdminServiceImpl();

        Object[] services = new Object[]{service};
        Class[] serviceClasses = new Class[]{AdminService.class};
        Object compositeService = ProxyUtil.createCompositeServiceProxy(
                this.getClass().getClassLoader(), services, serviceClasses, true
        );

        this.jsonRpcServer = new JsonRpcServer(compositeService);
    }
}
package by.minsler.infokadr.filter;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: dzmitry.misiuk
 * Date: 12/1/12
 * Time: 11:18 AM
 */
public class AdminRpcFilter implements Filter {

    private String adminEmail;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        adminEmail = filterConfig.getInitParameter("admin");
        System.out.println("admin email " + adminEmail);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        System.out.println("current user " + user);

        if (user != null) {
            if (user.getEmail().equals(adminEmail) || userService.isUserAdmin()) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        System.out.println("forward to error");
        RequestDispatcher eror = request.getRequestDispatcher("/admin/jsonrpcerror");
        eror.forward(request, response);

    }

    @Override
    public void destroy() {

    }
}

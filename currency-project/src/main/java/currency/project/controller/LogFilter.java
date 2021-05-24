package currency.project.controller;

import currency.project.dao.AdminDaoImp;
import currency.project.db.Permission;
import currency.project.model.Admin;
import currency.project.service.AdminService;
import currency.project.service.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class LogFilter implements Filter {
    private AdminService adminService;

    public LogFilter() {
        adminService = new AdminServiceImpl(new AdminDaoImp());
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("LogFilter init!");
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String servletPath = req.getServletPath();
        for (String url : Permission.adminPermission) {
            if (url.equals(servletPath)) {
                if (req.getSession().getAttribute("admin") == null) {
                    resp.sendRedirect(req.getContextPath() + "/login");
                    return;
                }
            }
        }
        if (servletPath.equals("/login")) {
            String login = request.getParameter("username");
            String password = request.getParameter("password");
            if (login != null) {
                Optional<Admin> admin = adminService.getByLogin(login);
                if (admin.isPresent()) {
                    if (admin.get().getPassword().equals(password)) {
                        req.getSession().setAttribute("admin", login);
                        resp.sendRedirect(req.getContextPath() + "/currencies");
                        return;
                    }
                }
                req.setAttribute("error", true);
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
                return;
            }
        }
        if (servletPath.equals("/logout")) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/currencies");
            return;
        }
        chain.doFilter(request, response);
    }
}
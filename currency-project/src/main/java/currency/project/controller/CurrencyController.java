package currency.project.controller;

import currency.project.dao.CurrencyDaoImpl;
import currency.project.model.Currency;
import currency.project.service.CurrencyService;
import currency.project.service.CurrencyServiceImpl;
import currency.project.service.DataParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;

public class CurrencyController extends HttpServlet {
    private CurrencyService currencyService;

    public CurrencyController() {
        currencyService = new CurrencyServiceImpl(new CurrencyDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        resp.sendRedirect(req.getContextPath() + "/currency?id=" + id + "&from=" + from + "&to=" + to);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        LocalDate from = DataParser.parse(req.getParameter("from"));
        LocalDate to = DataParser.parse(req.getParameter("to"));
        //Added exception handler for NoSuchElementException
        try {
            Map<LocalDate, Double> map = currencyService.getByDate(id, from, to);
            Currency currency = currencyService.getById(id);
            req.setAttribute("currency", currency);
            req.setAttribute("map", map);
        } catch (NoSuchElementException e) {
            resp.sendRedirect(req.getContextPath() + "/currencies");
            return;
        }
        Object admin = req.getSession().getAttribute("admin");
        if (admin != null) {
            req.setAttribute("admin", true);
        }
        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.getRequestDispatcher("/WEB-INF/views/currencyPage.jsp").forward(req, resp);
    }
}

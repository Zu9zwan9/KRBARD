package currency.project.controller;

import currency.project.dao.CurrencyDaoImpl;
import currency.project.service.CurrencyService;
import currency.project.service.CurrencyServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class GetAllCurrencyController extends HttpServlet {
    private CurrencyService currencyService;

    public GetAllCurrencyController() {
        currencyService = new CurrencyServiceImpl(new CurrencyDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Object admin = req.getSession().getAttribute("admin");
        if (admin != null) {
            req.setAttribute("admin", true);
        }
        req.setAttribute("currencies", currencyService.getAll());
        req.setAttribute("currentDate", LocalDate.now());

        req.getRequestDispatcher("/WEB-INF/views/currenciesPage.jsp").forward(req, resp);
    }
}

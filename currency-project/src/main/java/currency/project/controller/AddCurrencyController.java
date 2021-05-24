package currency.project.controller;

import currency.project.dao.CurrencyDaoImpl;
import currency.project.model.Currency;
import currency.project.service.CurrencyService;
import currency.project.service.CurrencyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCurrencyController extends HttpServlet {
    private CurrencyService currencyService;

    public AddCurrencyController() {
        currencyService = new CurrencyServiceImpl(new CurrencyDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        Currency currency = new Currency();
        currency.setFrom(from);
        currency.setTo(to);
        if (id != null && !id.equals("")) {
            currency.setId(Integer.parseInt(id));
            currencyService.update(currency);
        } else {
            currencyService.create(currency);
        }
        resp.sendRedirect(req.getContextPath() + "/currencies");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Currency currency = currencyService.getById(Integer.valueOf(id));
            req.setAttribute("id", id);
            req.setAttribute("from", currency.getFrom());
            req.setAttribute("to", currency.getTo());
        }
        req.getRequestDispatcher("/WEB-INF/views/currencyAdd.jsp").forward(req, resp);
    }
}

package currency.project.controller;

import currency.project.dao.CurrencyDaoImpl;
import currency.project.service.CurrencyService;
import currency.project.service.CurrencyServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCurrencyController extends HttpServlet {
    private CurrencyService currencyService;

    public DeleteCurrencyController() {
        currencyService = new CurrencyServiceImpl(new CurrencyDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (id != null) {
            currencyService.delete(Integer.parseInt(id));
        }
        resp.sendRedirect(req.getContextPath() + "/currencies");
    }
}

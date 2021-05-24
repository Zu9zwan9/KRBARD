package currency.project.controller;

import currency.project.dao.CurrencyDaoImpl;
import currency.project.service.CurrencyService;
import currency.project.service.CurrencyServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AddCurrencyRateController extends HttpServlet {
    private CurrencyService currencyService;

    public AddCurrencyRateController() {
        currencyService = new CurrencyServiceImpl(new CurrencyDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String date = req.getParameter("date");
        Double value = Double.parseDouble(req.getParameter("value"));
        currencyService.addRateToCurrency(id, date, value);
        resp.sendRedirect(req.getContextPath() + "/currency?id=" + id + "&from=" + LocalDate.now()
                + "&to=" + LocalDate.now());
    }
}

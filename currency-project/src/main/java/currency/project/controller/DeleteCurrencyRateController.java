package currency.project.controller;

import currency.project.dao.CurrencyDaoImpl;
import currency.project.service.CurrencyService;
import currency.project.service.CurrencyServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class DeleteCurrencyRateController extends HttpServlet {
    private CurrencyService currencyService;

    public DeleteCurrencyRateController() {
        currencyService = new CurrencyServiceImpl(new CurrencyDaoImpl());
    }
// удаляет за конкретный день
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String date = req.getParameter("date");
        currencyService.deleteRateAtCurrency(id, date);
        resp.sendRedirect(req.getContextPath() + "/currency?id=" + id + "&from=" + LocalDate.now()
                + "&to=" + LocalDate.now());
    }
}

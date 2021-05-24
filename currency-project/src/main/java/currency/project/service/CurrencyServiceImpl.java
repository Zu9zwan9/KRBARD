package currency.project.service;

import currency.project.dao.CurrencyDao;
import currency.project.dao.CurrencyDaoImpl;
import currency.project.model.Currency;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyDao currencyDao;

    public CurrencyServiceImpl(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }


    @Override
    public void create(Currency currency) {
        currencyDao.create(currency);
    }

    @Override
    public void update(Currency currency) {
        currencyDao.update(currency);
    }

    @Override
    public void delete(Integer id) {
        currencyDao.delete(id);
    }

    @Override
    public Set<Currency> getAll() {
        return currencyDao.getAll();
    }

    @Override
    public Currency getById(Integer id) {
        return currencyDao.getById(id);
    }

    @Override
    public Map<LocalDate, Double> getByDate(Integer id, LocalDate from, LocalDate to) {
        return currencyDao.getByDate(id, from, to);
    }

    @Override
    public void addRateToCurrency(Integer id, String date, Double value) {
        Currency currency = currencyDao.getById(id);
        LocalDate localDate = DataParser.parse(date);
        currency.getDateValue().put(localDate, value);
    }

    public void deleteRateAtCurrency(Integer id, String date) {
        Currency currency = currencyDao.getById(id);
        LocalDate localDate = DataParser.parse(date);
        currency.getDateValue().remove(localDate);
    }
}

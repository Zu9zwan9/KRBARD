package currency.project.service;

import currency.project.model.Currency;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public interface CurrencyService {
    void create(Currency currency);

    void update(Currency currency);

    void delete(Integer id);

    Set<Currency> getAll();

    Currency getById(Integer id);

    Map<LocalDate, Double> getByDate(Integer id, LocalDate from, LocalDate to);

    void addRateToCurrency(Integer id, String date, Double value);

    void deleteRateAtCurrency(Integer id, String date);
}

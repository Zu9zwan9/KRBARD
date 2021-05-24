package currency.project.dao;

import currency.project.model.Currency;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public interface CurrencyDao {
    Currency create(Currency currency);

    Currency update(Currency currency);

    void delete(Integer id);

    Set<Currency> getAll();

    Currency getById(Integer id);

    Map<LocalDate, Double> getByDate(Integer id, LocalDate from, LocalDate to);
}

package currency.project.dao;

import currency.project.db.InMemoryDb;
import currency.project.model.Currency;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CurrencyDaoImpl implements CurrencyDao {
    @Override
    public currency.project.model.Currency create(currency.project.model.Currency currency) {
        Integer index = InMemoryDb.findLastCurrenciesIndex();
        currency.setId(index);
        InMemoryDb.currencies.add(currency);
        return currency;
    }

    @Override
    public currency.project.model.Currency update(currency.project.model.Currency currency) {
        currency.project.model.Currency currentCurrency = InMemoryDb.findCurrencyById(currency.getId());
        currentCurrency.setFrom(currency.getFrom());
        currentCurrency.setTo(currency.getTo());
        return currentCurrency;
    }

    @Override
    public void delete(Integer id) {
        currency.project.model.Currency currentCurrency = InMemoryDb.findCurrencyById(id);
        InMemoryDb.currencies.remove(currentCurrency);
    }

    @Override
    public Set<currency.project.model.Currency> getAll() {
        return InMemoryDb.currencies;
    }

    @Override
    public currency.project.model.Currency getById(Integer id) {
       return InMemoryDb.findCurrencyById(id);
    }

    @Override
    public Map<LocalDate, Double> getByDate(Integer id, LocalDate from, LocalDate to) {
        Currency currency = InMemoryDb.findCurrencyById(id);
        return currency.getDateValue().entrySet()
                .stream()
                .filter(entry -> (entry.getKey().isAfter(from)|| entry.getKey().equals(from))
                        && (entry.getKey().isBefore(to) || entry.getKey().equals(to)))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

}

package currency.project.db;

import currency.project.model.Admin;
import currency.project.model.Currency;

import java.time.LocalDate;
import java.util.*;

public class InMemoryDb {
    public static Set<Admin> admins = new HashSet<>();
    public final static Set<Currency> currencies = new HashSet<>();
    private static Integer lastIndex = 0;

    static {
        admins.add(new Admin("admin", "admin"));

        Currency currency = new Currency();
        currency.setId(lastIndex++);
        currency.setFrom("USD");
        currency.setTo("UAH");
        Map<LocalDate, Double> map = new HashMap<>();
        map.put(LocalDate.now(), 28.21);
        map.put(LocalDate.of(2021, 04, 24), 28.00);
        map.put(LocalDate.of(2021, 04, 20), 27.85);
        currency.setDateValue(map);

        Currency currency1 = new Currency();
        currency1.setId(lastIndex++);
        currency1.setFrom("USD");
        currency1.setTo("NIS");
        Map<LocalDate, Double> map1 = new HashMap<>();
        map1.put(LocalDate.now(), 3.35);
        map1.put(LocalDate.of(2021, 04, 20), 3.19);
        currency1.setDateValue(map1);
        currencies.add(currency);
        currencies.add(currency1);
    }

    public static Integer findLastCurrenciesIndex() {
        return lastIndex++;
    }

    public static Currency findCurrencyById(Integer id) {
        return currencies.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find currency by id" + id));
    }
}


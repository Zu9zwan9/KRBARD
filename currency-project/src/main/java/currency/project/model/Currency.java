package currency.project.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Currency {
    private Integer id;
    private String from;
    private String to;
    private Map<LocalDate, Double> dateValue;

    public Currency() {
        dateValue = new HashMap<>();
    }

    public Currency(Integer id, String from, String to) {
        this.id = id;
        this.from = from;
        this.to = to;
        dateValue = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<LocalDate, Double> getDateValue() {
        return dateValue;
    }

    public void setDateValue(Map<LocalDate, Double> dateValue) {
        this.dateValue = dateValue;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(id, currency.id)
                && Objects.equals(from, currency.from)
                && Objects.equals(to, currency.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to);
    }
}

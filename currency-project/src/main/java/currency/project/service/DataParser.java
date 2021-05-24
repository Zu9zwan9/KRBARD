package currency.project.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataParser {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static LocalDate parse(String text) {
        return LocalDate.parse(text, formatter);
    }
}

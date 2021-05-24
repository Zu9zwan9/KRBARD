package currency.project.dao;

import currency.project.model.Admin;

import java.util.Optional;

public interface AdminDao {
    Optional<Admin> getByLogin(String login);
}

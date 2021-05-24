package currency.project.service;

import currency.project.model.Admin;

import java.util.Optional;

public interface AdminService {
    Optional<Admin> getByLogin(String login);
}

package currency.project.dao;

import currency.project.db.InMemoryDb;
import currency.project.model.Admin;

import java.util.Optional;

public class AdminDaoImp implements AdminDao {
    @Override
    public Optional<Admin> getByLogin(String username) {
        return InMemoryDb.admins
                .stream()
                .filter(admin -> admin.getUsername().equals(username))
                .findFirst();
    }
}

package currency.project.service;

import currency.project.dao.AdminDao;
import currency.project.model.Admin;

import java.util.Optional;

public class AdminServiceImpl implements AdminService{
    private AdminDao adminDao;

    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Optional<Admin> getByLogin(String login) {
        return adminDao.getByLogin(login);
    }
}

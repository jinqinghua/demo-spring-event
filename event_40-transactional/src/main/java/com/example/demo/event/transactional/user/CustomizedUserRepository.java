package com.example.demo.event.transactional.user;

public interface CustomizedUserRepository {

    void saveWithTransactionRollback(User user);

}

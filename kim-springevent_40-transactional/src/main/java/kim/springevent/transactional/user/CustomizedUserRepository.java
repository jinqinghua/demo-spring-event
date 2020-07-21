package kim.springevent.transactional.user;

public interface CustomizedUserRepository {

    void saveWithTransactionRollback(User user);

}

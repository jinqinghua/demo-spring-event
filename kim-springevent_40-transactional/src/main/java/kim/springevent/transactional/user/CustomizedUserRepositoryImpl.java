package kim.springevent.transactional.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomizedUserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public void saveWithTransactionRollback(User user) {
        jdbcTemplate.update("insert into event_transactional_user (name) values (?)", user.getName());
        jdbcTemplate.update("insert into event_transactional_user (name) values (?)", user.getName() + "xxx");

        throw new RuntimeException("for transaction rollback");
    }
}

package kim.springevent.transactional;

import kim.springevent.transactional.user.User;
import kim.springevent.transactional.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EventTransactionalApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user;

        user = User.builder().name("name1").build();
        userService.save(user);

        user = User.builder().name("name2").build();
        userService.saveWithTransactionRollback(user);

    }

}

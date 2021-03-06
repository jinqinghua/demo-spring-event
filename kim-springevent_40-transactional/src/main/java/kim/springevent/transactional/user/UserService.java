package kim.springevent.transactional.user;

import kim.springevent.transactional.EventPublisher;
import kim.springevent.transactional.listener.UserChangedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user) {
        User savedUser = userRepository.save(user);
        eventPublisher.publishEvent(new UserChangedEvent(this, savedUser));
    }

    @Transactional
    public void saveWithTransactionRollback(User user) {
        userRepository.saveWithTransactionRollback(user);
        eventPublisher.publishEvent(new UserChangedEvent(this, user));
    }


}

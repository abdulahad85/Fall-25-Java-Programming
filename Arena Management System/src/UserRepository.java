

import java.util.Optional;

public class UserRepository extends GenericRepositry<User> {

    public Optional<User> findByUsername(String username) {
        return findOne(u -> u.getUsername().equalsIgnoreCase(username));
    }

    public boolean exists(String username) {
        return findByUsername(username).isPresent();
    }
}

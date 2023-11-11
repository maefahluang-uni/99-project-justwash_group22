package th.mfu.repository;

import java.util.Collection;
import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    th.mfu.domain.User get(String username);

    void remove(String username);

    boolean containsKey(String username);

    void put(String username, th.mfu.domain.User user);

    Collection<th.mfu.domain.User> values();

    void save(Iterable<S> user);

}

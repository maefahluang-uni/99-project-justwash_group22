package th.mfu.repository;

import java.util.Collection;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> refs/remotes/origin/main

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

<<<<<<< HEAD
    th.mfu.domain.User get(String username);

    void remove(String username);

    boolean containsKey(String username);

    void put(String username, th.mfu.domain.User user);

    Collection<th.mfu.domain.User> values();

    void save(Iterable<S> user);
=======
     void put(String username, User user);

    Collection<org.apache.tomcat.jni.User> values();

    User get(String username);

    boolean containsKey(String username);

    void remove(String username); 
>>>>>>> refs/remotes/origin/main

}

package th.mfu.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

     void put(String username, User user);

    Collection<org.apache.tomcat.jni.User> values();

    User get(String username);

    boolean containsKey(String username);

    void remove(String username); 

}

package th.mfu.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.User;

public interface UserRepository extends CrudRepository<User,Integer>{

    void put(String username, User user);

    Collection<User> values();

    User get(String username);

    boolean containsKey(String username);

    void remove(String username);

    Object findByReservationId(Integer id);

    List<org.apache.tomcat.jni.User> findByBookedFalseAndReservationId(Integer reservationId);
}

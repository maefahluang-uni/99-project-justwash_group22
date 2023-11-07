package th.mfu.repository;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByReservationId(Integer reservationId);

    public List<User> deleteByReservationId(Integer id);

    public List<User> findByBookedFalseAndReservationId(Integer reservationId);

    public List<User> findByBookedTrueAndReservationId(Integer reservationId);

    public List<User> findByBookedTrue();

    public void save(th.mfu.domain.User user);

}

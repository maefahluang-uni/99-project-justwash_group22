package th.mfu.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.User;

public interface UserRepository extends CrudRepository<User,Integer>{

    void put(String username, User user);

    Collection<User> values();

    User get(String username);

    boolean containsKey(String username);

    void remove(String username); 
}

/*public class UserRepository {

    public boolean containsKey(String username) {
        return false;
    }

    public void put(String username, User user) {
    }

    public Collection<User> values() {
        return null;
    }

    public User get(String username) {
        return null;
    }

    public void remove(String username) {
    }

} */

// ทิ้งไว้ก่อนเด้อ
/*
 * package th.mfu;
 * 
 * import java.util.List;
 * 
 * import org.apache.tomcat.jni.User;
 *import org.springframework.data.repository.CrudRepository;
 * 
 * import th.mfu.domain.User;
 * 
 * public interface UserRepository extends CrudRepository<User, Integer> {
 * public List<User> findByWashingMachineId(Integer washingmachineId);
 * public List<User> deleteByWashingMachineId(Integer id);
 * public List<User> findByBookedFalseAndWashingMachineId(Long concertId);
 * public List<User> findByBookedTrueAndWashingMachineId(Long concertId);
 * public List<User> findByBookedTrue();
 * 
 * }
 */


package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;
 
import th.mfu.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}

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


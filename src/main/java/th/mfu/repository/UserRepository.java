package th.mfu.repository;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    void save(th.mfu.domain.User user);

}

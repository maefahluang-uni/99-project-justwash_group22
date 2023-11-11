package th.mfu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    // public List<User> findBywashId(Long washId);
    // public List<User> deleteBywashId(long id);
    // public List<User> findByBookedFalseAndwashId(Long washId);
    // public List<User> findByBookedTrueAndwashId(Long washId);
    // public List<User> findByBookedTrue();
}

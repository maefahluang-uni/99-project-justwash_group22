package th.mfu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.User;
import th.mfu.domain.WashingMachine;

public interface WashingMachineRepository extends CrudRepository<WashingMachine ,Long > {
    public List<WashingMachine> findByWashingMachineId(Long washId);
    public List<WashingMachine> deleteByWashingMachineId(long id);
    public List<WashingMachine> findByBookedFalseAndId(Long id);
    public List<WashingMachine> findByBookedTrueAndId(Long id);
    public List<WashingMachine> findByBookedTrue();
}

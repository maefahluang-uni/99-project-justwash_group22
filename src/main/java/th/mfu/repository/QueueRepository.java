package th.mfu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Queue;

public interface QueueRepository extends CrudRepository<Queue, Long>{
    public List<Queue> findByWashingMachineId(Long washingMachineId);
    public List<Queue> deleteByWashingMachineId(long id);
    public List<Queue> findByBookedFalseAndWashingMachineId(Long washingMachineId);
    public List<Queue> findByBookedTrueAndWashingMachineId(Long washingMachineId);
    public List<Queue> findByBookedTrue();
}

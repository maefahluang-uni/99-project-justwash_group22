package th.mfu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Queue;

public interface QueueRepository extends CrudRepository<Queue, Long>{
    public List<Queue> findByMachineId(Long machineId);
    public List<Queue> deleteByMachineId(Long id);
    public List<Queue> findByBookedFalseAndMachineId(Long machineId);
    public List<Queue> findByBookedTrueAndMachineId(Long machineId);
    public List<Queue> findByBookedTrue();
    public List<Queue> findByBookedFalse();

}

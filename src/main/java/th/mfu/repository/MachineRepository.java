package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.Machine;


public interface MachineRepository extends CrudRepository<Machine, Long> {
      
}
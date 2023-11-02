package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.WashingMachine;

public interface WashingMachineRepository extends CrudRepository<WashingMachine, Integer> {

}

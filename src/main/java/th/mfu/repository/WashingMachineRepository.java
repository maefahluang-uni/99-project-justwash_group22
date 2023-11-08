package th.mfu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.WashingMachine;

public interface WashingMachineRepository extends CrudRepository<WashingMachine, Integer> {

    public List<WashingMachine> findByBookedFalseAndReservationId(Integer reservationId);

    public List<WashingMachine> findByBookedTrueAndReservationId(Integer reservationId);

    public List<WashingMachine> deleteByReservationId(Integer id);

    public List<WashingMachine> findByReservationId(Integer id);

    public List<WashingMachine> findByBookedTrue();

}

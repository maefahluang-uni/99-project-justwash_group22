package th.mfu.domain;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


//TODO: add proper annotation
@Entity
public class Queue {

    //TODO: add proper annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private boolean booked;
    private Date date;
    private Time time;
    private String w_status;

    //TODO: add proper annotation for relationship to concert
    @OneToMany(mappedBy = "queue", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    public Queue (){
    }

    public Queue(Long id, String username, boolean booked, Date date, Time time, String w_status,
            List<Reservation> reservations, Machine machine) {
        this.id = id;
        this.username = username;
        this.booked = booked;
        this.date = date;
        this.time = time;
        this.w_status = w_status;
        this.reservations = reservations;
        this.machine = machine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getW_status() {
        return w_status;
    }

    public void setW_status(String w_status) {
        this.w_status = w_status;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    

    

}

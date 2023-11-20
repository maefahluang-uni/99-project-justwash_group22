package th.mfu.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
    private String w_status;

    //TODO: add proper annotation for relationship to concert
    @ManyToOne(cascade = CascadeType.MERGE)
    private Machine machine;

    public Queue (){
    }

    public Queue(Long id, String username, boolean booked, Date date, String w_status, Machine machine) {
        this.id = id;
        this.username = username;
        this.booked = booked;
        this.date = date;
        this.w_status = w_status;
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

    public String getW_status() {
        return w_status;
    }

    public void setW_status(String w_status) {
        this.w_status = w_status;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Queue getQueue() {
        return null;
    }

    public void setQueue(Queue queue) {
    }

}

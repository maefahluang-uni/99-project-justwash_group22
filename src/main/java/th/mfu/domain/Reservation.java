package th.mfu.domain;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//TODO: add proper annotation
@Entity
public class Reservation {
    
    //TODO: add proper annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Date date;
    private LocalTime time;
    //TODO: add proper annotation for relationship to seat ka
    @ManyToOne
    @JoinColumn(name = "queue_id")
    private Queue queue;
    
    
    public Reservation(Long id, String username, Date date, LocalTime time, Queue queue) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.time = time;
        this.queue = queue;
    }
    public Reservation(){
        
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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    public Queue getQueue() {
        return queue;
    }
    public void setQueue(Queue queue) {
        this.queue = queue;
    }
    
    
}

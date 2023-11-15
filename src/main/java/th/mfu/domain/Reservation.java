package th.mfu.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    //TODO: add proper annotation for relationship to seat
    @OneToOne(cascade = CascadeType.MERGE)
    private Queue queue;
    
    public Reservation(Long id, String username, Date date, Queue queue) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.queue = queue != null ? queue : new Queue();
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
    public Queue getQueue() {
        return queue;
    }
    public void setQueue(Queue queue) {
        this.queue = queue;
    }
    
}

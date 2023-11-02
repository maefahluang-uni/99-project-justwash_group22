package th.mfu.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date rejected_time;
    private Date start_time;
    private Date end_time;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "seat_id")
    private Notifications Notifications;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRejected_time() {
        return rejected_time;
    }

    public void setRejected_time(Date rejected_time) {
        this.rejected_time = rejected_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

}

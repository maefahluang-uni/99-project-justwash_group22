package th.mfu.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String username;
    private String password;
    private String email;

    // public Reservation(Long id, Date date, String reserve_username, String reserve_password, String reserve_email,User user) {
    //     this.id = id;
    //     this.date = date;
    //     username = reserve_username;
    //     password = reserve_password;
    //     email = reserve_email;
    //     this.user = user;
    // }

    @OneToOne(cascade = CascadeType.MERGE)
    private Queue queue;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Queue getQueue() {
        return queue;
    }
    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    
    
}

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
    private String Reserve_username;
    private String Reserve_password;
    private String Reserve_email;
    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    public Reservation(Long id, Date date, String reserve_username, String reserve_password, String reserve_email,
            User user) {
        this.id = id;
        this.date = date;
        Reserve_username = reserve_username;
        Reserve_password = reserve_password;
        Reserve_email = reserve_email;
        this.user = user;
    }
    public Reservation (){

    }

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

    public String getReserve_username() {
        return Reserve_username;
    }

    public void setReserve_username(String reserve_username) {
        Reserve_username = reserve_username;
    }

    public String getReserve_password() {
        return Reserve_password;
    }

    public void setReserve_password(String reserve_password) {
        Reserve_password = reserve_password;
    }

    public String getReserve_email() {
        return Reserve_email;
    }

    public void setReserve_email(String reserve_email) {
        Reserve_email = reserve_email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

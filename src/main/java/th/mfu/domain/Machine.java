package th.mfu.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//TODO: add proper annotation ka
@Entity
public class Machine {

    //TODO: add proper annotation 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String capacity;
    private  String price;
    private String w_time;
    private String m_status;
    private Date date;

    //TODO: add proper annotation
    // @OneToOne(cascade = CascadeType.ALL)
    // private Performer performer;
    
    

    public Machine() {
    }

    public Machine(Long id, String capacity, String price, String w_time, String m_status, Date date) {
        this.id = id;
        this.capacity = capacity;
        this.price = price;
        this.w_time = w_time;
        this.m_status = m_status;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getW_time() {
        return w_time;
    }

    public void setW_time(String w_time) {
        this.w_time = w_time;
    }

    public String getM_status() {
        return m_status;
    }

    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    

}

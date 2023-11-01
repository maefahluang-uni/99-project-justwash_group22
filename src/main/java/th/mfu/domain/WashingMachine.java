package th.mfu.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//@Entity
public class WashingMachine {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_num")
    private Reservation reservation;
    */
    private int id;
    private String code;
    private String status;
    private String capacity;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

   
    
    

}
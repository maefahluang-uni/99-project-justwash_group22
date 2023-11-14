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
    private String name;
    private String capacity;
    private Date date;
    private  int price;

    //TODO: add proper annotation
    // @OneToOne(cascade = CascadeType.ALL)
    // private Performer performer;
    
    

    public Machine() {
    }

    

    public Machine(Long id, String name, String capacity, Date date, int price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.date = date;
        this.price = price;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getCapacity() {
        return capacity;
    }



    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }



    public Date getDate() {
        return date;
    }



    public void setDate(Date date) {
        this.date = date;
    }



    public int getPrice() {
        return price;
    }



    public void setPrice(int price) {
        if (capacity == "15") {
            price = 30;
        } else if (capacity == "20") {
            price = 45;
        }
        this.price = price;
    }



    
}

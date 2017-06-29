package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by mhi on 19/06/17.
 */
@Entity
public class Esquina_CSV {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private String bairro;
    @ManyToOne
    private String rua1;
    @ManyToOne
    private String rua2;
    private double longitude;
    private double latitude;

    public long getId() {
        return id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua1() {
        return rua1;
    }

    public void setRua1(String rua1) {
        this.rua1 = rua1;
    }

    public String getRua2() {
        return rua2;
    }

    public void setRua2(String rua2) {
        this.rua2 = rua2;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public static Model.Find<Long,Esquina_CSV> find = new Model.Find<Long,Esquina_CSV>(){};
}

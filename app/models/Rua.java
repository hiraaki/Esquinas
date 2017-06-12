package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mhi on 12/06/17.
 */
@Entity
public class Rua extends Model {
    @Id
    @GeneratedValue
    private long id;
    private String Nome;


    public long getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public static Find<Long,Bairro> find = new Find<Long,Bairro>(){};
}

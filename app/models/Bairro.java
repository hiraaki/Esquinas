package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mhi on 12/06/17.
 */
@Entity
public class Bairro extends Model {
    @Id
    @GeneratedValue
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public static Find<Long,Bairro> find = new Find<Long,Bairro>(){};
}

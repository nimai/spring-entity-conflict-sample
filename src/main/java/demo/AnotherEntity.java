package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nicolas Maitre
 * @since 23/11/18.
 */
@Entity
@Table(name="anothertablename")
public class AnotherEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "coucou")
    private String coucou;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoucou() {
        return coucou;
    }

    public void setCoucou(String coucou) {
        this.coucou = coucou;
    }
}

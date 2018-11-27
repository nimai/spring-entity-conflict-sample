package com.example.demo.domain;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

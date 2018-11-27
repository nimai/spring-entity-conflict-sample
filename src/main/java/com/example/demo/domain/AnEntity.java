package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Nicolas Maitre
 * @since 23/11/18.
 */
@Entity
@Table(name = "tablename")
public class AnEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "another_id", nullable = true)
    private AnotherEntity anotherEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnotherEntity getAnotherEntity() {
        return anotherEntity;
    }

    public void setAnotherEntity(AnotherEntity anotherEntity) {
        this.anotherEntity = anotherEntity;
    }
}

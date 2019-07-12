package com.mti.model.data;


import javax.persistence.*;

@Entity
@Table(name = "bus_line")
public class BusLineModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "`number`", length = 11, nullable = false)
    private Integer number;

    public BusLineModel() {
    }

    public BusLineModel(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}

package com.mti.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bus_line")
public class LineModel extends Model {

    @Column(name = "number", length = 11, unique = true, nullable = false)
    private int number;

    public LineModel() {
    }

    public LineModel(int number) {
        this.number = number;
    }
}

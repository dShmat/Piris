package by.shmat.lab1.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class City {

    @PrimaryKey
    public int id;

    public String cityName;
}

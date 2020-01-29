package by.shmat.lab1.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Disability {

    @PrimaryKey
    public int id;

    public String disabilityName;
}

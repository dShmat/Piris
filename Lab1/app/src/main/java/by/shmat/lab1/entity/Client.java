package by.shmat.lab1.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import by.shmat.lab1.converter.DateConverter;

@Entity
public class Client {

    @PrimaryKey
    public long id;

    public String name;

    public String surname;

    public String patronymic;

    @TypeConverters({DateConverter.class})
    public long birthday;

    public boolean sex;

    public String pasportSeries;

    public String pasportNumber;

    public String issuedBy;

    @TypeConverters({DateConverter.class})
    public long dateIssue;

    public String idNumber;

    public String birthPlace;

    @ColumnInfo(name = "city_id")
    public int cityActualId;

    public String addressActual;

    public String phoneHome;

    public String phoneMobile;

    public String email;

    public String workPlace;

    public String position;

    public String addressRegistration;

    /*@ColumnInfo(name = "family_position_id")
    public int familyPosition;*/

    /*@ColumnInfo(name = "nationality_id")
    public int nationality;*/

    /*@ColumnInfo(name = "disability_id")
    public int disability;*/

    public boolean pensioner;

    public float monthlyIncome;


}

package by.shmat.lab1.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import by.shmat.lab1.dao.CityDao;
import by.shmat.lab1.dao.ClientDao;
import by.shmat.lab1.dao.DisabilityDao;
import by.shmat.lab1.dao.FamilyPositionDao;
import by.shmat.lab1.dao.NationalityDao;
import by.shmat.lab1.entity.City;
import by.shmat.lab1.entity.Client;
import by.shmat.lab1.entity.Disability;
import by.shmat.lab1.entity.FamilyPosition;
import by.shmat.lab1.entity.Nationality;

@Database(entities = {Client.class, City.class, FamilyPosition.class, Nationality.class, Disability.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ClientDao clientDao();

    public abstract CityDao cityDao();

    public abstract FamilyPositionDao familyPositionDao();

    public abstract NationalityDao nationalityDao();

    public abstract DisabilityDao disabilityDao();
}

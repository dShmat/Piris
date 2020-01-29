package by.shmat.lab1.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import by.shmat.lab1.entity.Nationality;


public interface NationalityDao {
    @Query("SELECT * FROM nationality")
    List<Nationality> getAll();

    @Query("SELECT * FROM nationality WHERE id = :id")
    Nationality getById(long id);

    @Insert
    void insert(Nationality nationality);

    @Update
    void update(Nationality nationality);

    @Delete
    void delete(Nationality nationality);
}

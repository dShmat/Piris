package by.shmat.lab1.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import by.shmat.lab1.entity.Disability;

public interface DisabilityDao {

    @Query("SELECT * FROM disability")
    List<Disability> getAll();

    @Query("SELECT * FROM disability WHERE id = :id")
    Disability getById(long id);

    @Insert
    void insert(Disability disability);

    @Update
    void update(Disability disability);

    @Delete
    void delete(Disability disability);

}

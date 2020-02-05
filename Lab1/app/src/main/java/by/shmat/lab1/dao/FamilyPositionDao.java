package by.shmat.lab1.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import by.shmat.lab1.entity.FamilyPosition;

@Dao
public interface FamilyPositionDao {

    @Query("SELECT * FROM familyPosition")
    List<FamilyPosition> getAll();

    @Query("SELECT * FROM familyPosition WHERE id = :id")
    FamilyPosition getById(long id);

    @Insert
    void insert(FamilyPosition familyPosition);

    @Update
    void update(FamilyPosition familyPosition);

    @Delete
    void delete(FamilyPosition familyPosition);

}

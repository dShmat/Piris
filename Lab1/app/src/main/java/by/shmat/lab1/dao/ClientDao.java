package by.shmat.lab1.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import by.shmat.lab1.entity.Client;

@Dao
public interface ClientDao {

    @Query("SELECT * FROM client")
    List<Client> getAll();

    @Query("SELECT * FROM client WHERE id = :id")
    Client getById(long id);

    @Insert
    void insert(Client client);

    @Update
    void update(Client client);

    @Delete
    void delete(Client client);

}

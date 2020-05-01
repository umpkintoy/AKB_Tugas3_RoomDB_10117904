package id.umpsdev.roomdb;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoActivity {

    @Insert
    void tambahAktivis(EntityActivity entityActivity);

    @Delete
    public void hapusAktivis(EntityActivity entityActivity);

    @Query("SELECT * FROM EntityActivity")
    List<EntityActivity> tampilSeluruhAktivis();

    @Query("SELECT * FROM EntityActivity WHERE zonaTugas LIKE :zona")
    List<EntityActivity> findByZone(String zona);

}

package id.umpsdev.roomdb;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EntityActivity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DaoActivity daoActivity();

}

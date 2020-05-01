package id.umpsdev.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.util.Log.*;

public class MainActivity extends AppCompatActivity {

    private EntityActivity entityActivity;
    public static AppDatabase db;

    //atribut untuk mendisplay hasil data
    List<EntityActivity> entityActivities = new ArrayList<>();
    List<EntityActivity> entityActivityListByZone = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "Activity")
                .allowMainThreadQueries().build();

        //Tambah Data
        entityActivity = new EntityActivity();
        entityActivity.setNamaAktivis("Huang Renjun");
        entityActivity.setEmailAktivis("renjunnct@gmail.com");
        entityActivity.setZonaTugas("Seoul");

        Log.d("TAMBAH", "Tambah Data Aktivis");
        Log.d("TAMBAH", "===================");
        Log.d("TAMBAH", "Nama : " + entityActivity.getNamaAktivis());
        Log.d("TAMBAH", "Email : " + entityActivity.getEmailAktivis());
        Log.d("TAMBAH", "Zona : " + entityActivity.getZonaTugas());

        db.daoActivity().tambahAktivis(entityActivity);

        //Tampil Seluruh Data
        Log.d("TAMPIL", "Tampil seluruh data aktivitas");
        Log.d("TAMPIL", "=============================");

        entityActivity = db.daoActivity().tampilSeluruhAktivis();

        for (int i = 0; i < entityActivity.size(); i++) {

            Log.d("TAMPIL", "Data Ke-" + (i + 1));
            Log.d("TAMPIL", "Nama : " + entityActivity.get(i).getNamaAktivis());
            Log.d("TAMPIL", "Email : " + entityActivity.get(i).getEmailAktivis());
            Log.d("TAMPIL", "Zona : " + entityActivity.get(i).getZonaTugas());
            Log.d("TAMPIL", "===========================");

        }

        //Tampil Berdasarkan Zona
        Log.e("ZONE", "Data Aktivis berdasarkan Zona");
        Log.e("ZONE", "==========================");
        entityActivityListByZone = db.daoActivity().findByZone("Seoul");
        for (int i = 0; i < entityActivityListByZone.size(); i++) {
            Log.e("ZONE", "Data Aktivis Ke-" + (i + 1));
            Log.d("ZONE", "Nama : " + entityActivity.get(i).getNamaAktivis());
            Log.d("ZONE", "Email : " + entityActivity.get(i).getEmailAktivis());
            Log.d("ZONE", "Zona : " + entityActivity.get(i).getZonaTugas());
            Log.d("ZONE", "===========================");

        }
    }
}
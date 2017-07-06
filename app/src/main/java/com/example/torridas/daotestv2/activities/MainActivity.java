package com.example.torridas.daotestv2.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.torridas.daotestv2.R;
import com.example.torridas.daotestv2.city.model.City;
import com.example.torridas.daotestv2.city.model.CityDao;
import com.example.torridas.daotestv2.city.model.DaoMaster;
import com.example.torridas.daotestv2.city.model.DaoSession;
import com.example.torridas.daotestv2.country.adapter.CountryAdapter;
import com.example.torridas.daotestv2.country.model.Country;
import com.example.torridas.daotestv2.country.model.CountryDao;
import com.example.torridas.daotestv2.utility.DAOtest2Utility;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DaoSession daoSession;
    private CountryDao countryDao;
    private CityDao cityDao;

    private CountryAdapter countryAdapter;
    private List<Country> listaTari;
    private List<City> listaOrase;
    private Intent  intentie;

    //views
    private ListView zonaLista;
    private TextView t1;
    private Typeface font1;
    private Toolbar bara;

    // db

    private DaoMaster.DevOpenHelper helper;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //db
        helper = new DaoMaster.DevOpenHelper(this, "locations");
        db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        if( DAOtest2Utility.CURRENT_SESSION == null && daoSession != null ) {
            DAOtest2Utility.CURRENT_SESSION = daoSession;
        }

        //action bar
        bara = (Toolbar)findViewById(R.id.toolbar);
        t1 = (TextView)findViewById(R.id.titlu);
        setSupportActionBar(bara);
        font1 = Typeface.createFromAsset(getAssets(),"Autumn Leaves.ttf");
        t1.setTypeface(font1);

        // decoy items
        listaTari = new ArrayList<>();
        listaOrase = new ArrayList<>();
        zonaLista = (ListView)findViewById(R.id.listaMea);

        countryDao = daoSession.getCountryDao();
        cityDao = daoSession.getCityDao();

        putSomeCountries();
        putSomeCities();

        //query to populate listview
        listaTari = countryDao.queryBuilder().list();
        countryAdapter = new CountryAdapter(listaTari, MainActivity.this );
        zonaLista.setAdapter(countryAdapter);
        zonaLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intentie = new Intent(MainActivity.this, Main2Activity.class);
                intentie.putExtra(DAOtest2Utility.INTENT_ID, listaTari.get(position).getId());
                startActivity(intentie);
            }
        });
    }

    private void putSomeCountries(){
        for( int i = 0; i < 5; i++ ){
            Country country = new Country();
            country.setName("random country name " + i );
            countryDao.insertOrReplace(country);
        }
    }

    private void putSomeCities(){
        for( int i = 0; i < 2; i++ ){
            City city = new City();
            city.setName("random city name " + i + 2);
            city.setCountryOfProvenience(new Long(1));
            cityDao.insert(city);
        }

        for( int i = 0; i < 3; i++ ){
            City city = new City();
            city.setName("random city name " + i );
            city.setCountryOfProvenience(new Long(2));
            cityDao.insert(city);
        }
    }

}

package com.example.torridas.daotestv2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.torridas.daotestv2.R;
import com.example.torridas.daotestv2.city.adapter.CityAdapter;
import com.example.torridas.daotestv2.city.model.City;
import com.example.torridas.daotestv2.city.model.CityDao;
import com.example.torridas.daotestv2.city.model.DaoSession;
import com.example.torridas.daotestv2.utility.DAOtest2Utility;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private DaoSession daoSession;
    private Bundle bundle;
    private List<City> listaOrase;
    private CityAdapter cityAdapter;
    private CityDao cityDao;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if( DAOtest2Utility.CURRENT_SESSION != null ) {
            daoSession = DAOtest2Utility.CURRENT_SESSION;
        }
        //if fails will throw null exception;

        cityDao = daoSession.getCityDao();

        bundle = getIntent().getExtras();
        if( bundle != null  ){
            listaOrase = cityDao.queryBuilder().where(CityDao.Properties.
                    CountryOfProvenience.eq(bundle.getLong(DAOtest2Utility.INTENT_ID))).list();
        }
        cityAdapter = new CityAdapter(listaOrase, Main2Activity.this );
        lista = (ListView)findViewById(R.id.listaMea2);
        lista.setAdapter(cityAdapter);
    }
}

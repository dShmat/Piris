package by.shmat.lab1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import by.shmat.lab1.App;
import by.shmat.lab1.R;
import by.shmat.lab1.dao.CityDao;
import by.shmat.lab1.db.AppDatabase;
import by.shmat.lab1.entity.City;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Button b1;
    EditText et1;
    TextView tw1;
    CityDao cityDao;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = App.getInstance().getDatabase();
        cityDao = db.cityDao();

        List<City> cityList = cityDao.getAll();
        ((Button) findViewById(R.id.add_city_button)).setOnClickListener(this);
        et1 = ((EditText) findViewById(R.id.ed_city_name));
        tw1 = ((TextView) findViewById(R.id.tw_cities));

        tw1.setText(cityList.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_city_button:
                City city = new City();
                city.id = 1;
                city.cityName = et1.getText().toString();
                cityDao.insert(city);
                break;
        }
    }
}

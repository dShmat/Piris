package by.shmat.clienstmodule.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import by.shmat.clienstmodule.R;
import by.shmat.clienstmodule.database.City;

public class CreateCityActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText newCityName;

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_city);

        ((Button) findViewById(R.id.but_create_city)).setOnClickListener(this);
        newCityName = (EditText) findViewById(R.id.edit_city_name);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.new_city));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_create_city:
                saveCity();
                break;
        }
    }

    private void saveCity() {
        String name = newCityName.getText().toString().trim();
        if (isEmpty(name))
            newCityName.setError(getResources().getString(R.string.empty_edit_field));
        else {
            List<City> cities = City.listAll(City.class);
            boolean flag = false;
            for (City city : cities) {
                String prod = city.getName().toLowerCase();
                if (prod.equals(name.toLowerCase()))
                    flag = true;
            }
            if (!flag) {
                City city;
                city = new City(name);
                city.save();
                finish();
            } else
                newCityName.setError(getResources().getString(R.string.same_city_err));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

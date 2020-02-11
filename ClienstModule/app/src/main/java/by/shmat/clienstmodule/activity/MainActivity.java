package by.shmat.clienstmodule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import by.shmat.clienstmodule.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText newCityName;

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((Button) findViewById(R.id.but_create_city)).setOnClickListener(this);
        newCityName = (EditText) findViewById(R.id.edit_city_name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_create_city:
                startActivity(new Intent(this, CityListActivity.class));
                break;
        }
    }
}

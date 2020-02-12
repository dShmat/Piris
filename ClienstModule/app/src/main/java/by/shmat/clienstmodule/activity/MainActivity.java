package by.shmat.clienstmodule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getResources().getString(R.string.clients));
        }


        ((Button) findViewById(R.id.but_go_city)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_go_disability)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_go_family_position)).setOnClickListener(this);
        ((Button) findViewById(R.id.but_go_nationality)).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_element_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_element:
                Intent cityListIntent = new Intent(this, CreateClientActivity.class);
                startActivity(cityListIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_go_city:
                startActivity(new Intent(this, CityListActivity.class));
                break;
            case R.id.but_go_disability:
                startActivity(new Intent(this, DisabilityListActivity.class));
                break;
            case R.id.but_go_family_position:
                startActivity(new Intent(this, FamilyListActivity.class));
                break;
            case R.id.but_go_nationality:
                startActivity(new Intent(this, NationalityListActivity.class));
                break;
        }
    }
}

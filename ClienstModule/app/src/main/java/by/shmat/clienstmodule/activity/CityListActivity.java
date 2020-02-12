package by.shmat.clienstmodule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import by.shmat.clienstmodule.R;
import by.shmat.clienstmodule.adapter.CityListAdapter;
import by.shmat.clienstmodule.database.City;

public class CityListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView cityRecycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter cityListAdapter;
    private List<City> cityList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.cities));
        }
        cityRecycleView = (RecyclerView) findViewById(R.id.simple_list);

        layoutManager = new LinearLayoutManager(this);
        cityRecycleView.setLayoutManager(layoutManager);

        cityList = City.listAll(City.class);
        cityListAdapter = new CityListAdapter(cityList, this);
        cityRecycleView.setAdapter(cityListAdapter);

        cityList = City.listAll(City.class);

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
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.new_element:
                Intent cityListIntent = new Intent(this, CreateCityActivity.class);
                startActivity(cityListIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateAdapter() {
        cityList = City.listAll(City.class);
        cityListAdapter = new CityListAdapter(cityList, this);
        cityRecycleView.setAdapter(cityListAdapter);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateAdapter();
    }
}

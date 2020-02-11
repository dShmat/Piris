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
import by.shmat.clienstmodule.adapter.NationalityListAdapter;
import by.shmat.clienstmodule.database.Nationality;

public class NationalityListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView nationalityRecycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter nationalityListAdapter;
    private List<Nationality> nationalityList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Nationality");
        }
        nationalityRecycleView = (RecyclerView) findViewById(R.id.simple_list);

        layoutManager = new LinearLayoutManager(this);
        nationalityRecycleView.setLayoutManager(layoutManager);

        nationalityList = Nationality.listAll(Nationality.class);
        nationalityListAdapter = new NationalityListAdapter(nationalityList, this);
        nationalityRecycleView.setAdapter(nationalityListAdapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        nationalityList = Nationality.listAll(Nationality.class);

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
            case R.id.new_city:
                Intent nationalityListIntent = new Intent(this, CreateNationalityActivity.class);
                startActivity(nationalityListIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateAdapter() {
        nationalityList = Nationality.listAll(Nationality.class);
        nationalityListAdapter = new NationalityListAdapter(nationalityList, this);
        nationalityRecycleView.setAdapter(nationalityListAdapter);
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
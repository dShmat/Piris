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
import by.shmat.clienstmodule.adapter.DisabilityListAdapter;
import by.shmat.clienstmodule.database.Disability;

public class DisabilityListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView disabilityRecycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter disabilityListAdapter;
    private List<Disability> disabilityList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.disabilities));
        }
        disabilityRecycleView = (RecyclerView) findViewById(R.id.simple_list);

        layoutManager = new LinearLayoutManager(this);
        disabilityRecycleView.setLayoutManager(layoutManager);

        disabilityList = Disability.listAll(Disability.class);
        disabilityListAdapter = new DisabilityListAdapter(disabilityList, this);
        disabilityRecycleView.setAdapter(disabilityListAdapter);

        disabilityList = Disability.listAll(Disability.class);

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
                Intent disabilityListIntent = new Intent(this, CreateDisabilityActivity.class);
                startActivity(disabilityListIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateAdapter() {
        disabilityList = Disability.listAll(Disability.class);
        disabilityListAdapter = new DisabilityListAdapter(disabilityList, this);
        disabilityRecycleView.setAdapter(disabilityListAdapter);
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
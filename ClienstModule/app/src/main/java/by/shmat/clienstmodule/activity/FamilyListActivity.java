package by.shmat.clienstmodule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import by.shmat.clienstmodule.R;
import by.shmat.clienstmodule.adapter.FamilyListAdapter;
import by.shmat.clienstmodule.database.FamilyPosition;

public class FamilyListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView familyRecycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter familyListAdapter;
    private List<FamilyPosition> familyPositions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_list);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.families));
        }
        familyRecycleView = (RecyclerView) findViewById(R.id.simple_list);

        layoutManager = new LinearLayoutManager(this);
        familyRecycleView.setLayoutManager(layoutManager);

        familyPositions = FamilyPosition.listAll(FamilyPosition.class);
        familyListAdapter = new FamilyListAdapter(familyPositions, this);
        familyRecycleView.setAdapter(familyListAdapter);

        familyPositions = FamilyPosition.listAll(FamilyPosition.class);

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
                Intent familyListIntent = new Intent(this, CreateFamilyActivity.class);
                startActivity(familyListIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateAdapter() {
        familyPositions = FamilyPosition.listAll(FamilyPosition.class);
        familyListAdapter = new FamilyListAdapter(familyPositions, this);
        familyRecycleView.setAdapter(familyListAdapter);
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


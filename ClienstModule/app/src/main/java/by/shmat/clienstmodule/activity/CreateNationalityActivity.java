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
import by.shmat.clienstmodule.database.Nationality;

public class CreateNationalityActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText newNationalityName;

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_nationality);

        ((Button) findViewById(R.id.but_create_nationality)).setOnClickListener(this);
        newNationalityName = (EditText) findViewById(R.id.edit_nationality_name);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("New Nationality");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_create_nationality:
                saveNationality();
                break;
        }
    }

    private void saveNationality() {
        String name = newNationalityName.getText().toString().trim();
        if (isEmpty(name))
            newNationalityName.setError(getResources().getString(R.string.empty_edit_field));
        else {
            List<Nationality> nationalities = Nationality.listAll(Nationality.class);
            boolean flag = false;
            for (Nationality nationality : nationalities) {
                String prod = nationality.getName().toLowerCase();
                if (prod.equals(name.toLowerCase()))
                    flag = true;
            }
            if (!flag) {
                Nationality nationality;
                nationality = new Nationality(name);
                nationality.save();
                finish();
            } else
                newNationalityName.setError(getResources().getString(R.string.same_nationality_err));
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

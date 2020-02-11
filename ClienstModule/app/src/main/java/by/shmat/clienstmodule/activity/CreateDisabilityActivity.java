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
import by.shmat.clienstmodule.database.Disability;

public class CreateDisabilityActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText newDisabilityName;

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_disability);

        ((Button) findViewById(R.id.but_create_disability)).setOnClickListener(this);
        newDisabilityName = (EditText) findViewById(R.id.edit_disability_name);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.new_disability));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_create_disability:
                saveDisability();
                break;
        }
    }

    private void saveDisability() {
        String name = newDisabilityName.getText().toString().trim();
        if (isEmpty(name))
            newDisabilityName.setError(getResources().getString(R.string.empty_edit_field));
        else {
            List<Disability> disabilities = Disability.listAll(Disability.class);
            boolean flag = false;
            for (Disability disability : disabilities) {
                String prod = disability.getName().toLowerCase();
                if (prod.equals(name.toLowerCase()))
                    flag = true;
            }
            if (!flag) {
                Disability disability;
                disability = new Disability(name);
                disability.save();
                finish();
            } else
                newDisabilityName.setError(getResources().getString(R.string.same_nationality_err));
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
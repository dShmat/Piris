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
import by.shmat.clienstmodule.database.FamilyPosition;

public class CreateFamilyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText newFamilyName;

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_family);

        ((Button) findViewById(R.id.but_create_family)).setOnClickListener(this);
        newFamilyName = (EditText) findViewById(R.id.edit_family_name);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.new_family));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_create_family:
                saveFamily();
                break;
        }
    }

    private void saveFamily() {
        String name = newFamilyName.getText().toString().trim();
        if (isEmpty(name))
            newFamilyName.setError(getResources().getString(R.string.empty_edit_field));
        else {
            List<FamilyPosition> familyPositions = FamilyPosition.listAll(FamilyPosition.class);
            boolean flag = false;
            for (FamilyPosition family : familyPositions) {
                String prod = family.getName().toLowerCase();
                if (prod.equals(name.toLowerCase()))
                    flag = true;
            }
            if (!flag) {
                FamilyPosition family;
                family = new FamilyPosition(name);
                family.save();
                finish();
            } else
                newFamilyName.setError(getResources().getString(R.string.same_family_position_err));
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

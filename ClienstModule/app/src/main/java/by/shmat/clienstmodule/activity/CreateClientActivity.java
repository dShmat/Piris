package by.shmat.clienstmodule.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.shmat.clienstmodule.R;

public class CreateClientActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText surnameEd;
    private EditText nameEd;
    private EditText patronymicEd;
    private static EditText birthdayEd;
    private EditText pasportSeriesEd;
    private EditText pasportNumberEd;
    private EditText issuedByEd;
    private static EditText dateIssueEd;
    private EditText idNumberEd;
    private EditText birthPlaceEd;
    private EditText cityActualEd;
    private EditText addressActualEd;
    private EditText phoneHomeEd;
    private EditText phoneMobileEd;
    private EditText emailEd;
    private EditText workPlaceEd;
    private EditText positionEd;
    private EditText addressRegistrationEd;
    private EditText familyPositionEd;
    private EditText nationalityEd;
    private EditText disabilityEd;
    private CheckBox pensionerEd;
    private EditText monthlyIncomeEd;
    private RadioButton sex1;
    private RadioButton sex2;
    private final int FLAG_CITY_INTENT = 0;
    private final int FLAG_FAMILY_INTENT = 1;
    private final int FLAG_NATIONALITY_INTENT = 2;
    private final int FLAG_DISABILITY_INTENT = 3;

    private DatePickerDialogFragment mDatePickerDialogFragment;

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_client);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.new_client));
        }

        surnameEd = (EditText) findViewById(R.id.edit_surname);
        nameEd = (EditText) findViewById(R.id.edit_name);
        patronymicEd = (EditText) findViewById(R.id.edit_patronymic);
        birthdayEd = (EditText) findViewById(R.id.edit_date_birth);
        pasportSeriesEd = (EditText) findViewById(R.id.edit_pasport_series);
        pasportNumberEd = (EditText) findViewById(R.id.edit_pasport_number);
        issuedByEd = (EditText) findViewById(R.id.edit_issued_by);
        dateIssueEd = (EditText) findViewById(R.id.edit_date_issue);
        idNumberEd = (EditText) findViewById(R.id.edit_id_number);
        birthPlaceEd = (EditText) findViewById(R.id.edit_birth_place);
        cityActualEd = (EditText) findViewById(R.id.edit_actual_city);
        addressActualEd = (EditText) findViewById(R.id.edit_address_actual);
        phoneHomeEd = (EditText) findViewById(R.id.edit_phone_home);
        phoneMobileEd = (EditText) findViewById(R.id.edit_phone_mobile);
        emailEd = (EditText) findViewById(R.id.edit_email);
        workPlaceEd = (EditText) findViewById(R.id.edit_work_place);
        positionEd = (EditText) findViewById(R.id.edit_position);
        addressRegistrationEd = (EditText) findViewById(R.id.edit_address_registration);
        familyPositionEd = (EditText) findViewById(R.id.edit_family_position);
        nationalityEd = (EditText) findViewById(R.id.edit_nationality);
        disabilityEd = (EditText) findViewById(R.id.edit_disability);
        pensionerEd = (CheckBox) findViewById(R.id.checkbox_pensioner);
        monthlyIncomeEd = (EditText) findViewById(R.id.edit_monthly_income);
        sex1 = (RadioButton) findViewById(R.id.rb_sex_first);
        sex2 = (RadioButton) findViewById(R.id.rb_sex_second);
        ((Button) findViewById(R.id.button_create_client)).setOnClickListener(this);
        birthdayEd.setOnClickListener(this);
        dateIssueEd.setOnClickListener(this);
        cityActualEd.setOnClickListener(this);
        familyPositionEd.setOnClickListener(this);
        nationalityEd.setOnClickListener(this);
        disabilityEd.setOnClickListener(this);
        pensionerEd.setOnCheckedChangeListener(this);
        sex1.setOnCheckedChangeListener(this);
        sex2.setOnCheckedChangeListener(this);

        mDatePickerDialogFragment = new DatePickerDialogFragment();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edit_date_birth:
                mDatePickerDialogFragment.setFlag(DatePickerDialogFragment.FLAG_BIRTHDAY_DATE);
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "datePicker");
                break;
            case R.id.edit_date_issue:
                mDatePickerDialogFragment.setFlag(DatePickerDialogFragment.FLAG_ISSUE_DATE);
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "datePicker");
                break;
            case R.id.edit_actual_city:
                Intent cityIntent = new Intent(this, CityListActivity.class);
                startActivityForResult(cityIntent, FLAG_CITY_INTENT);
                break;
            case R.id.edit_family_position:
                Intent familyIntent = new Intent(this, FamilyListActivity.class);
                startActivityForResult(familyIntent, FLAG_FAMILY_INTENT);
                break;
            case R.id.edit_nationality:
                Intent nationalityIntent = new Intent(this, NationalityListActivity.class);
                startActivityForResult(nationalityIntent, FLAG_NATIONALITY_INTENT);
                break;
            case R.id.edit_disability:
                Intent disabilityIntent = new Intent(this, DisabilityListActivity.class);
                startActivityForResult(disabilityIntent, FLAG_DISABILITY_INTENT);
                break;
            case R.id.button_create_client:
                createClient();
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    private void createClient() {
        String clientSurname = surnameEd.getText().toString();
        String clientName = nameEd.getText().toString();
        String clientPatronymic = patronymicEd.getText().toString();
        String clientBirthday = birthdayEd.getText().toString();
        String clientPasportSeries = pasportSeriesEd.getText().toString();
        String clientPasportNumberEd = pasportNumberEd.getText().toString();
        String clientIssuedBy = issuedByEd.getText().toString();
        String clientDateIssue = dateIssueEd.getText().toString();
        String clientIdNumber = idNumberEd.getText().toString();
        String clientBirthPlace = birthPlaceEd.getText().toString();
        String clientCityActual = cityActualEd.getText().toString();
        String clientAddressActual = addressActualEd.getText().toString();
        String clientPhoneHome = phoneHomeEd.getText().toString();
        String clientPhoneMobile = phoneMobileEd.getText().toString();
        String clientEmail = emailEd.getText().toString();
        String clientWorkPlace = workPlaceEd.getText().toString();
        String clientPosition = positionEd.getText().toString();
        String clientAdressRegistration = addressRegistrationEd.getText().toString();
        String clientFamilyPosition = familyPositionEd.getText().toString();
        String clientNationality = nationalityEd.getText().toString();
        String clientDisability = disabilityEd.getText().toString();
        String clientMonthlyIncome = monthlyIncomeEd.getText().toString();

        //sex
        //pensioner

        if (isEmpty(clientSurname) || (!isValidText(clientSurname)))
            surnameEd.setError(getResources().getString(R.string.empty_edit_field));
        else if (isEmpty(clientName) || (!isValidText(clientName)))
            nameEd.setError(getResources().getString(R.string.empty_edit_field));
        else if (isEmpty(clientPatronymic) || (!isValidText(clientPatronymic)))
            patronymicEd.setError(getResources().getString(R.string.empty_edit_field));
        else if (isEmpty(clientBirthday))
            birthdayEd.setError(getResources().getString(R.string.empty_edit_field));
        else if (isEmpty(clientPasportSeries) || (!isValidText(clientPasportSeries)))
            pasportSeriesEd.setError(getResources().getString(R.string.empty_edit_field));
        else if (isEmpty(clientPasportNumberEd) || (!isValidNumber(clientPasportNumberEd)))
            pasportNumberEd.setError(getResources().getString(R.string.empty_edit_field));
        else if (isEmpty(clientIssuedBy))
            issuedByEd.setError(getResources().getString(R.string.empty_edit_field));
        else if (isEmpty(clientDateIssue))
            dateIssueEd.setError(getResources().getString(R.string.empty_edit_field));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        switch (requestCode) {
            case FLAG_CITY_INTENT:
                String cityName = data.getStringExtra("cityName");
                cityActualEd.setText(cityName);
                break;
            case FLAG_FAMILY_INTENT:
                String familyName = data.getStringExtra("familyName");
                familyPositionEd.setText(familyName);
                break;
            case FLAG_NATIONALITY_INTENT:
                String nationalityName = data.getStringExtra("nationalityName");
                nationalityEd.setText(nationalityName);
                break;
            case FLAG_DISABILITY_INTENT:
                String disabilityName = data.getStringExtra("disabilityName");
                disabilityEd.setText(disabilityName);
                break;
        }
    }

    private boolean isValidText(String text) {
        String TEXT_PATTERN = "^[A-ZА-Яа-яa-z]*$";
        Pattern pattern = Pattern.compile(TEXT_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    private boolean isValidNumber(String text) {
        String TEXT_PATTERN = "^[0-9]*$";
        Pattern pattern = Pattern.compile(TEXT_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    private boolean isValidDate(String text) {
        Calendar rightNow = Calendar.getInstance();
        //Date.parse(rightNow.toString());
        //if (Calendar. (text) < Calendar.getInstance())
        //return true;
        return false;
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static class DatePickerDialogFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        public static final int FLAG_BIRTHDAY_DATE = 0;
        public static final int FLAG_ISSUE_DATE = 1;

        private int flag = 0;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void setFlag(int i) {
            flag = i;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);
            SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
            if (flag == FLAG_BIRTHDAY_DATE) {
                birthdayEd.setText(format.format(calendar.getTime()));
            } else if (flag == FLAG_ISSUE_DATE) {
                dateIssueEd.setText(format.format(calendar.getTime()));
            }
        }
    }

}


package by.shmat.clienstmodule.database;

import com.orm.SugarRecord;

import java.time.Instant;

public class Client extends SugarRecord {

    private String surname;

    private String name;

    private String patronymic;

    private Instant birthday;

    private boolean sex;

    private String pasportSeries;

    private String pasportNumber;

    private String issuedBy;

    private Instant dateIssue;

    private String idNumber;

    private String birthPlace;

    private City cityActual;

    private String addressActual;

    private String phoneHome;

    private String phoneMobile;

    private String email;

    private String workPlace;

    private String position;

    private String addressRegistration;

    private FamilyPosition familyPosition;

    private Nationality nationality;

    private Disability disability;

    private boolean pensioner;

    private float monthlyIncome;

    public Client() {
    }

    public Client(String surname, String name, String patronymic, Instant birthday, boolean sex,
                  String pasportSeries, String pasportNumber, String issuedBy, Instant dateIssue,
                  String idNumber, String birthPlace, City cityActual, String addressActual,
                  String phoneHome, String phoneMobile, String email, String workPlace,
                  String position, String addressRegistration, FamilyPosition familyPosition,
                  Nationality nationality, Disability disability, boolean pensioner,
                  float monthlyIncome) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.sex = sex;
        this.pasportSeries = pasportSeries;
        this.pasportNumber = pasportNumber;
        this.issuedBy = issuedBy;
        this.dateIssue = dateIssue;
        this.idNumber = idNumber;
        this.birthPlace = birthPlace;
        this.cityActual = cityActual;
        this.addressActual = addressActual;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
        this.email = email;
        this.workPlace = workPlace;
        this.position = position;
        this.addressRegistration = addressRegistration;
        this.familyPosition = familyPosition;
        this.nationality = nationality;
        this.disability = disability;
        this.pensioner = pensioner;
        this.monthlyIncome = monthlyIncome;
    }

    public City getActualCity() {
        return cityActual;
    }
}

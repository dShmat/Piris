package by.shmat.clienstmodule.database;

import com.orm.SugarRecord;

public class Nationality extends SugarRecord {

    private String name;

    public Nationality() {
    }

    public Nationality(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

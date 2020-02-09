package by.shmat.clienstmodule.database;

import com.orm.SugarRecord;

public class Disability extends SugarRecord {

    private String name;

    public Disability() {
    }

    public Disability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

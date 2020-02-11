package by.shmat.clienstmodule.database;

import com.orm.SugarRecord;

public class FamilyPosition extends SugarRecord {

    private String name;

    public FamilyPosition() {
    }

    public FamilyPosition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

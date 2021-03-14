package Model;

import helpers.csvReader;

public class DB {
    csvReader csvReader;

    public DB() {
        csvReader = new csvReader();
        csvReader.populateDB();
    }
}

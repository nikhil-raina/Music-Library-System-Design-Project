package Model;

import helpers.csvReader;

// Command Pattern: Receiver
public class Database {
    csvReader csvReader;

    public Database() {
        csvReader = new csvReader();
        csvReader.populateDB();
    }
}

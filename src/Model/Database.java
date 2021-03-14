package Model;

import ObjectModules.Response;
import helpers.csvReader;

// Command Pattern: Receiver
public class Database {
    csvReader csvReader;

    public Database() {
        csvReader = new csvReader();
        csvReader.populateDB();
    }

    public Response ActionAddMedia(String media) {
        return new Response("");
    }

    public Response ActionSearchMedia(String media) {
        return new Response("");
    }

    public Response ActionRemoveMedia(String media) {
        return new Response("");
    }

    public Response ActionRateMedia(String media) {
        return new Response("");
    }

    public Response ActionHelp(String media) {
        return new Response("");
    }

    public Response ActionCreateCollection(String media) {
        return new Response("");
    }
}

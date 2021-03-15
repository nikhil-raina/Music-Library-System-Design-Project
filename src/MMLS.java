import Controller.RequestHandler;
import Model.ActionHelp;
import Model.Database;
import ObjectModules.Library;
import ObjectModules.Response;
import ObjectModules.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;

public class MMLS {

    public static void main(String[] args) throws IOException, ParseException {
        Database db = new Database();
        Scanner scan = new Scanner(System.in);
        File file = new File("src/PersistedData/Libraries");
        FileWriter fileWriter = new FileWriter(file);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Reader reader = Files.newBufferedReader(Path.of("src/PersistedData/Libraries"));


        // Check to see if Libraries.json file exists, else create one
        if (!file.exists()) { file.createNewFile(); }

        System.out.println("Welcome to the Muze Music Library System \nType \"exit;\" to close this program.");
        System.out.print("Enter username: ");
        String username = scan.nextLine();

        User user;

        // Collect username and check to see if library exists for specified username
        Map<?,?> listUsernames = gson.fromJson(reader, Map.class);
        if(listUsernames == null) {
            user = new User(0, username);
        } else if (listUsernames.containsValue(username)) {
            user = new User(0, username, new Library());    // placeholder - replace new library with parsed values
                                                                // from Libraries file
        } else {
            user = new User(0, username);
        }

        RequestHandler requestHandler = new RequestHandler(user.getLibrary(), user.getDb());
        Response response;


        System.out.println("What would you like to do? (Type \"help;\" to find out more)");
        while (true) {
            System.out.print("> ");
            String command = scan.nextLine();
            String[] commandStream = command.split(";");
            switch (commandStream[0]) {
                case "exit":
                    // update json file with changes
                    fileWriter.write(gson.toJson(user));
                    fileWriter.flush();

                    System.out.println("Thanks for using Muze Music Library System");
                    System.exit(0);
                    break;
                case "help":
                    response = new ActionHelp().performRequest();
                    System.out.println(response.getResponse());
                    break;
                default:
                    response = requestHandler.handleRequest(command);
                    System.out.println(response.getResponse());
                    break;
            }
        }
    }
}

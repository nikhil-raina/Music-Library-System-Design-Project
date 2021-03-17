import Controller.RequestHandler;
import Model.ActionHelp;
import Model.Grouping;
import ObjectModules.Library;
import ObjectModules.Response;
import ObjectModules.User;
import com.google.gson.*;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        File file = new File("src/PersistedData/Libraries.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileReader reader = new FileReader("src/PersistedData/Libraries.json");


        // Check to see if Libraries.json file exists, else create one
        if (!file.exists()) { file.createNewFile(); }

        System.out.println("Welcome to the Muze Music Library System \nType \"exit;\" to close this program.");
        System.out.print("Enter username: ");
        String username = scan.nextLine();

        User user = null;

        // Collect username and check to see if library exists for specified username
        JsonParser jp = new JsonParser();
        JsonElement users = jp.parse(reader);
        if (users == null) {
            // new user
            user = new User(0, username);
        } else {
            for(JsonElement eachUser: users.getAsJsonArray()) {
                JsonObject userObj = eachUser.getAsJsonObject();
                if(userObj.get("userName").getAsString().equalsIgnoreCase(username)) {
                    // returning user
                    int ID = Integer.parseInt(userObj.get("ID").getAsString());
                    String elements = userObj.get("library").getAsString();
                    Library lib = new Library();
                    ///
                    //THIS NEEDS TO BE IMPLEMENTED!!!
                    ///
                    lib.makeLibrary(elements);
                    user = new User(ID, username, lib);
                } else {
                    // new user
                    int ID = Integer.parseInt(userObj.get("ID").getAsString());
                    user = new User(ID + 1, username, new Library());
                }
            }
        }

        RequestHandler requestHandler = new RequestHandler(user.getLibrary(), new Grouping());
        Response response;


        System.out.println("What would you like to do? (Type \"help;\" to find out more)");
        while (true) {
            System.out.print("> ");
            String command = scan.nextLine();
            if (!command.contains(";")){
                System.out.println("Add ';' with the command. Type 'help;' for more details");
                continue;
            }
            String[] commandStream = command.split(";");
            switch (commandStream[0]) {
                case "exit":
                    // update json file with changes
                    FileWriter fileWriter = new FileWriter(file);
                    // SOMEHOW APPEND THE NEW USER WITH THE REST OF THE USERS
                    List<User> newUser = new ArrayList<>();
                    newUser.add(user);
                    gson.toJson(newUser, fileWriter);
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

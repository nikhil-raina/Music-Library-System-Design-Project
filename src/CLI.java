import Controller.RequestHandler;
import GUI.GUI_Handler;
import Model.ActionHelp;
import Model.Grouping;
import ObjectModules.Library;
import ObjectModules.Response;
import ObjectModules.User;
import com.google.gson.*;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class CLI {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the MMLS!\nEnter which UI you would like to use... (\"GUI\" or \"CLI\")");
        String GUIorCLI = scan.nextLine();

        if (GUIorCLI.equals("GUI")) {
            GUI_Handler.main(args);
        } else {
            File file = new File("src/PersistedData/Libraries.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Check to see if Libraries.json file exists, else create one
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader reader = new FileReader("src/PersistedData/Libraries.json");
            System.out.println("Welcome to the Muze Music Library System \nType \"exit;\" to close this program.");
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            User user = null;
            boolean isOldUser = false;

            JsonElement jsonElement = new JsonParser().parse(reader);
            JsonArray users = new JsonArray();
            if (jsonElement == null || jsonElement instanceof JsonNull) {
                user = new User(0, username);
            } else {
                users = jsonElement.getAsJsonObject().getAsJsonArray("libraryData");
                for (int userIdx = 0; userIdx < users.size(); userIdx++) {
                    JsonObject userObj = users.get(userIdx).getAsJsonObject();
                    if (userObj.get("userName").toString().replace("\"", "").equalsIgnoreCase(username)) {
                        JsonArray libraryElements = userObj.get("library").getAsJsonObject().get("elements").getAsJsonArray();
                        Library library = new Library();
                        library.makeLibrary(libraryElements);
                        user = new User(Integer.parseInt(userObj.get("ID").toString()), username, library);
                        isOldUser = true;
                        break;
                    }
                }
                if (!isOldUser)
                    user = new User(users.size(), username); // new user
            }

            RequestHandler requestHandler = new RequestHandler(user.getLibrary(), new Grouping());
            Response response;

            System.out.println("What would you like to do? (Type \"help;\" to find out more)");
            while (true) {
                System.out.print("> ");
                String command = scan.nextLine();
                if (!command.contains(";")) {
                    System.out.println("Add ';' with the command. Type 'help;' for more details");
                    continue;
                }
                String[] commandStream = command.split(";");
                switch (commandStream[0]) {
                    case "exit":

                        // Creates a temp file that stores the data in a JSON form
                        FileWriter fileWriter = new FileWriter("src/PersistedData/temp_user.json");
                        File tempFile = new File("src/PersistedData/temp_user.json");
                        tempFile.createNewFile();
                        HashMap<String, List<User>> dataList = new HashMap<>();
                        List<User> newUser = new ArrayList<>();
                        newUser.add(user);
                        dataList.put("libraryData", newUser);
                        gson.toJson(dataList, fileWriter);
                        fileWriter.flush();

                        // Opens the temp file to get the necessary temp JSON data of the current user
                        reader = new FileReader("src/PersistedData/temp_user.json");
                        jsonElement = new JsonParser().parse(reader);
                        JsonArray tempUser = jsonElement.getAsJsonObject().getAsJsonArray("libraryData");
                        JsonObject tUser = tempUser.get(0).getAsJsonObject();

                        // Searches within users to update the JsonArray
                        for (int index = 0; index < users.size(); index++) {
                            JsonObject userObj = users.get(index).getAsJsonObject();
                            int id = Integer.parseInt(userObj.get("ID").toString());
                            if (Integer.parseInt(tUser.get("ID").toString()) == id) {
                                users.remove(index);
                                break;
                            }
                        }
                        users.add(tUser);
                        HashMap<String, JsonArray> storingData = new HashMap<>();
                        storingData.put("libraryData", users);
                        fileWriter = new FileWriter("src/PersistedData/Libraries.json");
                        gson.toJson(storingData, fileWriter);
                        fileWriter.flush();
                        System.out.println("Thanks for using Muze Music Library System");
                        System.exit(0);

                    default:
                        response = requestHandler.handleRequest(command);
                        break;
                }
                System.out.println(response.getResponse());
            }
        }
    }
}

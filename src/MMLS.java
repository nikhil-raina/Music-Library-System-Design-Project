import Controller.RequestHandler;
import Model.*;
import ObjectModules.Library;
import ObjectModules.Response;
import ObjectModules.mediaCollection;

import java.util.Scanner;

public class MMLS {

    public static void main(String[] args) {
        Database db = new Database();
        Library library = new Library();
        mediaCollection collection = new mediaCollection(db, library);
        RequestHandler requestHandler = new RequestHandler();
        Response response;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Muze Music Library System \nType \"exit;\" to close this program.");
        System.out.println("What would you like to do? (Type \"help;\" to find out more)");
        while (true) {
            System.out.print("> ");
            String command = scan.nextLine();
            String[] commandStream = command.split(";");
            switch (commandStream[0]) {
                case "exit":
                    System.out.println("Thanks for using Muze Music Library System");
                    System.exit(0);
                    break;
                case "help":
                    response = new ActionHelp().performRequest();
                    System.out.println(response.getResponse());
                    break;
                default:
                    response = requestHandler.handleRequest(command, collection);
                    System.out.println(response.getResponse());
                    break;
            }
        }
    }
}

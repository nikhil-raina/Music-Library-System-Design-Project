import Controller.RequestHandler;
import Model.*;

import java.util.Scanner;

public class MMLS {

    public static void main(String[] args) {
        Database db = new Database();
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
                    new ActionHelp().performRequest();
                    break;
                default:
                    response = requestHandler.handleRequest(command, db);
                    System.out.println(response.getResponse());
                    break;
            }
        }
    }
}

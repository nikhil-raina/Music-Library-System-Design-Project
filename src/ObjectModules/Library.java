package ObjectModules;
import java.util.ArrayList;
import java.util.Scanner;  
import java.io.*;

public class Library{

    //Not tested but should work(or be close)
    //Should essentially repeat this code with the other two files, although there is
    // definitely a better way to do this
    public ArrayList<Artist> parseArtists(){
        //TODO path might be wrong but I can't check on the environment i'm running
        Scanner sc = new Scanner(new File("../data_set/artists.csv"));
        sc.useDelimiter(",");
        ArrayList<Artist> artists = new ArrayList<>();
        String temp_GUID, temp_name, temp_disambig = "";
        while (sc.hasNext()){
            String curr = sc.next();
            if (curr.length() == 36){
                if (temp_GUID == ""){
                    temp_GUID = curr;
                }
                else{
                    artists.append(new Artist(temp_GUID, temp_name, temp_disambig));
                    temp_GUID, temp_name, temp_disambig = "";
                }

            }
            else if(temp_name == ""){
                temp_name = curr;
            }
            else{
                temp_disambig = curr;
            }
        }

        return artists;
    }
}
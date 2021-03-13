package ObjectModules;

public class user{
    public int Id;
    public String name;


    public user(int Id,String name){
        this.Id = Id;
        this.name = name;
    }

    public String getUserName(){
        return name;
    }

    public int getUserID(){
        return Id;
    }
}

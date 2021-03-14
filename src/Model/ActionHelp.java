package Model;

// Command Pattern: Concrete Command
public class ActionHelp implements Request{
    @Override
    public void performRequest() {
        System.out.println("\tcommands: \"add\", \"remove\", \"search\", \"rate\", \"create\", \"show\" \n" +
                "\tmediaType: \"song\", \"artist\", \"release\"\n" +
                "\tusage:\tadd  => add <mediaType> in <collection name> \n" +
                "\t\t  remove => remove <mediaType> in <collection name> \n" +
                "\t\t\t\t => remove <collection name> \n" +
                "\t\t  search => search <mediaType> in <collection name> \n" +
                "\t\t\t\t => search <mediaType> in database \n" +
                "\t\t\trate => rate <mediaType> <song name>(only songs) \n" +
                "\t\t  create => create <collection name> \n" +
                "\t\t\tshow => show <collection name> \n"
                );
    }

    @Override
    public Response performRequest(String mediaType, String media) {
        return null;
    }

    @Override
    public Response performRequest(String media) {
        return null;
    }


}

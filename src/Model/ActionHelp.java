package Model;

// Command Pattern: Concrete Command
public class ActionHelp implements Request{
    @Override
    public void performRequest() {
        System.out.println("\tcommands: \"add\", \"remove\", \"search\", \"rate\", \"create\", \"show\" \n" +
                "\tmediaType: \"song\", \"artist\", \"release\"\n" +
                "\tusage:\tadd  => add; <mediaType>; <media name>; <collection name> \n" +
                "\t\t  remove => remove; <mediaType>; <media name>; <collection name> \n" +
                "\t\t\t\t => remove; <collection name> \n" +
                "\t\t  search => search; <mediaType>; <media name>; <collection name> \n" +
                "\t\t\t\t => search; <mediaType>; <media name>; database \n" +
                "\t\t\trate => rate; <mediaType>; <song name>(only songs) \n" +
                "\t\t  create => create; <collection name> \n" +
                "\t\t\tshow => show; <collection name> \n"
                );
    }

    @Override
    public Response performRequest(String mediaType, String mediaName, String collectionName) {
        return null;
    }

    @Override
    public Response performRequest(String mediaType, String mediaName) {
        return null;
    }

    @Override
    public Response performRequest(String media) {
        return null;
    }


}

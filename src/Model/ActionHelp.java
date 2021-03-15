package Model;

import ObjectModules.Response;

// Command Pattern: Concrete Command
public class ActionHelp implements Request{

    @Override
    public Response performRequest() {
        Response response = new Response("\tcommands: \"add\", \"remove\", \"search\", \"rate\", \"create\", \"show\" \n" +
                "\tmediaType: \"song\", \"artist\", \"release\"\n" +
                "\tusage:\tadd  => add; <mediaType>; <media name>; <collection name> \n" +
                "\t\t  remove => remove; <mediaType>; <media name>; <collection name> \n" +
                "\t\t\t\t => remove; <collection name> \n" +
                "\t\t  search => search; <song,artist,release>; <media name>; <collection name> \n" +
                "\t\t\t\t => search; <song,artist,release>; <media name>; database \n" +
                "\t\t\trate => rate; <mediaType>; <song name>(only songs); <rating>(1-5) \n" +
                "\t\t  create => create; <collection name> \n" +
                "\t\t\tshow => show; <collection name> \n");
        return response;
    }
}

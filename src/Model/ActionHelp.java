package Model;

import ObjectModules.Response;

// Command Pattern: Concrete Command
public class ActionHelp implements Request{

    @Override
    public Response performRequest() {
        return new Response("\tcommands: \"add\", \"remove\", \"search\", \"rate\", \"create\", \"show\" \n" +
                "\tmediaType: \"song\", \"artist\", \"release\"\n" +
                "\tdefault action will be done on library unless 'database' entered\n" +
                "\tusage:\tadd  => add; <mediaType>; <media name> \n" +
                "\t\t  remove => remove; <mediaType>; <media name> \n" +
                "\t\t  search => search; <mediaType>; <media name> \n" +
                "\t\t\t\t => search; <mediaType>; <media name>; database \n" +
                "\t\t\trate => rate; <mediaType>; <song name>(only songs); <rating>(1-5) \n" +
                "\t\t  create => create; <collection name> \n" +
                "\t\t\tshow => show; \n");
    }
}

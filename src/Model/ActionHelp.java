package Model;

// Command Pattern: Concrete Command
public class ActionHelp implements Request{
    @Override
    public void performRequest() {
        System.out.println("Reached");
        /**
         * commands: "add", "remove", "search", "rate", "create", "show"
         * mediaType: "song", "artist", "release"
         * usage:   add  => add <mediaType> in <collection name>
         *        remove => remove <mediaType> in <collection name>
         *                  remove <collection name>
         *        search => search <mediaType> in <collection name>
         *               => search <mediaType> in database
         *         rate  => rate <mediaType> (only songs)
         *        create => create <collection name>
         *         show  => show <collection name>
         */
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

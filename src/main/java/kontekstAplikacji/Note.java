package kontekstAplikacji;

public class Note {
    static final String TYPE_PUBLIC = "pub"; //odpowiadja wartoscia radio buttonow z notatki.jsp
    static final String TYPE_PRIVATE = "priv";

    private String id;
    private String content;
    private String type;

    public static String getTypePublic() {
        return TYPE_PUBLIC;
    }

    public static String getTypePrivate() {
        return TYPE_PRIVATE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Note(String id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
    }
}

package czat;

public class User {
    private String userName;
    private String text;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User(String userName, String text) {
        this.userName = userName;
        this.text = text;
    }
}

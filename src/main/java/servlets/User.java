package servlets;

public class User {
    private String userName;
    private String password;
    private String gender;
    private String [] hobby;

    public User(String userName, String password, String gender, String[] hobby) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.hobby = hobby;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String[] getHobby() {
        return hobby;
    }
}

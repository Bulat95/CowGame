package app.database;

public class Person {
    public String login;
    private String password;
    private int average_value;

    public Person(String login, String password, int average_value) {
        this.login = login;
        this.password = password;
        this.average_value = average_value;
    }
}

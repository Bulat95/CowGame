package app.entities;

public class User {
    private String login;
    private String password;
    private int average_num;

    public int getAverage_num() {
        return average_num;
    }

    public void setAverage_num(int average_num) {
        this.average_num = average_num;
    }

    public User() {
    }

    public User(String login, String password, int average_num) {
        this.login = login;
        this.password = password;
        this.average_num = average_num;
    }

    public String getName() {
        return login;
    }

    public void setName(String name) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
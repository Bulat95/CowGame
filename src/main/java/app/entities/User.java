package app.entities;

public class User {
    private String login = "null";
    private String password;
    private int averageNum;
    private int numbersOfGames;
    private int numbersTrying;

    public int getNumbersTrying() {
        return numbersTrying;
    }

    public void setNumbersTrying(int numbersTrying) {
        this.numbersTrying = numbersTrying;
    }

    public int getNumberOfGames() {
        return numbersOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numbersOfGames = numberOfGames;
    }

    public int getAverage_num() {
        return averageNum;
    }

    public void setAverage_num(int average_num) {
        this.averageNum = average_num;
    }

    public String getName() {
        if (login == null){
            return null;
        }
        return login;
    }

    public void setName(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String login, String password, int averageNum, int numberOfGames, int numbersTrying) {
        this.login = login;
        this.password = password;
        this.averageNum = averageNum;
        this.numbersOfGames = numberOfGames;
        this.numbersTrying = numbersTrying;
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
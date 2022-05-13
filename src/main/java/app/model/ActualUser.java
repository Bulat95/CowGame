package app.model;

import app.entities.User;

public class ActualUser extends User {
    private String login = "null";
    private String password;
    public static ActualUser instance = new ActualUser();
    ActualUser(){

    }
    public ActualUser (User user){
        user.setAverage_num(this.getAverage_num());
        user.setNumberOfGames(this.getNumberOfGames());
        user.setNumbersTrying(this.getNumbersTrying());

    }
    public static ActualUser getInstance() {
        return instance;
    }
    static void setInstance (ActualUser actualUser) {
        instance = actualUser;
    }

    @Override
    public void setName(String login) {
        this.login = login;
        super.setName(login);
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
        super.setPassword(password);
    }

    @Override
    public void setAverage_num(int average_num) {
        super.setAverage_num(average_num);
    }

    @Override
    public void setNumberOfGames(int numberOfGames) {
        super.setNumberOfGames(numberOfGames);
    }

    @Override
    public void setNumbersTrying(int numbersTrying) {
        super.setNumbersTrying(numbersTrying);
    }
}

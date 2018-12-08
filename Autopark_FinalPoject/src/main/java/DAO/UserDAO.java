package DAO;

import Model.User;
import java.util.List;

public class UserDAO {

    UserDAO() {}

    public boolean addNewUser(User aUser) {
        return false;
    }

    public boolean editUser() {return false; }

    public List<User> allUsers() {return null;}

    public User findUserByLoginAndPassword(String aLogin, String aPassword) {return null;}

    public boolean deleteUser(int anID) {return false;}

}

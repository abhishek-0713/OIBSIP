import java.util.ArrayList;

public class Bank {

    private ArrayList<User> users;
    private User currentUser;

    public Bank() {
        this.users = new ArrayList<>();
        this.currentUser = null;
        // add some initial test users
        users.add(new User("1234", "1111", "John", "Doe", 1000.0));
        users.add(new User("5678", "2222", "Jane", "Smith", 500.0));
    }

    public boolean authenticateUser(String userID, String userPIN) {
        for (User user : users) {
            if (user.getUserID().equals(userID) && user.authenticate(userPIN)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUserByID(String userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
}
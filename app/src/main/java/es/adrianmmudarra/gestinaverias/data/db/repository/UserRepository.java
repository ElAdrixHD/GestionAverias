package es.adrianmmudarra.gestinaverias.data.db.repository;

import java.util.ArrayList;

import es.adrianmmudarra.gestinaverias.data.db.model.KindUser;
import es.adrianmmudarra.gestinaverias.data.db.model.User;

public class UserRepository {
    private ArrayList<User> users;
    private static UserRepository userRepository = new UserRepository();

    public UserRepository(){
        users = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        add(new User(0,"Adrián Muñoz Mudarra","correo@adrianmmudarra.es", "123456789","1997/12/27", KindUser.ADMINISTRATOR));
        add(new User(1,"Pepito Grillo","tomate@pera.es", "123456789","1997/12/27", KindUser.NORMAL_USER));
    }

    private void add(User user){
        users.add(user);
    }

    public static UserRepository getInstance(){
        return userRepository;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean validateUser(String email, String password) {
        for(User user : users){
            if ((user.getEmail().equals(email)) && (user.getPassword().equals(password)))
                return true;
        }
        return false;
    }
}

package es.adrianmmudarra.gestionaverias.data.db.repository;

import java.util.ArrayList;

import es.adrianmmudarra.gestionaverias.data.db.model.KindUser;
import es.adrianmmudarra.gestionaverias.data.db.model.User;

public class UserRepository {
    private ArrayList<User> users;

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

    public ArrayList<User> getUsers(){
        return users;
    }

    public User validateUser(String email, String password) {
        for(User user : users){
            if ((user.getEmail().equals(email)) && (user.getPassword().equals(password)))
                return user;
        }
        return null;
    }

    public boolean existsUser(String email){
        for(User user : users){
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    public void registerUser(String name, String email, String password, String birthday) {
        int newID = (users.get(users.size() - 1).getId_user()) + 1;
        add(new User(newID, name, email, password, birthday, KindUser.NORMAL_USER));
    }
}

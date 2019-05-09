package es.adrianmmudarra.gestionaverias.ui.application;

import android.app.Application;

import es.adrianmmudarra.gestionaverias.data.db.model.KindUser;
import es.adrianmmudarra.gestionaverias.data.db.model.User;
import es.adrianmmudarra.gestionaverias.data.db.repository.UserRepository;

public class BreakdownApplication extends Application {

    private UserRepository userRepository;

    private User userLogged;

    @Override
    public void onCreate() {
        super.onCreate();
        userRepository = new UserRepository();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserLogged(User userLogged) {
        this.userLogged = userLogged;
    }

    public KindUser getKindUserLogged(){
        if (userLogged != null){
            return userLogged.getKindUser();
        }
        return null;
    }

    public int getIDUserLogged(){
        if (userLogged!=null){
            return userLogged.getId_user();
        }
        return -1;
    }
}

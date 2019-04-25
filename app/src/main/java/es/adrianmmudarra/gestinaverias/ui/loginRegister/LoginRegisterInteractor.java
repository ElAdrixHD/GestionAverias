package es.adrianmmudarra.gestinaverias.ui.loginRegister;


import android.os.Handler;
import android.text.TextUtils;

import es.adrianmmudarra.gestinaverias.data.db.model.User;
import es.adrianmmudarra.gestinaverias.data.db.repository.UserRepository;

public class LoginRegisterInteractor {

    private UserRepository userRepository;

    public void LoginCredentials(final String email, final String password, final LoginInteractor listener){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(email)){
                    listener.onEmailEmptyError();
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordEmptyError();
                }else{
                    if (!UserRepository.getInstance().validateUser(email,password)){
                        listener.onAuthenticationError();
                    }else {
                        listener.onSuccess();
                    }
                }
            }
        },2000);
    }

    public void RegisterCredentials(String email, String password, RegisterContract.Presenter listener){

    }

    interface LoginInteractor{
        void onEmailEmptyError();

        void onPasswordEmptyError();

        void onPasswordError();

        void onAuthenticationError();

        void onSuccess();

    }
}

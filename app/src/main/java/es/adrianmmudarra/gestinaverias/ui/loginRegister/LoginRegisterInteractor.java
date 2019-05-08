package es.adrianmmudarra.gestinaverias.ui.loginRegister;


import android.os.Handler;
import android.text.TextUtils;

import es.adrianmmudarra.gestinaverias.data.db.repository.UserRepository;

public class LoginRegisterInteractor {

    private UserRepository userRepository;

    public void LoginCredentials(final String email, final String password, final LoginInteractor listener){

        if(checkEmailLogin(email,listener) & checkPasswordLogin(password, listener)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (!UserRepository.getInstance().validateUser(email,password)){
                        listener.onAuthenticationError();
                        listener.onClearErrorPassword();
                        listener.onClearErrorEmail();
                    }else {
                        listener.onSuccess();
                        listener.onClearErrorPassword();
                        listener.onClearErrorEmail();
                    }
                }
            },2000);
        }
    }

    public void RegisterCredentials(final String name, final String email, final String password, String passwordConfirm, final String birthday, final RegisterInteractor listener){
        if((checkNameRegister(name,listener) & checkEmailRegister(email,listener) & checkPasswordRegister(password,listener) & checkPasswordConfirmRegister(passwordConfirm,listener) & checkBirthdayRegister(birthday,listener)) && checkPasswordMatchRegister(password,passwordConfirm,listener)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (UserRepository.getInstance().existsUser(email)){
                        listener.onEmailExistError();
                        listener.onClearErrorPasswordMatch();
                        listener.onClearErrorPassword();
                        listener.onClearErrorBirthday();
                        listener.onClearErrorName();
                        listener.onClearErrorPasswordConfirm();
                    }else{
                        UserRepository.getInstance().registerUser(name,email,password,birthday);
                        listener.onClearErrorPasswordMatch();
                        listener.onClearErrorPassword();
                        listener.onClearErrorBirthday();
                        listener.onClearErrorName();
                        listener.onClearErrorPasswordConfirm();
                        listener.onClearErrorEmail();
                        listener.onSuccess();
                    }
                }
            },2000);
        }
    }

    private boolean checkPasswordMatchRegister(String password, String passwordConfirm, RegisterInteractor listener) {
        if (!password.equals(passwordConfirm)){
            listener.onPasswordMatchError();
            return false;
        }
        listener.onClearErrorPasswordMatch();
        return true;
    }

    private boolean checkBirthdayRegister(String birthday, RegisterInteractor listener) {
        if (TextUtils.isEmpty(birthday)){
            listener.onBirthdayEmptyError();
            return false;
        }
        listener.onClearErrorBirthday();
        return true;
    }

    private boolean checkPasswordConfirmRegister(String passwordConfirm, RegisterInteractor listener) {
        if (TextUtils.isEmpty(passwordConfirm)){
            listener.onPasswordConfirmEmptyError();
            return false;
        }
        listener.onClearErrorPasswordConfirm();
        return true;
    }

    private boolean checkPasswordRegister(String password, RegisterInteractor listener) {
        if (TextUtils.isEmpty(password)){
            listener.onPasswordEmptyError();
            return false;
        }
        listener.onClearErrorPassword();
        return true;
    }

    private boolean checkEmailRegister(String email, RegisterInteractor listener) {
        if (TextUtils.isEmpty(email)){
            listener.onEmailEmptyError();
            return false;
        }
        listener.onClearErrorEmail();
        return true;
    }

    private boolean checkNameRegister(String name, RegisterInteractor listener) {
        if (TextUtils.isEmpty(name)){
            listener.onNameEmptyError();
            return false;
        }
        listener.onClearErrorName();
        return true;
    }

    private boolean checkEmailLogin(String email, LoginInteractor listener){
        if (TextUtils.isEmpty(email)){
            listener.onEmailEmptyError();
            return false;
        }
        listener.onClearErrorEmail();
        return true;
    }

    private boolean checkPasswordLogin(String password, LoginInteractor listener){
        if (TextUtils.isEmpty(password)){
            listener.onPasswordEmptyError();
            return false;
        }
        listener.onClearErrorPassword();
        return true;
    }

    interface LoginInteractor {
        void onEmailEmptyError();
        void onPasswordEmptyError();
        void onPasswordError();
        void onAuthenticationError();
        void onSuccess();
        void onClearErrorEmail();
        void onClearErrorPassword();

    }

    interface RegisterInteractor{
        void onEmailEmptyError();
        void onPasswordEmptyError();
        void onPasswordConfirmEmptyError();
        void onNameEmptyError();
        void onBirthdayEmptyError();
        void onPasswordMatchError();
        void onEmailExistError();
        void onSuccess();
        void onClearErrorEmail();
        void onClearErrorPassword();
        void onClearErrorName();
        void onClearErrorBirthday();
        void onClearErrorPasswordConfirm();
        void onClearErrorPasswordMatch();
    }
}

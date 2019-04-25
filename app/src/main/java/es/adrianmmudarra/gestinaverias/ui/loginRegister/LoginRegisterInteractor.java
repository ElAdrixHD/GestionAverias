package es.adrianmmudarra.gestinaverias.ui.loginRegister;

public class LoginRegisterInteractor {

    public void LoginCredentials(String email, String password, LoginContract.Presenter listener){

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

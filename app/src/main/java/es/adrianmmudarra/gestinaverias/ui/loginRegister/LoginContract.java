package es.adrianmmudarra.gestinaverias.ui.loginRegister;

public class LoginContract {
    public interface View{
        void hideProgressBar();
        void showProgressBar();
        void setEmailEmptyError();
        void setPasswordEmptyError();
        void setPasswordError();
        void setAuthenticationError();
        void onSuccess();
    }

    public interface Presenter{
        void validateCredentials(String email, String password);
    }
}

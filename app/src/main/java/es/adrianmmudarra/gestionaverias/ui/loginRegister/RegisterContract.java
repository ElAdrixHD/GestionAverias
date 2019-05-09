package es.adrianmmudarra.gestionaverias.ui.loginRegister;

import android.content.Context;

public class RegisterContract {
    public interface View{
        void hideProgressBar();
        void showProgressBar();
        void setEmailEmptyError();
        void setPasswordEmptyError();
        void setPasswordConfirmEmptyError();
        void setNameEmptyError();
        void setBirthdayEmptyError();
        void setPasswordMatchError();
        void setEmailExistError();
        void onSuccess();
        void clearErrorEmail();
        void clearErrorPassword();
        void clearErrorName();
        void clearErrorBirthday();
        void clearErrorPasswordConfirm();
    }

    public interface Presenter{
        void RegisterCredentials(String name, String email, String password, String passwordConfirm, String birthday, Context context);
    }
}

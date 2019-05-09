package es.adrianmmudarra.gestionaverias.ui.loginRegister;

import android.content.Context;

public class RegisterPresenter implements RegisterContract.Presenter, LoginRegisterInteractor.RegisterInteractor {

    private RegisterContract.View view;
    private LoginRegisterInteractor interactor;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        interactor = new LoginRegisterInteractor();
    }

    @Override
    public void RegisterCredentials(String name, String email, String password, String passwordConfirm, String birthday, Context context) {
        view.showProgressBar();
        interactor.RegisterCredentials(name,email,password,passwordConfirm,birthday,this, context);
    }

    @Override
    public void onEmailEmptyError() {
        view.setEmailEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onPasswordEmptyError() {
        view.setPasswordEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onPasswordConfirmEmptyError() {
        view.setPasswordConfirmEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onNameEmptyError() {
        view.setNameEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onBirthdayEmptyError() {
        view.setBirthdayEmptyError();
        view.hideProgressBar();
    }

    @Override
    public void onPasswordMatchError() {
        view.setPasswordMatchError();
        view.hideProgressBar();
    }

    @Override
    public void onEmailExistError() {
        view.setEmailExistError();
        view.hideProgressBar();
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
        view.hideProgressBar();
    }

    @Override
    public void onClearErrorEmail() {
        view.clearErrorEmail();
    }

    @Override
    public void onClearErrorPassword() {
        view.clearErrorPassword();
    }

    @Override
    public void onClearErrorName() {
        view.clearErrorName();
    }

    @Override
    public void onClearErrorBirthday() {
        view.clearErrorBirthday();
    }

    @Override
    public void onClearErrorPasswordConfirm() {
        view.clearErrorPasswordConfirm();
    }

    @Override
    public void onClearErrorPasswordMatch() {
        view.clearErrorPassword();
    }
}

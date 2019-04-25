package es.adrianmmudarra.gestinaverias.ui.loginRegister;

public class LoginPresenter implements LoginContract.Presenter, LoginRegisterInteractor.LoginInteractor {

    private LoginContract.View view;
    private LoginRegisterInteractor interactor;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.interactor = new LoginRegisterInteractor();
    }

    @Override
    public void validateCredentials(String email, String password) {
        view.showProgressBar();
        interactor.LoginCredentials(email,password,this);
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
    public void onPasswordError() {
        //Hace algo pero no sé
    }

    @Override
    public void onAuthenticationError() {
        view.setAuthenticationError();
        view.hideProgressBar();
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
        view.hideProgressBar();
    }
}

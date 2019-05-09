package es.adrianmmudarra.gestionaverias.ui.loginRegister;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.adrianmmudarra.gestionaverias.R;
import es.adrianmmudarra.gestionaverias.ui.breakdownslist.BreakdownActivity;

public class LoginView extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private LoginContract.Presenter presenter;
    private ProgressDialog progressBar;

    TextView tv_email, tv_password, tv_email_error, tv_password_error;
    EditText ed_email, ed_password;
    Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        setTitle("Inicio Sesión");
        tv_email = findViewById(R.id.tv_login_email);
        tv_email_error = findViewById(R.id.tv_login_email_error);
        tv_password = findViewById(R.id.tv_login_password);
        tv_password_error = findViewById(R.id.tv_login_password_error);
        ed_email = findViewById(R.id.ed_login_email);
        ed_password = findViewById(R.id.ed_login_password);
        btn_login = findViewById(R.id.btn_login_login);
        btn_register = findViewById(R.id.btn_login_register);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        presenter = new LoginPresenter(this);
    }

    @Override
    public void hideProgressBar() {
        if (progressBar != null){
            progressBar.dismiss();
        }
    }

    @Override
    public void showProgressBar() {
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(false);
        progressBar.setIndeterminate(true);
        progressBar.setCanceledOnTouchOutside(false);
        progressBar.setMessage("Iniciando Sesion... \n\nEspere por favor.");
        progressBar.setTitle(R.string.app_name);
        progressBar.show();

    }

    @Override
    public void setEmailEmptyError() {
        tv_email_error.setText("El campo del correo no puede estar vacio.");
    }

    @Override
    public void setPasswordEmptyError() {
        tv_password_error.setText("El campo de la contraseña no puede estar vacio.");
    }

    @Override
    public void setPasswordError() {
        //Hace algo pero no sé
    }

    @Override
    public void setAuthenticationError() {
        Toast.makeText(LoginView.this,"Credenciales inválidas",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(LoginView.this, BreakdownActivity.class));
        //Toast.makeText(LoginView.this,"Credenciales correctas",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearErrorEmail() {
        tv_email_error.setText("");
    }

    @Override
    public void clearErrorPassword() {
        tv_password_error.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_login:
                presenter.validateCredentials(ed_email.getText().toString(),ed_password.getText().toString(),this);
                break;
            case R.id.btn_login_register:
                startActivity(new Intent(LoginView.this,RegisterView.class));
                break;
        }
    }
}

package es.adrianmmudarra.gestinaverias.ui.loginRegister;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.adrianmmudarra.gestinaverias.R;
import es.adrianmmudarra.gestinaverias.utils.DatePickerFragment;

public class RegisterView extends AppCompatActivity implements View.OnClickListener, RegisterContract.View{

    TextView tv_name, tv_name_error, tv_email, tv_email_error, tv_password, tv_password_error, tv_password_confirm, tv_password_confirm_error, tv_birthday, tv_birthday_error;
    EditText ed_name, ed_email, ed_password, ed_password_confirm, ed_birthday;
    Button btn_confirm, btn_cancel;
    ProgressDialog progressBar;
    RegisterContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
    }

    private void initialize() {
        setTitle("Registro");
        tv_name = findViewById(R.id.tv_register_name);
        tv_name_error = findViewById(R.id.tv_register_name_error);
        tv_password = findViewById(R.id.tv_register_password);
        tv_password_confirm = findViewById(R.id.tv_register_password_confirm);
        tv_password_error = findViewById(R.id.tv_register_password_error);
        tv_password_confirm_error = findViewById(R.id.tv_register_password_confirm_error);
        tv_email = findViewById(R.id.tv_register_email);
        tv_email_error = findViewById(R.id.tv_register_email_error);
        tv_birthday = findViewById(R.id.tv_register_birthday);
        tv_birthday_error = findViewById(R.id.tv_register_birthday_error);
        ed_name = findViewById(R.id.ed_register_name);
        ed_email = findViewById(R.id.ed_register_email);
        ed_password = findViewById(R.id.ed_register_password);
        ed_password_confirm = findViewById(R.id.ed_register_password_confirm);
        ed_birthday = findViewById(R.id.ed_register_birthday);
        btn_confirm = findViewById(R.id.btn_register_confirm);
        btn_cancel = findViewById(R.id.btn_register_cancel);
        presenter = new RegisterPresenter(this);
        btn_cancel.setOnClickListener(this);
        ed_birthday.setOnClickListener(this);
        btn_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ed_register_birthday:
                showDatePicker();
                break;
            case R.id.btn_register_cancel:
                finish();
                break;
            case R.id.btn_register_confirm:
                presenter.RegisterCredentials(ed_name.getText().toString(), ed_email.getText().toString(),ed_password.getText().toString(), ed_password_confirm.getText().toString(),ed_birthday.getText().toString());
                break;
        }
    }

    private void showDatePicker() {
        DatePickerFragment datePickerFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = year + "/" + (month+1) + "/" + day;
                ed_birthday.setText(selectedDate);
            }
        });
        datePickerFragment.show(this.getSupportFragmentManager(), "datePicker");
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
        progressBar.setMessage("Registrando... \n\nEspere por favor.");
        progressBar.setTitle(R.string.app_name);
        progressBar.show();
    }

    @Override
    public void setEmailEmptyError() {
        tv_email_error.setText("El campo del correo no puede estar vacio");
    }

    @Override
    public void setPasswordEmptyError() {
        tv_password_error.setText("No puede estar vacio");
    }

    @Override
    public void setPasswordConfirmEmptyError() {
        tv_password_confirm_error.setText("No puede estar vacio");
    }

    @Override
    public void setNameEmptyError() {
        tv_name_error.setText("El campo del nombre no puede estar vacio");
    }

    @Override
    public void setBirthdayEmptyError() {
        tv_birthday_error.setText("El campo de la fecha de naciemiento no puede estar vacio");
    }

    @Override
    public void setPasswordMatchError() {
        tv_password_error.setText("Las contraseñas no coinciden");
    }

    @Override
    public void setEmailExistError() {
        tv_email_error.setText("El correo electrónico ya existe");
    }

    @Override
    public void onSuccess() {
        Toast.makeText(RegisterView.this,"Registro realizado",Toast.LENGTH_SHORT).show();
        finish();
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
    public void clearErrorName() {
        tv_name_error.setText("");
    }

    @Override
    public void clearErrorBirthday() {
        tv_birthday_error.setText("");
    }

    @Override
    public void clearErrorPasswordConfirm() {
        tv_password_confirm_error.setText("");
    }
}

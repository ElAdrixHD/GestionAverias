package es.adrianmmudarra.gestinaverias.ui.loginRegister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.adrianmmudarra.gestinaverias.R;

public class RegisterView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();
    }

    private void initialize() {
        setTitle("Registro");
    }
}

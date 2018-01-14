package cocm.herusantoso.app.loginappmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cocm.herusantoso.app.loginappmvp.presenter.LoginPresenter;
import cocm.herusantoso.app.loginappmvp.presenter.LoginPresenterImpl;
import cocm.herusantoso.app.loginappmvp.presenter.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter presenter;

    private EditText etUsername;
    private EditText etPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenterImpl(this);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPass = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(etUsername.getText().toString(), etPass.getText().toString());
            }
        });
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "Masukan username and password yang valid!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login gagal!", Toast.LENGTH_SHORT).show();
    }
}

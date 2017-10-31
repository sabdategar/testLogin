package tegar.daily.loginmvp.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tegar.daily.loginmvp.BaseView;
import tegar.daily.loginmvp.PokemonActivity;
import tegar.daily.loginmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    LoginPresenterImp presenter;
    TextView tv_satu;
    EditText et_username, et_password;
    Button bt_login;

    BaseView baseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        presenter = new LoginPresenterImp(this);
        baseView = new BaseView();
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login(et_username.getText().toString(), et_password.getText().toString());
            }
        });
    }

    private void initView(){
        tv_satu = (TextView)findViewById(R.id.tv_satu);
        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);
        bt_login = (Button)findViewById(R.id.bt_login);
    }

    @Override
    public void loginSuccess() {
        baseView.makeToast(this, "Berhasil");
        Intent intent = new Intent(LoginActivity.this, PokemonActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginError() {
        baseView.makeToast(this, "Gagal");
    }

    @Override
    public void validationError() {
        baseView.makeToast(this, "Data Tidak Valid");
    }
}

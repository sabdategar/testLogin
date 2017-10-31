package tegar.daily.loginmvp.login;

import android.text.TextUtils;

/**
 * Created by Sabda Tegar Aditya on 10/19/2017.
 * linkedln : Sabda Tegar.
 */

public class LoginPresenterImp implements LoginPresenter {
    LoginView loginView;

    public LoginPresenterImp(LoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.validationError();
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                loginView.loginSuccess();
            } else {
                loginView.loginError();
            }
        }
    }
}

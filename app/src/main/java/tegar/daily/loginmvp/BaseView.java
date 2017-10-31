package tegar.daily.loginmvp;

import android.app.Notification;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sabda Tegar Aditya on 10/19/2017.
 * linkedln : Sabda Tegar.
 */

public class BaseView {
    public void makeToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}

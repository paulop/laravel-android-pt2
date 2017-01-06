package schoolofnet.com.financial;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Avell 1511 on 1/5/2017.
 */

public class UserSession {

    private static UserSession userSession;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor = null;

    public UserSession(Context context) {
        sharedPreferences = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static UserSession getInstance(Context context) {
        if (userSession != null) {
            return userSession;
        }

        userSession = new UserSession(context);

        return userSession;
    }

    public void setUser(String token) {
        editor.putString("token", token);
        editor.commit();
    }

    public String getUserToken() {
        return sharedPreferences.getString("token", "");
    }

    public Boolean isUserLoggedIn() {
        return sharedPreferences.getString("token", "").length() > 0;
    }

    public void clearSession() {
//        editor.clear().commit();
        editor.remove("token").commit();
    }
}

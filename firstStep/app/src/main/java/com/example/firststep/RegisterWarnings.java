package com.example.firststep;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

public class RegisterWarnings {
    private TextView userNameWarning;
    private TextView userSurnameWarning;
    private TextView userDateWarning;
    private TextView userPasswordWarning;
    private TextView userRePasswordWarning;

    final String emptyWarning = "Это поле должно быть заполнено.";
    final String tooFewArgsWarning = "Это поле должно состоять не менее чем из 2 букв.";
    final String tooManyArgsWarning = "Это поле должно состоять не более чем из 20 букв.";
    final String passwordArgs = "Пароль должен состоять не менее чем из 8 букв.";
    final String notEqualPasswords = "Пароли не совпадают";



    RegisterWarnings(TextView userNameWarning, TextView userSurnameWarning, TextView userDateWarning,
                     TextView userPasswordWarning, TextView userRePasswordWarning) {
        this.userNameWarning = userNameWarning;
        this.userSurnameWarning = userSurnameWarning;
        this.userDateWarning = userDateWarning;
        this.userPasswordWarning = userPasswordWarning;
        this.userRePasswordWarning = userRePasswordWarning;
    }

    public void clearUserWarnings() {
        userNameWarning.setText("");
        userSurnameWarning.setText("");
        userDateWarning.setText("");
        userPasswordWarning.setText("");
        userRePasswordWarning.setText("");
    }

    public void emptyUserNameWarning() {
         userNameWarning.setText(emptyWarning);
    }

    public void emptyUserSurnameWarning() {
        userSurnameWarning.setText(emptyWarning);
    }

    public void emptyUserDateWarning() {
        userDateWarning.setText(emptyWarning);
    }

    public void emptyUserPasswordWarning() {
        userPasswordWarning.setText(emptyWarning);
    }

    public void emptyUserRePasswordWarning() {
        userRePasswordWarning.setText(emptyWarning);
    }

    public void nameTooFewArgsWarning(){userNameWarning.setText((tooFewArgsWarning));}

    public void nameTooManyArgsWarning(){userNameWarning.setText((tooManyArgsWarning));}

    public void surnameTooFewArgsWarning(){userSurnameWarning.setText(tooFewArgsWarning);}

    public void surnameTooManyArgsWarning(){userSurnameWarning.setText(tooManyArgsWarning);}

    public void passwordArgsWarning(){userPasswordWarning.setText(passwordArgs);}

    public void  notEqualPasswordsWarning(){userRePasswordWarning.setText(notEqualPasswords);}

}

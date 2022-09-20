package com.example.firststep;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class User {
    private EditText userName;
    private EditText userSurname;
    private Button userDate;
    private EditText userPassword;
    private EditText userRePassword;
    private RegisterWarnings userWarning;

    User(EditText userName, EditText userSurname, Button userDate, EditText userPassword,
         EditText userRePassword, RegisterWarnings userWarning) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userDate = userDate;
        this.userPassword = userPassword;
        this.userRePassword = userRePassword;
        this.userWarning = userWarning;
    }

    public EditText getUserName() {
        return userName;
    }

    private boolean getNameInfo() {
        if (TextUtils.isEmpty(userName.getText())) {
            userWarning.emptyUserNameWarning();
            return false;
        }
        if (TextUtils.getTrimmedLength(userName.getText()) < 2) {
            userWarning.nameTooFewArgsWarning();
            return false;
        }
        if (TextUtils.getTrimmedLength(userName.getText()) > 20) {
            userWarning.nameTooManyArgsWarning();
            return false;
        }
        return true;
    }

    private boolean getSurnameInfo() {
        if (TextUtils.isEmpty(userSurname.getText())) {
            userWarning.emptyUserSurnameWarning();
            return false;
        }
        if (TextUtils.getTrimmedLength(userSurname.getText()) < 2) {
            userWarning.surnameTooFewArgsWarning();
            return false;
        }
        if (TextUtils.getTrimmedLength(userSurname.getText()) > 20) {
            userWarning.surnameTooManyArgsWarning();
            return false;
        }
        return true;
    }

    private boolean getDateInfo() {
        if (TextUtils.isEmpty(userDate.getText())) {
            userWarning.emptyUserDateWarning();
            return false;
        }
        return true;


    }

    private boolean getPasswordInfo() {
        if (TextUtils.isEmpty(userPassword.getText())) {
            userWarning.emptyUserPasswordWarning();
            return false;
        }
        if (TextUtils.getTrimmedLength(userPassword.getText()) < 8) {
            userWarning.passwordArgsWarning();
            return false;
        }
        return true;
    }

    private boolean getRePasswordInfo() {
        if (TextUtils.isEmpty(userPassword.getText())) {
            userWarning.emptyUserRePasswordWarning();
            return false;
        }
        if (!TextUtils.equals(userPassword.getText(), userRePassword.getText())) {
            userWarning.notEqualPasswordsWarning();
            return false;
        }
        return true;
    }

    public boolean getInfo() {
        userWarning.clearUserWarnings();
        if (!getNameInfo()) {
            return false;
        }
        if (!getSurnameInfo()) {
            return false;
        }
        if (!getDateInfo()) {
            return false;
        }
        if (!getPasswordInfo()) {
            return false;
        }
        if (!getRePasswordInfo()) {
            return false;
        }
        return true;
    }
}

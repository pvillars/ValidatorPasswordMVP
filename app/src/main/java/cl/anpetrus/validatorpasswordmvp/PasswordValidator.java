package cl.anpetrus.validatorpasswordmvp;

/**
 * Created by Petrus on 21-08-2017.
 */

public class PasswordValidator {
    PasswordCallBack callback;

    public PasswordValidator(PasswordCallBack callback) {
        this.callback = callback;
    }

    public void validation(String value) {
        value = value.trim();
        if (value.length() > 0) {
            if (value.length() > 8) {
                callback.correct();
            } else {
                callback.wrong();
            }
        } else {
            callback.blankInput();
        }
    }
}

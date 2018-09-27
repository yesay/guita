package cn.suius.guita;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class MyPasswordEncoder implements PasswordEncoder {

    private final static String salt = "jiayan";

    @Override
    public String encode(CharSequence charSequence) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(charSequence,s);
    }
}

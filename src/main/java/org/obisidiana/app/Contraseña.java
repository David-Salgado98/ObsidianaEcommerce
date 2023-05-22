package org.obisidiana.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Contraseña {
    public static void main(String[] args) {

        PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

        String hashPwd = passwordEncoder.encode("12345");
        System.out.println(hashPwd);

    }

}

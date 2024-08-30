package dev.compaoli.finance.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class Encryption {

    private String claveSecreta ;

    private final String ALGORITHM = "AES";

    public Encryption(@Value("${app.config.AES_KEY}") String claveSecreta) {
        this.claveSecreta = claveSecreta;
    }

    public String encriptar(String texto) throws Exception {
        System.out.println(claveSecreta);
        SecretKeySpec secretKey = new SecretKeySpec(claveSecreta.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] textoEncriptado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }

    public String desencriptar(String texto) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(claveSecreta.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] textoDesencriptado = cipher.doFinal(Base64.getDecoder().decode(texto));
        return new String(textoDesencriptado);
    }

}

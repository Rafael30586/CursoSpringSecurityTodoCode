package org.example;

import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;


public class Main {
    public static void main(String[] args) {

        //Construimos extra claims
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", "prueba jwt");

        //Construimos jwt
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (1 * 60 *1000));

        String jwt;
        jwt = Jwts.builder()
                // cabecera
                .header()
                .type("JWT")
                .and()

                //payload
                .subject("pruebajwt")
                .expiration(expiration) //fecha de expiración
                .issuedAt(issuedAt) //fecha de emisión
                .claims(extraClaims)

                //firma
                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact();

        //Vemos nuestro jwt generado por pantalla
        System.out.println(jwt);
    }

    public static SecretKey generateKey(){
        //tiene que ser larga  porque dijimos que cumple con HS256
        String secretKey = "tengo que generar una key que sea larga 123456789 suscribite a Todocode";

        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
package org.example.utils;

import org.example.models.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBReader implements ICredentialsReader {
    private static final Logger log = LoggerFactory.getLogger(DBReader.class);

    public Credentials readCredentials(String path) {
        String email = "eiridyr@gmail.com";
        String sql = "SELECT email,password FROM credentials WHERE email=\"" + email + "\"";
        log.info("Connecting to DB: " + path);
        try (Connection c = DriverManager.getConnection(path)) {
            log.info("Execute sql: " + sql);
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                log.debug("Query result email: " + result.getString("email"));
                log.debug("Query result password: " + result.getString("password"));
                Credentials credentials = new Credentials();
                credentials.setEmail(result.getString("email"));
                credentials.setPassword(result.getString("password"));

                return credentials;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return new Credentials();
    }
}

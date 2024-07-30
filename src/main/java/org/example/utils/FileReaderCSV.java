package org.example.utils;

import org.example.models.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderCSV implements ICredentialsReader {
    private static final Logger log = LoggerFactory.getLogger(FileReaderCSV.class);

    public Credentials readCredentials(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            Credentials credentials = new Credentials();
            while ((line = br.readLine()) != null) {
                log.debug("Current line: " + line);
                String[] values = line.split(",");
                credentials.setEmail(values[0]);
                credentials.setPassword(values[1]);
            }

            return credentials;
        } catch (IOException e) {
            log.error("Can't find file. Error: " + e.getMessage());
        }

        return new Credentials();
    }
}

package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Credentials;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReaderJSON implements ICredentialsReader {
    private static final Logger log = LoggerFactory.getLogger(FileReaderJSON.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public Credentials readCredentials(String path) {
        try {
            log.info("Read JSON file with test data. File path: " + path);
            File file = new File(path);
            if (!file.exists() || file.isDirectory()) {
                log.error("File doesn't exist or it's a directory.");
                throw new IOException();
            }

            return mapper.readValue(file, Credentials.class);
        } catch (IOException e) {
            log.error("Can't find file. Error: " + e.getMessage());
        }

        return new Credentials();
    }

    public static JSONObject readFile(String path) {
        JSONObject jsonObject = null;
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            JSONTokener tokener = new JSONTokener(is);
            jsonObject = new JSONObject(tokener);
        } catch (IOException e) {
            log.error("Can't find file. Error: " + e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("File closing error: " + e.getMessage());
                }
            }
        }

        return jsonObject;
    }
}

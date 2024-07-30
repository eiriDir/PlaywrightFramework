package org.example.utils;

import org.example.models.Credentials;

public interface ICredentialsReader {
    Credentials readCredentials(String source);
}

package com.example.UntitledTestSuite.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountData {
    String Login;
    String Password;

    public AccountData(String login, String password) {
        Login = login;
        Password = password;
    }
}

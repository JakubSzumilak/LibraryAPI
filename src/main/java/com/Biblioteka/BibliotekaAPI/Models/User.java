package com.Biblioteka.BibliotekaAPI.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class User {
    private long id;
    private String username;
    private String password;
    private String role;
    private String email;
}

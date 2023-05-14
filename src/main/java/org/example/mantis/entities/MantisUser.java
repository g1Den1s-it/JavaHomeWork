package org.example.mantis.entities;

import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
@Data
public class MantisUser {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "username", nullable = false, length = 191)
    private String username;

    @Column(name = "realname", nullable = false, length = 191)
    private String realname;

    @Column(name = "email", nullable = false, length = 191)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "enabled", nullable = false)
    private int enabled;

    @Column(name = "protected", nullable = false)
    private int isProtected;

    @Column(name = "access_level", nullable = false)
    private int accessLevel;

    @Column(name = "login_count", nullable = false)
    private int loginCount;

    @Column(name = "lost_password_request_count", nullable = false)
    private int lostPasswordRequestCount;

    @Column(name = "failed_login_count", nullable = false)
    private int failedLoginCount;

    @Column(name = "cookie_string", nullable = false, length = 64)
    private String cookieString;

    @Column(name = "last_visit", nullable = false)
    private long lastVisit;

    @Column(name = "date_created", nullable = false)
    private long dateCreated;

    // getters and setters
}
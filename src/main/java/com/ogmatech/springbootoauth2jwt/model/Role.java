package com.ogmatech.springbootoauth2jwt.model;

import javax.persistence.Entity;

public enum Role {
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_REGISTER,
    ROLE_TRUSTED_CLIENT,
    ROLE_CLIENT
}

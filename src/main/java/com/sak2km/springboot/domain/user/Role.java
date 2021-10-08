package com.sak2km.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "guest"),
    USER("ROLER_USER", "regular user");

    private final String key;
    private final String title;
}

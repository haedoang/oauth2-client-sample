package io.haedoang.secure.user.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * packageName : io.haedoang.secure.user.domain
 * fileName : SessionUser
 * author : haedoang
 * date : 2022-05-26
 * description :
 */
@Data
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

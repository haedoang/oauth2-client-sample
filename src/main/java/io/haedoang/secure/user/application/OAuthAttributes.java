package io.haedoang.secure.user.application;

import io.haedoang.secure.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * packageName : io.haedoang.secure.user.application
 * fileName : OAuthAttributes
 * author : haedoang
 * date : 2022-05-26
 * description :
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if (registrationId.equals("google")) {
            return new OAuthAttributes(
                    attributes,
                    userNameAttributeName,
                    (String) attributes.get("name"),
                    (String) attributes.get("email"),
                    (String) attributes.get("picture")
            );
        } else if (registrationId.equals("kakao")) {
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");

            return new OAuthAttributes(attributes, userNameAttributeName, (String) profile.get("nickname"), (String) kakaoAccount.get("email"), (String) profile.get("profile_image_url"));
        } else if (registrationId.equals("naver")) {
            Map<String, Object> response = (Map<String, Object>) attributes.get("response");
            return new OAuthAttributes(attributes, userNameAttributeName, (String) response.get("nickname"), (String) response.get("email"), (String) response.get("profile_image"));
        } else if (registrationId.equals("github")) {
            return new OAuthAttributes(attributes, userNameAttributeName, (String) attributes.get("login"), (String) attributes.get("email"), (String) attributes.get("avatar_url"));
        }

        throw new AssertionError();
    }

    public User toEntity() {
        return new User(name, email, picture);
    }
}

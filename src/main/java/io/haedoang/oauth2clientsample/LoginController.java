package io.haedoang.oauth2clientsample;

import io.haedoang.oauth2clientsample.user.domain.SessionUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * packageName : io.haedoang.secure
 * fileName : LoginController
 * author : haedoang
 * date : 2022-05-26
 * description :
 */
@RestController
public class LoginController {

    @GetMapping("login-success")
    public SessionUser loginSuccess(HttpSession session) {
        return (SessionUser) session.getAttribute("user");
    }
}

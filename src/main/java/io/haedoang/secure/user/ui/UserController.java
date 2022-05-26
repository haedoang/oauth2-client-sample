package io.haedoang.secure.user.ui;

import io.haedoang.secure.user.domain.User;
import io.haedoang.secure.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : io.haedoang.secure.user.ui
 * fileName : UserController
 * author : haedoang
 * date : 2022-05-26
 * description :
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

}

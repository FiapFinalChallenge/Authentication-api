package authentication.application.controller.contract;

import authentication.application.dto.response.UserResponse;
import org.springframework.web.bind.annotation.*;

public interface IUserController {

    @GetMapping("{id}")
    UserResponse getById(@PathVariable Long id);

    @DeleteMapping("{id}")
    void deleteById(@PathVariable Long id);
}

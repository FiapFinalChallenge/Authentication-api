package authentication.application.controller;

import authentication.application.controller.contract.IUserController;
import authentication.application.dto.response.UserResponse;
import authentication.domain.service.contract.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController implements IUserController {

    private final IUserService service;

    @Override
    public UserResponse getById(Long id) {
        return service.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}

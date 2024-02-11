package authentication.application.controller;

import authentication.application.controller.contract.IUserController;
import authentication.application.dto.request.UserRequest;
import authentication.application.dto.response.UserResponse;
import authentication.domain.service.contract.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final IUserService service;

    @Override
    public List<UserResponse> getAll() {
        return service.getAll();
    }

    @Override
    public UserResponse getById(Long id) {
        return service.getById(id);
    }

    @Override
    public UserResponse create(UserRequest request) {
        return service.create(request);
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        return service.update(id, request);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}

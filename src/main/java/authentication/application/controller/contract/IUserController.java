package authentication.application.controller.contract;

import authentication.application.dto.request.UserRequest;
import authentication.application.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IUserController {

    @GetMapping
    List<UserResponse> getAll();

    @GetMapping("{id}")
    UserResponse getById(@PathVariable Long id);

    @PostMapping
    UserResponse create(@RequestBody @Valid UserRequest request);

    @PutMapping("{id}")
    UserResponse update(@PathVariable Long id, @RequestBody @Valid UserRequest request);

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}

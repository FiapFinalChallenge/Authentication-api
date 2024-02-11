package authentication.domain.service.contract;

import authentication.application.dto.request.UserRequest;
import authentication.application.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    List<UserResponse> getAll();

    UserResponse getById(Long id);

    UserResponse create(UserRequest request);

    UserResponse update(Long id, UserRequest request);

    void delete(Long id);
}

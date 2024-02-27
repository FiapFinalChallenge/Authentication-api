package authentication.domain.service.contract;

import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.UserResponse;
import authentication.domain.model.User;

public interface IUserService {

    UserResponse getById(Long id);

    User create(SignUpRequest signUpRequest);

    void deleteById(Long id);
}

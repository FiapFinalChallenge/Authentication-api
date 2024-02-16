package authentication.domain.service.contract;

import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.UserResponse;

public interface IUserService {

    UserResponse getById(Long id);

    void create(SignUpRequest signUpRequest);

    void delete(Long id);
}

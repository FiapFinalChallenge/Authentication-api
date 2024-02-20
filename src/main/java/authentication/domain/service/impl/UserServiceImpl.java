package authentication.domain.service.impl;

import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.UserResponse;
import authentication.application.mapper.UserMapper;
import authentication.domain.repository.IUserRepository;
import authentication.domain.service.contract.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private static final String USER_NOT_FOUND = "User not found";
    private final IUserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponse getById(Long id) {
        return mapper.convertToUserResponse(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND)));
    }

    @Override
    public void create(SignUpRequest signUpRequest) {
        var encodedPassword = new BCryptPasswordEncoder().encode(signUpRequest.password());
        var user = mapper.convertToUser(signUpRequest);
        user.setPassword(encodedPassword);
        repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        repository.deleteById(id);
    }
}

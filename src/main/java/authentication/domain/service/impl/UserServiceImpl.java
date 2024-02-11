package authentication.domain.service.impl;

import authentication.application.dto.request.UserRequest;
import authentication.application.mapper.UserMapper;
import authentication.application.dto.response.UserResponse;
import authentication.domain.repository.IUserRepository;
import authentication.domain.service.contract.IUserService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;
    private final UserMapper mapper;
    private static final String USER_NOT_FOUND = "User not found";

    @Override
    public List<UserResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::convertToUserResponse)
                .toList();
    }

    @Override
    public UserResponse getById(Long id) {
        return mapper.convertToUserResponse(repository.findById(id)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND)));
    }

    @Override
    public UserResponse create(UserRequest request) {
        return mapper.convertToUserResponse(repository.save(mapper.convertToUser(request)));
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        getById(id);
        return mapper.convertToUserResponse(repository.save(mapper.convertToUser(request)));
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }
}

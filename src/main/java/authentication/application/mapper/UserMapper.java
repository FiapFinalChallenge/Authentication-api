package authentication.application.mapper;

import authentication.application.dto.request.UserRequest;
import authentication.application.dto.response.UserResponse;
import authentication.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    UserResponse convertToUserResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", source = "userRequest.username")
    @Mapping(target = "password", source = "userRequest.password")
    User convertToUser(UserRequest userRequest);
}

package authentication.application.dto.request;

import authentication.domain.enums.ERole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SignUpRequest(@NotBlank String username, @NotBlank String password, @NotNull ERole role) {
}

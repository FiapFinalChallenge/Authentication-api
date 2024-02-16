package authentication.application.controller.contract;

import authentication.application.dto.request.SignInRequest;
import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.JwtResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthController {

    @PostMapping("signup")
    JwtResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest);

    @PostMapping("signin")
    JwtResponse signIn(@RequestBody @Valid SignInRequest signInRequest);
}

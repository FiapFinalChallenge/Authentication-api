package authentication.application.controller;

import authentication.application.controller.contract.IAuthController;
import authentication.application.dto.request.SignInRequest;
import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.JwtResponse;
import authentication.infra.service.contract.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController implements IAuthController {

    private final IAuthService service;

    @Override
    public JwtResponse signUp(SignUpRequest signUpRequest) {
        return service.signUp(signUpRequest);
    }

    @Override
    public JwtResponse signIn(SignInRequest signInRequest) {
        return service.signIn(signInRequest);
    }
}

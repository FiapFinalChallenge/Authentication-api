package authentication.infra.service;

import authentication.application.dto.request.SignInRequest;
import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.JwtResponse;
import authentication.domain.exception.AuthenticationApiException;
import authentication.domain.service.contract.IUserService;
import authentication.infra.service.contract.IAuthService;
import authentication.infra.service.contract.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final IJwtService jwtService;
    private final IUserService userService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtResponse signUp(SignUpRequest signUpRequest) {
        userService.create(signUpRequest);
        return new JwtResponse(jwtService.generateToken(signUpRequest.username()));
    }

    @Override
    public JwtResponse signIn(SignInRequest signInRequest) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.username(), signInRequest.password()));

        if (!authentication.isAuthenticated()) {
            throw new AuthenticationApiException("Invalid user.");
        }

        return new JwtResponse(jwtService.generateToken(signInRequest.username()));
    }
}

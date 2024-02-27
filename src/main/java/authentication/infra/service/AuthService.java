package authentication.infra.service;

import authentication.application.dto.request.SignInRequest;
import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.JwtResponse;
import authentication.domain.service.contract.IUserService;
import authentication.infra.service.contract.IAuthService;
import authentication.infra.service.contract.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final IJwtService jwtService;
    private final IUserService userService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtResponse signUp(SignUpRequest signUpRequest) {
        return new JwtResponse(jwtService.generateToken(userService.create(signUpRequest)));
    }

    @Override
    public JwtResponse signIn(SignInRequest signInRequest) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.username(), signInRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var userDetails = (UserDetails) authentication.getPrincipal();

        return new JwtResponse(jwtService.generateToken(userDetails));
    }
}

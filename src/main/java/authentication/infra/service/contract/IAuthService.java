package authentication.infra.service.contract;

import authentication.application.dto.request.SignInRequest;
import authentication.application.dto.request.SignUpRequest;
import authentication.application.dto.response.JwtResponse;

public interface IAuthService {

    JwtResponse signUp(SignUpRequest signUpRequest);

    JwtResponse signIn(SignInRequest signInRequest);
}

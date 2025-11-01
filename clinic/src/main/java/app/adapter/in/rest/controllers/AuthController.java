package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.AuthRestMapper;
import app.adapter.rest.request.AuthRequest;
import app.adapter.rest.response.TokenResponseDto;
import app.application.usecases.LoginUseCase;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginUseCase loginUseCase;

    @Autowired
    private AuthRestMapper authRestMapper;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody AuthRequest request) throws Exception {
        AuthCredentials credentials = authRestMapper.toDomain(request);
        TokenResponse token = loginUseCase.login(credentials);
        return ResponseEntity.ok(authRestMapper.toResponse(token));
    }
}

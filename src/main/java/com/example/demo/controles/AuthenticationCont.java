//package com.example.demo.controles;
//
//import com.example.demo.dto.payload.AuthenticationResponse;
//import com.example.demo.dto.payload.LoginDataRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//public class AuthenticationCont {
//
//    private final AuthenticationManager authenticationManager;
//
//    public AuthenticationCont(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//
//    @PostMapping("/AuthenticationLogin")
//    public ResponseEntity<AuthenticationResponse> authenticateUser(@Valid @RequestBody LoginDataRequest
//                                                                   loginDataRequest){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginDataRequest.getEmail(),
//                        loginDataRequest.getPassword()
//                )
//        );
//            return null;
//    }
//
//}

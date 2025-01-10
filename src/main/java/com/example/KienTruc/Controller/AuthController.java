package com.example.KienTruc.Controller;

import com.example.KienTruc.Models.AuthRequest;
import com.example.KienTruc.Models.AuthResponse;
import com.example.KienTruc.Models.Users;
import com.example.KienTruc.Services.UsersService;
import com.example.KienTruc.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Đảm bảo rằng passwordEncoder được inject

    @Autowired
    private JwtUtil jwtUtil;  // Inject JwtUtil vào controller

    // Endpoint đăng ký người dùng mới
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        if (usersService.existsByUsername(username)) {
            return new ResponseEntity<>("Username đã tồn tại", HttpStatus.BAD_REQUEST);
        }

        Users newUser = usersService.registerUser(username, password);
        return new ResponseEntity<>("Đăng ký thành công", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        Optional<Users> user = usersService.findByUsername(username);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            // Tạo token khi đăng nhập thành công
            String token = jwtUtil.generateToken(username);

            // Tạo response chứa username và token
            AuthResponse authResponse = new AuthResponse(username, token);

            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tên người dùng hoặc mật khẩu không hợp lệ", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Endpoint is accessible without authentication!");
    }
}

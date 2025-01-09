package com.example.KienTruc.Services;

import com.example.KienTruc.Models.Users;
import com.example.KienTruc.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Đăng ký người dùng mới
    public Users registerUser(String username, String password) {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(passwordEncoder.encode(password));
        users.setRole("USER");
        return usersRepository.save(users);
    }

    // Kiểm tra sự tồn tại của username
    public boolean existsByUsername(String username) {
        return usersRepository.existsByUsername(username);
    }

    // Tìm người dùng theo username
    public Optional<Users> findByUsername(String username) {
        return usersRepository.findByUsername(username);  // Thay đổi để trả về Optional<Users>
    }
}

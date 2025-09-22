package com.seminar.seminar.user;

import com.seminar.seminar.dto.SignupRequest;
import com.seminar.seminar.exception.CustomException;
import com.seminar.seminar.exception.HttpStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void signup(SignupRequest request) {
        // 아이디 중복검사
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new CustomException(HttpStatus.CONFLICT, "이미 존재하는 아이디입니다.");
        }

        // 이메일 도메인 검사
        if (!request.getEmail().endsWith("@sookmyung.ac.kr")) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "숙명 이메일로만 가입할 수 있습니다.");
        }

        // USER 엔티티 생성 및 저장
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepository.save(user);
    }
}

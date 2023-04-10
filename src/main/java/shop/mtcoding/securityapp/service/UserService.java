package shop.mtcoding.securityapp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.securityapp.dto.UserRequest;
import shop.mtcoding.securityapp.dto.UserResponse;
import shop.mtcoding.securityapp.model.User;
import shop.mtcoding.securityapp.model.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 1. 트랜잭션 관리
     * 2. 영속성 객체 변경감지
     * 3. RequestDTO 요청받기
     * 4. 비즈니스 로직 처리ㅏ기
     * 5. ResponseDTO 응답하기
     */

    @Transactional // 트랜잭션의 시작, 변경 감지, 플러쉬 다해줌
    public UserResponse.JoinDto 회원가입(UserRequest.JoinDTO joinDTO){
        String rawPassword = joinDTO.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword); // password는 encode하면 60byte
        joinDTO.setPassword(encPassword);

        User userPS = userRepository.save(joinDTO.toEntity()); // 영속화된걸 return 해주면 됨
        return new UserResponse.JoinDto(userPS);
    }
}

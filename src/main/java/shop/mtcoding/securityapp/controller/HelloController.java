package shop.mtcoding.securityapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.securityapp.dto.ResponseDTO;
import shop.mtcoding.securityapp.dto.UserRequest;
import shop.mtcoding.securityapp.dto.UserResponse;
import shop.mtcoding.securityapp.service.UserService;

@RequiredArgsConstructor
@Controller
public class HelloController {

    private final UserService userService;
    
    @GetMapping("/")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(UserRequest.JoinDTO joinDTO){
        UserResponse.JoinDto data = userService.회원가입(joinDTO);
        // data.setRole("라ㅣㅇ너리ㅏㅁㄴㅇ"); // 더티체킹이 안됨, 엔티티가 아닌 dto 라서
        ResponseDTO<?> responseDTO = new ResponseDTO<>().data(data);
        return ResponseEntity.ok().body(responseDTO);
    }



     
}

package shop.mtcoding.securityapp.dto;



import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.securityapp.model.User;

public class UserRequest {
    
    @Getter @Setter
    public static class JoinDTO { // insert하는 엔티티에는 ToEntity가 필요함
        private String username;
        private String password;
        private String email;
        private String role;

        public User toEntity(){
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .status(true)
                    .build();
        }
    }
}

package me.minikuma._02_structual_patterns._06_adapter._01_before.security;

public class LoginHandler {
    // TODO: Login 처리
    UserDetailService userDetailService;

    public LoginHandler(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    public String login(String username, String password) {
        UserDetails userDetails = userDetailService.loadUser(username);
        if (userDetails.getPassword().equals(password)) {
            return userDetails.getUsername();
        } else {
            throw new IllegalArgumentException("Invalid User");
        }
    }
}

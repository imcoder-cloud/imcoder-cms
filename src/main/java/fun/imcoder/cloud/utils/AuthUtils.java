package fun.imcoder.cloud.utils;

import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthUtils {
    public static User getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = request.getHeader(ImcoderConfig.AUTH_HEADER);
        return (User) session.getAttribute(token);
    }
}

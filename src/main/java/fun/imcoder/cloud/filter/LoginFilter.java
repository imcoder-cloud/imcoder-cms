package fun.imcoder.cloud.filter;

import com.alibaba.fastjson.JSONObject;
import fun.imcoder.cloud.common.ResponseData;
import fun.imcoder.cloud.enums.ResponseEnum;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/api/admin/*"})
public class LoginFilter implements Filter {
    // 不需要登录就可以访问的路径(比如:注册登录等)
    private String[] includeUrls = new String[]{"/api/admin/user/login", "/api/admin/upload/*"};

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        String token = request.getHeader("Authorization");
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            chain.doFilter(req, res);
        } else {
            if (session != null && session.getAttribute(token) != null) {
                chain.doFilter(request, response);
            } else {
                response.getWriter().print(JSONObject.toJSONString(ResponseData.error(ResponseEnum.UNAUTHORIZED)));
            }
        }
    }

    private boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if (includeUrl.contains("*")) {
                includeUrl = includeUrl.substring(0, includeUrl.lastIndexOf("/"));
            }
            if (uri.startsWith(includeUrl)) {
                return false;
            }
        }
        return true;
    }

}

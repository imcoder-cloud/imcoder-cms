package fun.imcoder.cloud.controller.content;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {
    @GetMapping("/**")
    public String content(Model model, HttpServletRequest request) {
        model.addAttribute("title","coder的自我修养");
        String uri = request.getRequestURI();
        if("/".equals(uri)){
            return "index";
        }
        return uri;
    }
}

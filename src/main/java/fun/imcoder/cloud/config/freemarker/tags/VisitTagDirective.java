package fun.imcoder.cloud.config.freemarker.tags;

import freemarker.core.Environment;
import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.config.imcoder.ImcoderConfig;
import fun.imcoder.cloud.model.Visit;
import fun.imcoder.cloud.service.VisitService;
import fun.imcoder.cloud.utils.WebUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
@FreemarkerTag("visit")
public class VisitTagDirective implements ImcoderFreemarkerTag {
    @Resource
    private VisitService visitService;
    @Resource
    private HttpServletRequest request;

    @Override
    public Object getData(int page, int size, Map params, Environment environment) {
        Visit visitParam = new Visit();
        String ip = WebUtils.getRequestIp(request);
        String address = null;
        try {
            address = WebUtils.getAddress(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String client = WebUtils.getOsAndBrowserInfo(request);
        String source = request.getHeader("Referer");
        String uri = request.getRequestURI();
        String url = uri;
        String keyword = WebUtils.getKeyword(request);
        visitParam.setIp(ip);
        visitParam.setCountry(address.split(",")[0]);
        visitParam.setProvince(address.split(",")[1]);
        visitParam.setCity(address.split(",")[2]);
        visitParam.setIsp(address.split(",")[3]);
        visitParam.setOs(client.split(",")[0]);
        visitParam.setBrowser(client.split(",")[1]);
        visitParam.setTerminal(client.split(",")[2]);
        visitParam.setSource(source == null ? "直接打开" : source);
        visitParam.setUrl(url);
        visitParam.setKeyword(keyword);

        Visit visitInfo = (Visit) request.getSession().getAttribute("visitInfo");
        if (visitInfo == null) {
            visitParam.setType("UV");
            request.getSession().setAttribute("visitInfo", visitParam);
            visitService.save(visitParam);
        }
        visitParam.setType("PV");
        visitService.save(visitParam);
        return true;
    }

}

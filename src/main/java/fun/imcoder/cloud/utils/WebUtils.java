package fun.imcoder.cloud.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;
import fun.imcoder.cloud.common.HttpClientResult;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cdd
 * @date 2020-04-01
 */
@Slf4j
public class WebUtils {

    public static String getRequestIp(HttpServletRequest request) {
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if (index != -1) {
                return XFor.substring(0, index);
            } else {
                return XFor;
            }
        }
        XFor = Xip;
        if (!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }

    public static String getAddress(String ip) throws Exception {
        String path = "http://whois.pconline.com.cn/ipJson.jsp?ip=" + ip + "&json=true";
        HttpClientResult res = HttpClientUtils.doGet(path);
        String str = res.getContent();
        JSONObject json = JSON.parseObject(str);
        String err = json.getString("err");
        if ("".equals(err)) {
            return "," + json.getString("pro") + "," + json.getString("city") + "," + json.getString("addr");
        }
        return "未知,未知,未知,未知";
    }

    /**
     * 获取操作系统,浏览器及浏览器版本信息
     *
     * @param request
     * @return
     */
    public static String getOsAndBrowserInfo(HttpServletRequest request) {
        String browserDetails = request.getHeader("User-Agent");
        String userAgent = browserDetails;
        String user = userAgent.toLowerCase();

        String os = "";
        String browser = "";
        String terminal = "";

        if (userAgent.toLowerCase().indexOf("mobile") >= 0) {
            terminal = "移动端";
        } else {
            terminal = "PC端";
        }

        // =================OS Info=======================
        if (userAgent.toLowerCase().indexOf("windows") >= 0) {
            os = "Windows";
        } else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
            os = "Unix";
        } else if (userAgent.toLowerCase().indexOf("android") >= 0) {
            os = "Android";
        } else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
            os = "iPhone";
        } else if (userAgent.toLowerCase().indexOf("ipad") >= 0) {
            os = "iPad";
        } else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
            os = "Mac";
        } else {
            os = "其他";
        }
        // ===============Browser===========================
        if (user.contains("edge")) {
            browser = "Edge";
        } else if (user.contains("opr") || user.contains("opera")) {
            browser = "Opera";
        } else if (user.contains("firefox")) {
            browser = "Firefox";
        } else if (user.contains("rv")) {
            browser = "IE";
        } else if (user.contains("360")) {
            browser = "360浏览器";
        } else if (user.contains("lbbrowser")) {
            browser = "猎豹浏览器";
        } else if (user.contains("the world")) {
            browser = "世界之窗";
        } else if (user.contains("metasr")) {
            browser = "搜狗浏览器";
        } else if (user.contains("micromessenger")) {
            browser = "微信浏览器";
        } else if (user.contains("qq")) {
            browser = "QQ浏览器";
        } else if (user.contains("ucbrowser")) {
            browser = "UC浏览器";
        } else if (user.contains("chrome") && user.indexOf("mobile") < 0) {
            browser = "Chrome";
        } else {
            browser = "其他";
        }

        return os + "," + browser + "," + terminal;
    }

    public static String getSearchEngine(String refUrl) {
        if (refUrl != null && refUrl.length() > 11) {
            // p是匹配各种搜索引擎的正则表达式
            Pattern p = Pattern.compile(".*\\.(google\\.com(:\\d{1,}){0,1}\\/|"
                    + "google\\.cn(:\\d{1,}){0,1}\\/|baidu\\.com(:\\d{1,}){0,1}\\/|"
                    + "yahoo\\.com(:\\d{1,}){0,1}\\/|iask\\.com(:\\d{1,}){0,1}\\/|"
                    + "sogou\\.com(:\\d{1,}){0,1}\\/|163\\.com(:\\d{1,}){0,1}\\/|"
                    + "lycos\\.com(:\\d{1,}){0,1}\\/|aol\\.com(:\\d{1,}){0,1}\\/|"
                    + "3721\\.com(:\\d{1,}){0,1}\\/|search\\.com(:\\d{1,}){0,1}\\/|"
                    + "soso.com(:\\d{1,}){0,1}\\/|zhongsou\\.com(:\\d{1,}){0,1}\\/|"
                    + "so.com(:\\d{1,}){0,1}\\/|zhongsou\\.com(:\\d{1,}){0,1}\\/|"
                    + "alexa\\.com(:\\d{1,}){0,1}\\/)");
            Matcher m = p.matcher(refUrl);
            if (m.find()) {
                return insteadCode(m.group(1),
                        "(\\.com(:\\d{1,}){0,1}\\/|\\.cn(:\\d{1,}){0,1}\\/|\\.org(:\\d{1,}){0,1}\\/)", "");
            }
        }
        return "直接打开";
    }

    public static String insteadCode(String str, String regEx, String code) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String s = m.replaceAll(code);
        if (s.toLowerCase().contains("baidu")) {
            s = "百度";
        } else if (s.toLowerCase().contains("sogou")) {
            s = "搜狗";
        } else if (s.toLowerCase().contains("google")) {
            s = "谷歌";
        } else if (s.toLowerCase().contains("soso")) {
            s = "soso";
        } else if (s.toLowerCase().contains("so")) {
            s = "360搜索";
        } else if (s.toLowerCase().contains("yahoo")) {
            s = "雅虎";
        }
        return s;
    }

    public static String getKeyword(HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        StringBuffer sb = new StringBuffer();
        if (referer != null) {
            sb.append("(google\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)").append("|iask\\.[a-zA-Z]+/.+[\\&|\\?]k=([^\\&]*)")
                    .append("|iask\\.[a-zA-Z]+/.+[\\&|\\?]_searchkey=([^\\&]*)")
                    .append("|sogou\\.[a-zA-Z]+/.+[\\&|\\?]query=([^\\&]*)")
                    .append("|163\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)")
                    .append("|yahoo\\.[a-zA-Z]+/.+[\\&|\\?]p=([^\\&]*)")
                    .append("|baidu\\.[a-zA-Z]+/.+[\\&|\\?]wd=([^\\&]*)")
                    .append("|baidu\\.[a-zA-Z]+/.+[\\&|\\?]word=([^\\&]*)")
                    .append("|lycos\\.[a-zA-Z]+/.*[\\&|\\?]query=([^\\&]*)")
                    .append("|aol\\.[a-zA-Z]+/.+[\\&|\\?]encquery=([^\\&]*)")
                    .append("|3721\\.[a-zA-Z]+/.+[\\&|\\?]p=([^\\&]*)")
                    .append("|3721\\.[a-zA-Z]+/.+[\\&|\\?]name=([^\\&]*)")
                    .append("|search\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)")
                    .append("|soso\\.[a-zA-Z]+/.+[\\&|\\?]w=([^\\&]*)")
                    .append("|so\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)")
                    .append("|zhongsou\\.[a-zA-Z]+/.+[\\&|\\?]w=([^\\&]*)")
                    .append("|alexa\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)").append(")");
            Pattern p = Pattern.compile(sb.toString());
            Matcher m = p.matcher(referer);
            return decoderKeyword(m, referer);
        }
        return null;
    }

    public static String decoderKeyword(Matcher m, String refererUrl) {
        String keyword = "";
        String encode = "UTF-8";
        String searchEngine = getSearchEngine(refererUrl);
        if (searchEngine != null) {
            if ((checkCode("3721|iask|sogou|163|baidu|soso|zhongsou|so", searchEngine)
                    || (checkCode("yahoo", searchEngine) && !checkCode("ei=utf-8", refererUrl.toLowerCase())))) {
                encode = "GBK";
            }

            if (m.find()) {
                for (int i = 2; i <= m.groupCount(); i++) {
                    if (m.group(i) != null)// 在这里对关键字分组就用到了
                    {
                        try {
                            keyword = URLDecoder.decode(m.group(i), encode);
                        } catch (UnsupportedEncodingException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }
            }
        }
        return keyword;
    }

    public static boolean checkCode(String regEx, String str) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }


}

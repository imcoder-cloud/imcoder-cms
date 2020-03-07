package fun.imcoder.cloud.config.freemarker;

import fun.imcoder.cloud.model.Options;
import fun.imcoder.cloud.service.OptionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class FreemarkerConfig {
    @Resource
    private freemarker.template.Configuration configuration;
    @Resource
    private OptionsService optionsService;

    @PostConstruct
    public void setConfigure() throws Exception {
        List<Options> options = optionsService.list();
        Map<String,Object> optionMap = options.stream().collect(Collectors.toMap(Options::getOptionKey,Options::getOptionValue));
        configuration.setSharedVariable("options", optionMap);

    }
}

package fun.imcoder.cloud.config.freemarker;

import fun.imcoder.cloud.annotation.FreemarkerTag;
import fun.imcoder.cloud.model.Options;
import fun.imcoder.cloud.service.OptionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class FreemarkerConfig  implements ApplicationContextAware {
    ApplicationContext applicationContext ;
    @Resource
    private freemarker.template.Configuration configuration;
    @Resource
    private OptionsService optionsService;

    @PostConstruct
    public void setConfigure() throws Exception {
        List<Options> options = optionsService.list();
        Map<String,Object> optionMap = options.stream().collect(Collectors.toMap(Options::getOptionKey,Options::getOptionValue));
        configuration.setSharedVariable("options", optionMap);

        Map<String, Object> map = applicationContext.getBeansWithAnnotation(FreemarkerTag.class);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            configuration.setSharedVariable(entry.getKey(), entry.getValue());
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

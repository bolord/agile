package agile.autoconfigure;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import agile.config.fastjson.DataMaskingFilter;

@ConditionalOnClass(JSON.class)
@Configuration
public class FastJsonAutoConfiguration {

    @Resource
    private Environment env;

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 设置需要 FastJson 转换的 MediaTypes
        List<MediaType> supportedMediaTypes = new ArrayList<>();

        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        fastConverter.setSupportedMediaTypes(supportedMediaTypes);

        // FastJson 配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        if (env.acceptsProfiles("dev")) {
            fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        }

        // 过滤敏感属性
        DataMaskingFilter filter = new DataMaskingFilter();
        fastJsonConfig.setSerializeFilters(filter);

        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;

        return new HttpMessageConverters(converter);
    }

}

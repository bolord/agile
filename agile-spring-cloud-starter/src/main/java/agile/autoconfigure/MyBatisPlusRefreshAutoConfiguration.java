package agile.autoconfigure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;

@Profile("dev")
@Configuration
public class MyBatisPlusRefreshAutoConfiguration {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public MybatisMapperRefresh mybatisMapperRefresh() throws Exception {
        return new MybatisMapperRefresh(
                    new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"),
                    sqlSessionFactory,
                    3,
                    30,
                    true
                );
    }
}

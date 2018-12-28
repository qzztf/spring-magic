package cn.sexycode.spring.magic.ioc;

import cn.sexycode.spring.magic.ioc.setter.BeanDependencySetter;
import cn.sexycode.spring.magic.ioc.setter.BeanFactoryBeanDependencySetter;
import cn.sexycode.spring.magic.ioc.setter.SetterMethodBeanDependencySetter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.sexycode.spring")
public class TestConfig {

    @Bean
    public BeanFactoryAwareBean factoryAwareBean() {
        return new BeanFactoryAwareBean();
    }

    @Bean
    public BeanDependencySetter beanDependencySetter(BeanFactoryAwareBean factoryAwareBean) {
        return new SetterMethodBeanDependencySetter(factoryAwareBean);
    }

    @Bean
    public BeanDependencySetter beanDependencySetter2(BeanFactoryAwareBean factoryAwareBean) {
        return new BeanFactoryBeanDependencySetter(factoryAwareBean);
    }
    
    @Bean
    public BeanService beanService2() {
        return new BeanService();
    }
}

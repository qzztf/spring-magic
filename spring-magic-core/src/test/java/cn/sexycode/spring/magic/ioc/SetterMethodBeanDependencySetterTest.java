package cn.sexycode.spring.magic.ioc;

import cn.sexycode.spring.magic.ioc.setter.BeanDependencySetter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class SetterMethodBeanDependencySetterTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BeanDependencySetter setter;

    @Autowired
    @Qualifier("beanService2")
    private BeanService beanService;

    @Test
    public void setDependency() {
        userService.hello();
        setter.setDependency(userService, "beanService", beanService);
        userService.hello();
    }

    @Test
    public void setDependency1() {
    }
}
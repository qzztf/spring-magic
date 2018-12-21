package cn.sexycode.spring.magic.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private BeanService beanService;

    public String hello() {
        System.err.println(beanService);
        return beanService.toString();
    }

    @Autowired
    public void setBeanService(BeanService beanService) {
        this.beanService = beanService;
    }
}

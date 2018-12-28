package cn.sexycode.spring.magic.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private BeanService service;

    public String hello() {
        System.err.println(service);
        return service.toString();
    }

    @Autowired
    @Qualifier("beanService")
    public void setBeanService(BeanService service) {
        this.service = service;
    }
}

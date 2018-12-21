package cn.sexycode.spring.magic.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author qinzaizhen
 */
public class BeanFactoryAwareBean implements BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }

    public Object getBean(String name, Class<?> classType) {
        return beanFactory.getBean(name, classType);
    }
}

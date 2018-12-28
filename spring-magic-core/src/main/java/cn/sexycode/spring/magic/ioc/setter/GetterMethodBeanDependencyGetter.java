package cn.sexycode.spring.magic.ioc.setter;

import cn.sexycode.spring.magic.ioc.BeanFactoryAwareBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GetterMethodBeanDependencyGetter implements BeanDependencyGetter {
    private static final Logger LOGGER = Logger.getLogger(GetterMethodBeanDependencyGetter.class.getName());
    private BeanFactoryAwareBean beanFactory;

    public GetterMethodBeanDependencyGetter(BeanFactoryAwareBean beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getDependency(Object bean, String depName) {
        BeanWrapper wrapper = new BeanWrapperImpl(bean);
        Object propertyValue = null;
        try {
            propertyValue = wrapper.getPropertyValue(depName);
        } catch (BeansException e) {
            if (LOGGER.isLoggable(Level.WARNING)) {
                String msg = "未获取到 %s 属性 %s 值, 异常信息为:%s";
                LOGGER.info(String.format(msg, bean, depName, e.getMessage()));
            }
        }
        return propertyValue;
    }

    @Override
    public Object getDependency(String beanId, String depName) {
        return getDependency(beanFactory.getBean(beanId), depName);
    }
}

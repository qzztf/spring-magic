package cn.sexycode.spring.magic.ioc.setter;

import cn.sexycode.spring.magic.ioc.BeanFactoryAwareBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * set方法注入的依赖修改器
 *
 * @author qinzaizhen
 */
public class SetterMethodBeanDependencySetter implements BeanDependencySetter {

    private static final Logger LOGGER = Logger.getLogger(SetterMethodBeanDependencySetter.class.getName());
    private BeanFactoryAwareBean beanFactory;

    public SetterMethodBeanDependencySetter(BeanFactoryAwareBean beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object setDependency(Object bean, String depName, Object newDep) {
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
        try {
            wrapper.setPropertyValue(depName, newDep);
        } catch (BeansException e) {
            if (LOGGER.isLoggable(Level.WARNING)) {

                LOGGER.info(String.format("设置 %s 属性 %s 值失败, 异常信息为: %s", bean, depName, e.getMessage()));
            }
        }
        return propertyValue;
    }

    @Override
    public Object setDependency(String beanId, String depName, String newDepId) {
        return setDependency(beanFactory.getBean(beanId), depName, beanFactory.getBean(newDepId));
    }
}

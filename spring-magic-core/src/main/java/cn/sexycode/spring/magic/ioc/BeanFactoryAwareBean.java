package cn.sexycode.spring.magic.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.logging.Logger;

/**
 * @author qinzaizhen
 */
public class BeanFactoryAwareBean implements BeanFactoryAware {
    private static final Logger LOGGER = Logger.getLogger(BeanFactoryAwareBean.class.getName());

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public String[] getDependenciesForBean(String beanName) {
        if (beanFactory instanceof ConfigurableBeanFactory) {
            return ((ConfigurableBeanFactory) beanFactory).getDependenciesForBean(beanName);
        }
        LOGGER.warning("this factory doesn't support this method.");
        return new String[0];
    }


    public void registerDependentForBean(String beanName, String dependentBeanName) {
        if (beanFactory instanceof ConfigurableBeanFactory) {
            ((ConfigurableBeanFactory) beanFactory).registerDependentBean(beanName, dependentBeanName);
            beanFactory.getBean(beanName);
        } else {
            LOGGER.warning("this factory doesn't support this method.");
        }
    }

    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }

    public Object getBean(String name, Class<?> classType) {
        return beanFactory.getBean(name, classType);
    }
}

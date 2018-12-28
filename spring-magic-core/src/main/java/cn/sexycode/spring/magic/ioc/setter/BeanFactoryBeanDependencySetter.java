package cn.sexycode.spring.magic.ioc.setter;

import cn.sexycode.spring.magic.ioc.BeanFactoryAwareBean;

import java.util.logging.Logger;

/**
 * 通过beanFactory 提供的api来设置依赖
 * <br>
 * 目前不可用
 *
 * @author qinzaizhen
 */
public class BeanFactoryBeanDependencySetter implements BeanDependencySetter {
    private static final Logger LOGGER = Logger.getLogger(BeanFactoryBeanDependencySetter.class.getName());
    private BeanFactoryAwareBean beanFactory;

    public BeanFactoryBeanDependencySetter(BeanFactoryAwareBean beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object setDependency(Object bean, String depName, Object newDep) {
        return null;
    }

    @Override
    public Object setDependency(String beanId, String depName, String newDepId) {
        String[] dependenciesForBean = beanFactory.getDependenciesForBean(beanId);
//        Stream.of(dependenciesForBean).filter(name -> ).findFirst()
        beanFactory.registerDependentForBean(beanId, newDepId);
        return null;
    }
}

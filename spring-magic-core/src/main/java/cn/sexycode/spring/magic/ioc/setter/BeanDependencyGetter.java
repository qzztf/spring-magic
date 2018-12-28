package cn.sexycode.spring.magic.ioc.setter;

/**
 * bean依赖获取器
 *
 * @author qinzaizhen
 */
public interface BeanDependencyGetter {
    /**
     * 获取bean的属性
     *
     * @param bean    bean
     * @param depName 依赖名称
     * @return 依赖对象
     */
    Object getDependency(Object bean, String depName);

    /**
     * 设置bean的属性
     *
     * @param beanId  bean id
     * @param depName 依赖名称
     * @return 依赖对象
     */
    Object getDependency(String beanId, String depName);
}

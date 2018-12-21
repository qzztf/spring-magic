package cn.sexycode.spring.magic.ioc.setter;

/**
 * bean依赖设置器
 *
 * @author qinzaizhen
 */
public interface BeanDependencySetter {
    /**
     * 设置bean的属性
     *
     * @param bean    bean
     * @param depName 依赖名称
     * @param newDep  新的依赖对象
     * @return 原依赖
     */
    Object setDependency(Object bean, String depName, Object newDep);

    /**
     * 设置bean的属性
     *
     * @param beanId   bean id
     * @param depName  依赖名称
     * @param newDepId 新的依赖对象id
     * @return 原依赖
     */
    Object setDependency(String beanId, String depName, String newDepId);
}

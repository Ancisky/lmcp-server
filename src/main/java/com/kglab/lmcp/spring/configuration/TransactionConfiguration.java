package com.kglab.lmcp.spring.configuration;

import com.kglab.lmcp.global.handle.exception.result.SuccessResultMessage;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * 全局事物配置
 *
 * REQUIRED ：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
 * SUPPORTS ：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
 * MANDATORY ：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
 * REQUIRES_NEW ：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
 * NOT_SUPPORTED ：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
 * NEVER ：以非事务方式运行，如果当前存在事务，则抛出异常。
 * NESTED ：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于 REQUIRED 。
 * 指定方法：通过使用 propagation 属性设置，例如：@Transactional(propagation = Propagation.REQUIRED)
 * 参考文章；https://blog.csdn.net/schcilin/article/details/93306826
 * @author sc
 * @date 2021/2/4
 */
@Aspect
@Configuration
public class TransactionConfiguration {
    /** 配置方法过期时间，默认-1,永不超时 */
    private final static int TX_METHOD_TIME_OUT = 10;
    /** 被拦截的方法上已经注入事务，请不要再添加@Transactional注解，否则会出现rollback-only错误 */
    private static final String POITCUT_EXPRESSION = "execution(* com.kglab.lmcp.service..*.*(..))";
    @Autowired
    private TransactionManager transactionManager;



    /** 配置事务管理规则
     nameMap声明具备需要管理事务的方法名.
     这里使用public void addTransactionalMethod(String methodName, TransactionAttribute attr)
     */
    @Bean
    public TransactionInterceptor txadvice() {
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        Map<String, TransactionAttribute> nameMap = new HashMap<>(16);
        /*只读事物、不做更新删除等*/
        /*事务管理规则*/
        RuleBasedTransactionAttribute requireRule = new RuleBasedTransactionAttribute();
        /*抛出异常后执行切点回滚*/
        requireRule.setRollbackRules(Collections.singletonList(
                new NoRollbackRuleAttribute(SuccessResultMessage.class)
        ));
        /*PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。 */
        requireRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        nameMap.put("*", requireRule);  // 拦截所有方法
        source.setNameMap(nameMap);
        return new TransactionInterceptor(transactionManager, source);
    }


    /**
     * 设置切面=切点pointcut+通知TxAdvice
     *
     * @return
     */
    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(POITCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txadvice());
    }
}

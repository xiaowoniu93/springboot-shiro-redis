package com.xszheng.support.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * AccessdecisionManager 在 Spring security 中是很重要的。  
 * 在验证部分简略提过了，所有的 Authentication 实现需要保存在一个 GrantedAuthority 对象数组中。   
 * 这就是赋予给主体的权限。 GrantedAuthority 对象通过 AuthenticationManager 保存到 Authentication 对象里，然后从 AccessDecisionManager 读出来，进行授权判断。   
 *  
 * Spring Security提供了一些拦截器，来控制对安全对象的访问权限，例如方法调用或web请求。   
 * 一个是否允许执行调用的预调用决定，是由AccessDecisionManager实现的。   
 * 这个 AccessDecisionManager 被AbstractSecurityInterceptor调用，  
 * 它用来作最终访问控制的决定。 这个AccessDecisionManager接口包含三个方法：   
 
 void decide(Authentication authentication, Object secureObject, List<ConfigAttributeDefinition> config) throws AccessDeniedException;  
 boolean supports(ConfigAttribute attribute);  
 boolean supports(Class clazz);  
   
  从第一个方法可以看出来，AccessDecisionManager使用方法参数传递所有信息，这好像在认证评估时进行决定。   
  特别是，在真实的安全方法期望调用的时候，传递安全Object启用那些参数。   
  比如，让我们假设安全对象是一个MethodInvocation。   
  很容易为任何Customer参数查询MethodInvocation，  
  然后在AccessDecisionManager里实现一些有序的安全逻辑，来确认主体是否允许在那个客户上操作。   
  如果访问被拒绝，实现将抛出一个AccessDeniedException异常。  
  
  这个 supports(ConfigAttribute) 方法在启动的时候被 AbstractSecurityInterceptor 调用，来决定 AccessDecisionManager 是否可以执行传递ConfigAttribute。   
  supports(Class)方法被安全拦截器实现调用，  
  包含安全拦截器将显示的AccessDecisionManager支持安全对象的类型。
 * @author xiaosun.zheng
 *
 */
@Service
public class CustomAccessDecisionManager implements AccessDecisionManager {

	// 检查用户是否够权限访问资源
    // 参数 authentication 是从 spring 的全局缓存 SecurityContextHolder 中拿到的，里面是用户的权限信息
    // 参数 object 是url
    // 参数 configAttributes 是访问 URL 所需的权限
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if(configAttributes == null) {
            return;
        }
        
        Iterator<ConfigAttribute> ite = configAttributes.iterator();  
        
        while(ite.hasNext()){  
            ConfigAttribute ca = ite.next(); 
            // 资源(URL)所持有的角色(权限)
            String needRole = ((SecurityConfig)ca).getAttribute();  
            
            // ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。</span>
            for(GrantedAuthority ga : authentication.getAuthorities()){
                if(needRole.trim().equals(ga.getAuthority().trim())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}

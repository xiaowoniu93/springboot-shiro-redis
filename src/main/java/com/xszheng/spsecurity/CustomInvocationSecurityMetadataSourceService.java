package com.xszheng.spsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import com.xszheng.domain.D1Resource;
import com.xszheng.domain.D1Role;
import com.xszheng.mapper.D1ResourceMapper;
import com.xszheng.mapper.D1RoleMapper;

/** 
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义。 
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
	
	@Autowired
	private D1ResourceMapper resourceMapper;
	
	@Autowired
	private D1RoleMapper roleMapper;
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	@PostConstruct // 被@PostConstruct修饰的方法会在服务器加载 Servlet 的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。
    private void loadResourceDefine() {   // 一定要加上@PostConstruct注解, 在Web服务器启动时，提取系统中的所有权限。
        List<D1Role> list = roleMapper.listAll();
        List<String> roles = new ArrayList<String>();
        if(list != null && list.size() > 0) {
            for(D1Role sr : list){
                String roleNo = sr.getRoleNo();
                roles.add(roleNo);  
            }
        }
        /* 
         * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
         * sparta 
         */
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
  
        for(String roleNo : roles) {
            ConfigAttribute ca = new SecurityConfig(roleNo);
            //List<Map<String,Object>> query1 = sResourceVODao.findByRoleName(auth);
            List<String> urls = new ArrayList<String>();
            List<D1Resource>  resources = resourceMapper.listByRoleNo(roleNo);
            if(resources != null && resources.size() > 0) {
                for(D1Resource resource :resources){
                    String value = resource.getUrl();
                    urls.add(value);  
                }  
            }  
            for (String res : urls) {  
                String url = res;  
                /* 
                 * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。 
                 * sparta 
                 */ 
                if (resourceMap.containsKey(url)) {
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }  
            }  
        }  
    }
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();
	}

	// 根据URL，查询相关权限配置
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation filterInvocation = (FilterInvocation) object;  
        if (resourceMap == null) {  
            loadResourceDefine();  
        }  
        Iterator<String> ite = resourceMap.keySet().iterator();  
        while (ite.hasNext()) {  
            String resURL = ite.next();  
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);  
            if(requestMatcher.matches(filterInvocation.getHttpRequest())) {  
                return resourceMap.get(resURL);  
            }  
        }
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}

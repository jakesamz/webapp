package com.linjw.context.resolvers;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * Providing a scope for autodetected components	
 * This is exactly the same setting as default setting.
 * @author linjw
 *
 */
public class ComponentScopeResolver implements ScopeMetadataResolver {

	public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
		
		ScopeMetadata scopeMetadata = new ScopeMetadata();
		
		scopeMetadata.setScopeName(definition.getScope());
		
		scopeMetadata.setScopedProxyMode(ScopedProxyMode.NO);
		
		return scopeMetadata;
	}
	
}

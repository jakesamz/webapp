#How to get User Session from spring-security?
There are two ways.
1. 使用spring-scurity提供的方法(**Recomended**)
2. 手动从session中获取
参考<code>UserSessionService.java</code>


#Core Components
 - SecurityContextHolder, to provide access to the SecurityContext.
 - SecurityContext, to hold the Authentication and possibly request-specific security information.
 - Authentication, to represent the principal in a Spring Security-specific manner.
 - GrantedAuthority, to reflect the application-wide permissions granted to a principal.
 - UserDetails, to provide the necessary information to build an Authentication object from your application’s DAOs or other     source of security data.
 - UserDetailsService, to create a UserDetails when passed in a String-based username (or certificate ID or the like).


#How is SecurityContext(User Sessioin) stored? What filter to do this?

处理存储SecurityContext的过滤器是SecurityContextPersistenceFilter.

Depending on the type of application, there may need to be a strategy in place to store the security context between user operations. In a typical web application, a user logs in once and is subsequently identified by their session Id. The server caches the principal information for the duration session. In Spring Security, the responsibility for storing the SecurityContext between requests falls to the SecurityContextPersistenceFilter, which by default stores the context as an HttpSession attribute between HTTP requests. It restores the context to the SecurityContextHolder for each request and, crucially, clears the SecurityContextHolder when the request completes. You shouldn’t interact directly with the HttpSession for security purposes. There is simply no justification for doing so - always use the SecurityContextHolder instead.

Many other types of application (for example, a stateless RESTful web service) do not use HTTP sessions and will re-authenticate on every request. However, it is still important that the SecurityContextPersistenceFilter is included in the chain to make sure that the SecurityContextHolder is cleared after each request.
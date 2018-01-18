# Authentication mechanism

Take form-login for an example and assume that we have configuration as below.

	<http>
		<form-login/>
	</http>
	<authentication-manager>
		<authentication-provider>
			<user-service>
				...
			</user-service>
		</authentication-provider>
	</authentication-manager>

The Filter for <code>form-login</code> is <code>UsernamePasswordAuthenticationFilter </code>
(We will just call it filter in the following steps)
1. <code>UsernamePasswordAuthenticationFilter</code> is responsible for building an UsernamePasswordAuthenticationToken(Authentication).
2. And then <code>UsernamePasswordAuthenticationFilter </code> calls ProviderMangaer(AuthenticationManager) 	to authenticate user. (<code>authentication-manager</code> creates a ProviderMangaer)
3. ProviderManager delegetes the authentication to The DaoAuthenticationProvider(AuthenticationProvide(s)), 	(authentication-provider creates a DaoAuthenticationProvider)
4. In DaoAuthenticationProvider, we call authenticate();
5. Method authenticate() calls loadUserByUsername from UserService to retrieve user(Maybe from db).
	compare the retrieved user with the UsernamePasswordAuthenticationToken in step1.
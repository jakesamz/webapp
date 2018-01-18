# Authentication mechanism

Take form-login for an example and assume that we have configuration as below.
<code>
	<http>
		<form-login/><!--url should start with '/' -->
	</http>
	
	<authentication-manager>
		<authentication-provider>
			<user-service><!-- the <user-service> element creates an InMemoryDaoImpl -->
					authorities="ROLE_USER" />
			</user-service>
		</authentication-provider>
	</authentication-manager>
</code>

The Filter for <form-login/> is <code>UsernamePasswordAuthenticationFilter </code>
(We will just call it filter in the following steps)
1. <code>UsernamePasswordAuthenticationFilter</code> is responsible for building an Authentication which, in this case,
	is an <code>UsernamePasswordAuthenticationToken</code>.
2. and then <code>UsernamePasswordAuthenticationFilter </code> calls AuthenticationManager, which in this case, is a ProviderMangaer to authenticate user. (<code><authentication-manager></code> creates a ProviderMangaer)
3. ProviderManager delegetes the authentication to The AuthenticationProvides, which in this case, is DaoAuthenticationProvider (<authentication-provider> creates a DaoAuthenticationProvider)
4. Call DaoAuthenticationProvider.authenticate();
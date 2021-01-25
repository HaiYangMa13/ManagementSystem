package com.springcloudt1.managerprovider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 跨域问题解决
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer() {
			@Override
			public void configurePathMatch (PathMatchConfigurer pathMatchConfigurer) {

			}

			@Override
			public void configureContentNegotiation (ContentNegotiationConfigurer contentNegotiationConfigurer) {

			}

			@Override
			public void configureAsyncSupport (AsyncSupportConfigurer asyncSupportConfigurer) {

			}

			@Override
			public void configureDefaultServletHandling (DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

			}

			@Override
			public void addFormatters (FormatterRegistry formatterRegistry) {

			}

			@Override
			public void addInterceptors (InterceptorRegistry interceptorRegistry) {

			}

			@Override
			public void addResourceHandlers (ResourceHandlerRegistry resourceHandlerRegistry) {

			}

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").
						allowedOrigins("*"). //允许跨域的域名，可以用*表示允许任何域名使用
						allowedMethods("*"). //允许任何方法（post、get等）
						allowedHeaders("*"). //允许任何请求头
						allowCredentials(true). //带上cookie信息
						exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
			}

			@Override
			public void addViewControllers (ViewControllerRegistry viewControllerRegistry) {

			}

			@Override
			public void configureViewResolvers (ViewResolverRegistry viewResolverRegistry) {

			}

			@Override
			public void addArgumentResolvers (List<HandlerMethodArgumentResolver> list) {

			}

			@Override
			public void addReturnValueHandlers (List<HandlerMethodReturnValueHandler> list) {

			}

			@Override
			public void configureMessageConverters (List<HttpMessageConverter<?>> list) {

			}

			@Override
			public void extendMessageConverters (List<HttpMessageConverter<?>> list) {

			}

			@Override
			public void configureHandlerExceptionResolvers (List<HandlerExceptionResolver> list) {

			}

			@Override
			public void extendHandlerExceptionResolvers (List<HandlerExceptionResolver> list) {

			}

			@Override
			public Validator getValidator () {
				return null;
			}

			@Override
			public MessageCodesResolver getMessageCodesResolver () {
				return null;
			}
		};
	}

	@Override
	public void configurePathMatch (PathMatchConfigurer pathMatchConfigurer) {

	}

	@Override
	public void configureContentNegotiation (ContentNegotiationConfigurer contentNegotiationConfigurer) {

	}

	@Override
	public void configureAsyncSupport (AsyncSupportConfigurer asyncSupportConfigurer) {

	}

	@Override
	public void configureDefaultServletHandling (DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

	}

	@Override
	public void addFormatters (FormatterRegistry formatterRegistry) {

	}

	@Override
	public void addInterceptors (InterceptorRegistry interceptorRegistry) {

	}

	@Override
	public void addResourceHandlers (ResourceHandlerRegistry resourceHandlerRegistry) {

	}

	@Override
	public void addCorsMappings (CorsRegistry corsRegistry) {

	}

	@Override
	public void addViewControllers (ViewControllerRegistry viewControllerRegistry) {

	}

	@Override
	public void configureViewResolvers (ViewResolverRegistry viewResolverRegistry) {

	}

	@Override
	public void addArgumentResolvers (List<HandlerMethodArgumentResolver> list) {

	}

	@Override
	public void addReturnValueHandlers (List<HandlerMethodReturnValueHandler> list) {

	}

	@Override
	public void configureMessageConverters (List<HttpMessageConverter<?>> list) {

	}

	@Override
	public void extendMessageConverters (List<HttpMessageConverter<?>> list) {

	}

	@Override
	public void configureHandlerExceptionResolvers (List<HandlerExceptionResolver> list) {

	}

	@Override
	public void extendHandlerExceptionResolvers (List<HandlerExceptionResolver> list) {

	}

	@Override
	public Validator getValidator () {
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver () {
		return null;
	}
}
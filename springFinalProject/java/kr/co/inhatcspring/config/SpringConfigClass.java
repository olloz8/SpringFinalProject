package kr.co.inhatcspring.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{

	 /** DispatcherServlet에 매핑할 요청 주소를 셋팅한다.
	 + 모든 요청(/로 시작하는) 에 대해서 디스패처 서블릿을 매핑시키는 역할.
	 extends AbstractAnnotationConfigDispatcherServletInitializer이 아닌
	 WebApplicationInitializer를 상속받을경우 DispatcherServlet과 ServletRegistration.Dynamic
	 객체를 사용하여 사용할 dispatcher를 지정해주게 됨.  **/
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	 /** Spring MVC 프로젝트 설정을 위한 클래스를 지정한다. 
	 + 디스패처 서블릿이 사용할 설정 클래스를 지정한다.
	 + 디스패처 서블릿이 반환되는 클래스에서 MVC 프로젝트의 설정을 읽어들임. **/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	 /** 프로젝트에서 사용할 Bean들을 정의기 위한 클래스를 지정한다.
	WebApplicationInitializer를 상속받을경우 AnnotationConfigWebApplicationContext, ContextLoaderListener를 통해
	rootAppContext를 지정하여 사용 **/
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	// 파라미터 인코딩 필터 설정
	//WebApplicationInitializer를 상속받을경우 FilterRegistration.Dynamic 객체를 활용하여 인코딩 값을 지정해줌.
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
}


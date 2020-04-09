package scope.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext.xml");
		// Spring Container 생성

		InjectionBean injectionBean = 
				ctx.getBean("injectionBean", InjectionBean.class);

		// Injection Bean 가져옴
		DependencyBean dependencyBean01 = 
				ctx.getBean("dependencyBean", DependencyBean.class);
		
		DependencyBean dependencyBean02 = 
				ctx.getBean("dependencyBean", DependencyBean.class);


		// property 설정 없으면 Singleton 객체
		if(dependencyBean01.equals(dependencyBean02)) {
			System.out.println("dependencyBean01 == dependencyBean02");
		} else {
			System.out.println("dependencyBean01 != dependencyBean02");
		}
		
		
		ctx.close();
		
	}
	
}

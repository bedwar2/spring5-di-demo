package guru.springframework;

import guru.springframework.controllers.ConstructorInjectedController;
import guru.springframework.controllers.GetterInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUser());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getUrl());

		//Get non-primary bean that has @Qualifier("jmsDS") using BeanFactoryAnnotationUtils
		FakeDataSource jmsDS = (FakeDataSource) BeanFactoryAnnotationUtils.qualifiedBeanOfType(ctx, FakeDataSource.class, "jmsDS");
		System.out.println(jmsDS.getUser());
		System.out.println(jmsDS.getPassword());
		System.out.println(jmsDS.getUrl());


		/*
		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

		 */
	}
}

package com.nhnent.edu.spring_boot.config;

import com.nhnent.edu.spring_boot.component.SayNoComponent;
import com.nhnent.edu.spring_boot.component.SayYesComponent;

import java.util.Objects;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class ConditionalDemoConfig {
    static class PropertyCheckCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return Objects.nonNull(context.getEnvironment().getProperty("test1"));
        }
    }

    /*
     * PropertyCheckCondition 이 true 를 반환하면 sayYesComponent 를 생성한다.
     * a sayYesComponent bean will be created if PropertyCheckCondition is true.
     *
     */
    @Bean
    @Conditional(PropertyCheckCondition.class)
    public SayYesComponent sayYesComponent() {
        return new SayYesComponent("Conditional");
    }

    /*
     * 이 프로젝트가 web application 이면 sayYesComponentWeb 빈을 생성한다.
     * a sayYesComponentWeb bean will be created if this application is the web application.
     *
     */
    @Bean
    @ConditionalOnWebApplication
    public SayYesComponent sayYesComponentWeb() {
        return new SayYesComponent("ConditionalOnWebApplication");
    }

    /*
     * 이 프로젝트가  web application 이 아니면 sayYesComponentNotWeb 빈을 생성한다.
     * a sayYesComponentNotWeb bean will be created if this project is NOT the web application.
     *
     */
    @ConditionalOnNotWebApplication
    @Bean
    public SayYesComponent sayYesComponentNotWeb() {
        return new SayYesComponent("ConditionalOnNotWebApplication");
    }

    @Bean
    public SayNoComponent sayNoComponent() {
    	return new SayNoComponent("NO!!!!");
    }

    /*
     *  프로젝트에 SayNoComponent 타입의 빈이 등록되어 있으면 아래 빈을 생성한다.
     *  a sayYesComponentOnBean bean will be created only if there is a bean whose type is SayNoComponent.
     *
     */
    @Bean
    @ConditionalOnBean(SayNoComponent.class)
    public SayYesComponent sayYesComponentOnBean() {
        return new SayYesComponent("ConditionalOnBean");
    }

    /*
     * 프로젝트에 SayNoComponent 타입의 빈이 등록되어 있지 않으면 아래 빈을 생성합니다.
     * a sayYesComponentOnMissingBean bean will be created only if there is NOT a bean whose type is SayNoComponent.
     *
     */
    @Bean
    @ConditionalOnMissingBean(SayNoComponent.class)
    public SayYesComponent sayYesComponentOnMissingBean() {
        return new SayYesComponent("ConditionalOnMissingBean");
    }

    /*
     * 프로젝트에 Yes 라는 이름의 클래스가 존재하면 아래 빈을 생성한다.
     * a sayYesComponentOnClass bean will be created only if there is a class named Yes.
     */
    @Bean
    @ConditionalOnClass(name = "com.nhnent.edu.spring_boot.component.Yes")
    public SayYesComponent sayYesComponentOnClass() {
        return new SayYesComponent("ConditionalOnClass");
    }

    /*
     * 프로젝트에 No 라는 이름의 클래스가 존재하지 않으면 아래 빈을 생성한다.
     * a sayYesComponentOnMissingClass bean will be created only if there is NOT a class named No.
     *
     */
    @Bean
    @ConditionalOnMissingClass(value={"com.nhnent.edu.spring_boot.component.No"})
    public SayYesComponent sayYesComponentOnMissingClass() {
        return new SayYesComponent("ConditionalOnMissingClass");
    }

    /*
     * test2 라는 속성이 존재하면 아래 빈을 생성한다.
     * a sayYesComponentOnProperty bean will be created only if test2 property exists in the application.properties. 
     *
     */
    @Bean
    @ConditionalOnProperty(value="test2")
    public SayYesComponent sayYesComponentOnProperty() {
        return new SayYesComponent("ConditionalOnProperty");
    }

    /*
     * test.txt 파일이 존재하면 아래 빈을 생성한다.
     * a sayYesComponentOnResource bean will be created only if the test.txt file exists in the class path.
     *
     */
    @Bean
    @ConditionalOnResource(resources = { "classpath:/test.txt" })
    public SayYesComponent sayYesComponentOnResource() {
        return new SayYesComponent("ConditionalOnResource");
    }

}

package com.nhnent.edu.spring_boot.config;

import com.nhnent.edu.spring_boot.component.SayNoComponent;
import com.nhnent.edu.spring_boot.component.SayYesComponent;
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
            // TODO : #1 application.properties 파일에 test1 속성이 존재하면 true, 아니면 false를 반환하도록 수정하세요.
            //        cf.) context.getEnvironment().getProperty("test1")
            return false;
        }
    }

    /*
     * PropertyCheckCondition 이 true 를 반환하면 sayYesComponent 를 생성한다.
     *
     */
    @Bean
    @Conditional(PropertyCheckCondition.class)
    public SayYesComponent sayYesComponent() {
        return new SayYesComponent("Conditional");
    }

    // TODO : #2 이 프로젝트가 web application 이 되도록 pom.xml의 의존성을 수정하세요.
    /*
     * 이 프로젝트가 web application 이면 sayYesComponentWeb 빈을 생성한다.
     *
     */
    @Bean
    @ConditionalOnWebApplication
    public SayYesComponent sayYesComponentWeb() {
        return new SayYesComponent("ConditionalOnWebApplication");
    }

    /*
     * 이 프로젝트가  web application 이 아니면 sayYesComponentNotWeb 빈을 생성한다.
     *
     */
    @ConditionalOnNotWebApplication
    @Bean
    public SayYesComponent sayYesComponentNotWeb() {
        return new SayYesComponent("ConditionalOnNotWebApplication");
    }

    // TODO : #3 sayYesComponentOnBean 빈이 생성되도록 SayNoComponent 빈을 선언해 주세요.
    /*
     * ???
     */


    /*
     *  프로젝트에 SayNoComponent 타입의 빈이 등록되어 있으면 아래 빈을 생성한다.
     *
     */
    @Bean
    @ConditionalOnBean(SayNoComponent.class)
    public SayYesComponent sayYesComponentOnBean() {
        return new SayYesComponent("ConditionalOnBean");
    }

    /*
     * 프로젝트에 SayNoComponent 타입의 빈이 등록되어 있지 않으면 아래 빈을 생성합니다.
     *
     */
    @Bean
    @ConditionalOnMissingBean(SayNoComponent.class)
    public SayYesComponent sayYesComponentOnMissingBean() {
        return new SayYesComponent("ConditionalOnMissingBean");
    }

    // TODO : #4 sayYesComponentOnClass 빈이 생성되도록 No 클래스의 이름을 수정하세요.
    /*
     * 프로젝트에 Yes 라는 이름의 클래스가 존재하면 아래 빈을 생성한다.
     */
    @Bean
    @ConditionalOnClass(name = "com.nhnent.edu.spring_boot.component.Yes")
    public SayYesComponent sayYesComponentOnClass() {
        return new SayYesComponent("ConditionalOnClass");
    }

    /*
     * 프로젝트에 No 라는 이름의 클래스가 존재하지 않으면 아래 빈을 생성한다.
     *
     */
    @Bean
    @ConditionalOnMissingClass(value={"com.nhnent.edu.spring_boot.component.No"})
    public SayYesComponent sayYesComponentOnMissingClass() {
        return new SayYesComponent("ConditionalOnMissingClass");
    }

    // TODO : #5 sayYesComponentOnProperty 빈이 생성되도록 application.properties 파일을 수정하세요.
    /*
     * test2 라는 속성이 존재하면 아래 빈을 생성한다.
     *
     */
    @Bean
    @ConditionalOnProperty(value="test2")
    public SayYesComponent sayYesComponentOnProperty() {
        return new SayYesComponent("ConditionalOnProperty");
    }

    // TODO : #6 sayYesComponentOnResource 빈이 생성되도록 src/main/resources 디렉토리에 test.txt 파일을 생성하세요.
    /*
     * test.txt 파일이 존재하면 아래 빈을 생성한다.
     *
     */
    @Bean
    @ConditionalOnResource(resources = { "classpath:/test.txt" })
    public SayYesComponent sayYesComponentOnResource() {
        return new SayYesComponent("ConditionalOnResource");
    }

}

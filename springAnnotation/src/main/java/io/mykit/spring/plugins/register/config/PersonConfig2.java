/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mykit.spring.plugins.register.config;

import io.mykit.spring.plugins.register.bean.Department;
import io.mykit.spring.plugins.register.bean.Employee;
import io.mykit.spring.plugins.register.bean.Person;
import io.mykit.spring.plugins.register.bean.PersonFactoryBean;
import io.mykit.spring.plugins.register.condition.LinuxCondition;
import io.mykit.spring.plugins.register.condition.MyImportBeanDefinitionRegistrar;
import io.mykit.spring.plugins.register.condition.WindowsCondition;
import io.mykit.spring.plugins.register.selector.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试@Scope注解设置的作用域
 */
@Configuration
@Import({Department.class, Employee.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class PersonConfig2 {

    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person....");
        return new Person("binghe002", 18, "");
    }

    @Conditional({WindowsCondition.class})
    @Bean("binghe001")
    public Person person01() {
        return new Person("binghe001", 18, "");
    }

    @Conditional({LinuxCondition.class})
    @Bean("binghe002")
    public Person person02() {
        return new Person("binghe002", 20, "");
    }


    @Bean
    public PersonFactoryBean personFactoryBean() {
        return new PersonFactoryBean();
    }
}

package com.nhnent.edu.spring_boot.repository;

import com.nhnent.edu.spring_boot.entity.Item;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Optional;

@RunWith(SpringRunner.class)
// TODO : #1 using @SpringBootTest
@SpringBootTest
// TODO : #2 using @DataJpaTest
//@DataJpaTest
// TODO : #3 using @DataJpaTest w/ @AutoConfigureTestDatabase + @TestConfiguration
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;


//    @TestConfiguration
//    static class ItemRepositoryTestContextConfiguration {
//        @Bean
//        public DataSource dataSource() {
//            BasicDataSource dataSource = new BasicDataSource();
//            dataSource.setDriverClassName("org.h2.Driver");
//            dataSource.setUrl("jdbc:h2:~/spring-boot;DATABASE_TO_UPPER=false;INIT=RUNSCRIPT FROM 'classpath:/script/schema.sql'");
//            dataSource.setUsername("sa");
//            dataSource.setPassword("");
//
//            return dataSource;
//        }
//    }


    @Test
    public void test() throws Exception {
        Optional<Item> optionalItem = itemRepository.findById(1L);
        Assert.assertTrue(optionalItem.isPresent());

        Item item = optionalItem.get();
        Assert.assertEquals("apple", item.getItemName());
    }

}

package com.rozplochowski.beans;

import com.rozplochowski.beans.service.NumberService;
import com.rozplochowski.beans.service.StringService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;

public class BeansApplication {

     static void main(String[] args) throws IOException {

         try (var ctx = new AnnotationConfigApplicationContext(SequenceConfiguration.class)) {
             var sequenceBeanByClass = ctx.getBean(Sequence.class);
             var sequenceBeanByName = (Sequence) ctx.getBean("sequence");
             var sequenceBeanByName2 = ctx.getBean("sequence", Sequence.class);

             IO.println(sequenceBeanByClass.next());
             IO.println(sequenceBeanByName.next());
             IO.println(sequenceBeanByName2.next());

             var sequenceRepository = ctx.getBean(SequenceRepository.class);
             IO.println(sequenceRepository.next());

             var meaningOfLife = ctx.getBean("meaningOfLife", Integer.class);
             var luckyNumber = ctx.getBean("luckyNumber", Double.class);

             IO.println("Meaning of life is " + meaningOfLife);
             IO.println("Lucky number is " + luckyNumber);

             var numberService = ctx.getBean(NumberService.class);
             numberService.printNumbers();
             numberService.printNumbersIndex();

             ctx.getBean(StringService.class).introduce();

             var randomNumber = ctx.getBean(Long.class);
             var randomNumber2 = ctx.getBean(Long.class);
             var randomNumber3 = ctx.getBean(Long.class);

             IO.println("Prototype Beans: %d, %d, %d ".formatted(
                     randomNumber, randomNumber2, randomNumber3
             ));

             var resource = new ClassPathResource("aboutme.properties");
             var props = PropertiesLoaderUtils.loadProperties(resource);
             IO.println("Good bye " + props.getProperty("user.firstname"));
         }
    }

}

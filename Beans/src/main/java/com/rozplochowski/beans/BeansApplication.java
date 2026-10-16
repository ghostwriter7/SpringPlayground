package com.rozplochowski.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeansApplication {

     static void main(String[] args) {

         try (var ctx = new AnnotationConfigApplicationContext(SequenceConfiguration.class)) {
             var sequenceBeanByClass = ctx.getBean(Sequence.class);
             var sequenceBeanByName = (Sequence) ctx.getBean("sequence");
             var sequenceBeanByName2 = ctx.getBean("sequence", Sequence.class);

             IO.println(sequenceBeanByClass.next());
             IO.println(sequenceBeanByName.next());
             IO.println(sequenceBeanByName2.next());

             var sequenceRepository = ctx.getBean(SequenceRepository.class);
             IO.println(sequenceRepository.next());
         }
    }

}

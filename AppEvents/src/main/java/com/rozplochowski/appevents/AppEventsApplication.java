package com.rozplochowski.appevents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppEventsApplication {

     static void main(String[] args) {
         try (var ctx = new AnnotationConfigApplicationContext()) {
             ctx.register(Config.class);
             ctx.refresh();

             var userSrv = ctx.getBean(UserService.class);

             userSrv.logUserAction("Log in");
             userSrv.logUserAction("Password change");
             userSrv.logUserAction("Log out");

             userSrv.logUserActionWithCustomEvent("Custom event");

             ctx.pause();

             ctx.restart();
         }

    }

}

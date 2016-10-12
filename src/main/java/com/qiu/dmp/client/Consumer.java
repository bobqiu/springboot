package com.qiu.dmp.client;

/**
 * Created by Administrator on 2016/8/15.
 */
public class Consumer {
   /* public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        UserService userService = (UserService) context.getBean("userService");

        String s = "hello "+userService.registerUser("web1111");

        System.out.println("************************" + s);

       *//* User user = new User();
        user.setName("labbry");

        Client client = ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8088/users/register");
        Response response = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("The generated id is " + response.readEntity(User.class).getName());
        } finally {
            response.close();
            client.close(); // 在真正开发中不要每次关闭client，比如HTTP长连接是由client持有的
        }*//*
    }*/

}

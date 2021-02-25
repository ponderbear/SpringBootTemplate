package com.example.test;

import com.example.entity.Order;
import com.example.entity.People;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import java.lang.reflect.*;

public class ReflectionTest {

    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        reflect();
    }


    public static void reflect() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        /**
         *  1、访问class类型，并反射创建对象
         */
        Class cls1 = String.class;
        String s = "hello";
        Class cls2 = s.getClass();
        Class cls3 = Class.forName("java.lang.String");

        //  instanceof 子类也可判断为true
        System.out.println("判断两种获取class的关系："+ (cls2 == cls3));
        //根据类创建对象，只有具有public无参构造方法的类才可以用newInstance
        String instanceString = (String)cls1.newInstance();

        System.out.println("-----------------------------------------------------------------");


        /**
         * 3、访问字段
         */
        People people = new People("wang","23");
        Class p = people.getClass();
        //获取public（可包括父类）的field
        //Field f2 = p.getField("age");
        //获取某个field
        Field f = p.getDeclaredField("name");
        //获取所有的field
        Field[] publicFields = p.getFields();
        Field[] fields = p.getDeclaredFields();

        String fieldName = f.getName();
        //该字段中，java某个字段类型（String.class）
        Class fieldType = f.getType();
        int fieldModifierCode = f.getModifiers();
        System.out.println("判断该字段是否是public："+Modifier.isPublic(fieldModifierCode));
        //通过字段获取一个对象中对应字段的值(如果是private，则不能取出值)
        //则可以通过设置access来打破权限（用于某些框架的底层调用实现）
        f.setAccessible(true);
        String privateName = (String)f.get(people);
        System.out.println("通过打破权限来访问private的值："+privateName);
        f.set(people,"john");
        System.out.println("通过打破权限来设置原来对象中private中的字段："+people.getName());

        System.out.println("-----------------------------------------------------------------");


        /**
         * 4、访问方法
         */

        Method pMethod = p.getMethod("getName");
        Method[] methods = p.getDeclaredMethods();
        System.out.println("获取方法名:"+ pMethod.getName());
        System.out.println("获取返回值类型名:"+ pMethod.getReturnType().getName());

        p.getMethod("setAge", String.class);

        //如果传入的是继承的子类，那么该重写的方法，会按照子类
        String mockStringObjcet = new String("hhh");
        //通过类A获取由其封装方法B，然后直接启动B，传入需要被动的类，并传参
        Method subStringMethod = String.class.getMethod("substring", int.class);
        String outPutString = (String)subStringMethod.invoke(mockStringObjcet,2);
        System.out.println("通过反射启动类中的方法，且是传入制定的对象和参数:"+ outPutString);

        System.out.println("-----------------------------------------------------------------");


        /**
         * 5、获取类
         */

        Class subClass = Integer.class;
        Class superClass = subClass.getSuperclass();
        System.out.println("获取父类名称："+superClass.getName());

        Class instanceClass = Integer.class;
        Class[] instanceInterfaces = instanceClass.getInterfaces();
        for(Class i : instanceInterfaces){
            System.out.println("获取实现的接口："+  i.getName());
        }

        System.out.println("-----------------------------------------------------------------");

        //5.1创建一个接口实现类（目标类）
        Object tar = new UserServiceImpl();

        //5.2 动态创建一个目标类的代理类（该代理类本需要实现接口）
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(
                tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("进入到动态代理类的方法调用中");
                        method.invoke(tar,args);
                        System.out.println("动态代理类的方法已经调用完毕");
                        return null;
                    }
                });
//        userService.getUser(233);
        userServiceProxy.getUserRelectTest();



    }
}

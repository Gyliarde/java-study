package gyliarde.reflection;


import gyliarde.reflection.model.Person;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * https://www.oracle.com/technical-resources/articles/java/javareflection.html
 */
public class OracleReflectionTest {

    /**
     * Simulating the instanceof Operator
     */

    @Test
    public void simulateInstanceOf() {
        {
            try {
                Class cls = Class.forName("gyliarde.reflection.model.Person");
                boolean b1 = cls.isInstance(new Integer(37));
                System.out.println(b1);
                boolean b2 = cls.isInstance(new Person());
                System.out.println(b2);
            }
            catch (Throwable e) {
                System.err.println(e);
            }
        }
    }

    /**
     * Finding Out About Methods of a Class
     */

    @Test
    public void showMethodOfClass() {
            try {
                Class cls = Class.forName("gyliarde.reflection.model.Person");

                Method methlist[]  = cls.getDeclaredMethods();
                for (int i = 0; i < methlist.length;
                     i++) {
                    Method m = methlist[i];
                    System.out.println("name = " + m.getName());
                    System.out.println("decl class = " + m.getDeclaringClass());
                    Class pvec[] = m.getParameterTypes();

                    for (int j = 0; j < pvec.length; j++)
                        System.out.println(" param #" + j + " " + pvec[j]);

                    Class evec[] = m.getExceptionTypes();

                    for (int j = 0; j < evec.length; j++)
                        System.out.println("exc #" + j + " " + evec[j]);

                    System.out.println("return type = " + m.getReturnType());
                    System.out.println("-----");
                }
            }
            catch (Throwable e) {
                System.err.println(e);
            }
    }

    /**
     * Obtaining Information About Constructors
     */

    @Test
    public void shouldConstructorsInfoByReflection() {
        try {
            Class cls = Class.forName("gyliarde.reflection.model.Person");

            Constructor ctorlist[] = cls.getDeclaredConstructors();

            for (int i = 0; i < ctorlist.length; i++) {
                Constructor ct = ctorlist[i];
                System.out.println("name = " + ct.getName());
                System.out.println("decl class = " + ct.getDeclaringClass());
                Class pvec[] = ct.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("param #" + j + " " + pvec[j]);
                Class evec[] = ct.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);
                System.out.println("-----");
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }

    /**
     * Finding Out About Class Fields
     */

    @Test
    public void shouldShowClassFieldInfo() {
        try {
            Class cls = Class.forName("gyliarde.reflection.model.Person");

            Field fieldlist[] = cls.getDeclaredFields();
            for (int i = 0; i < fieldlist.length; i++) {
                Field fld = fieldlist[i];
                System.out.println("name = " + fld.getName());
                System.out.println("decl class = " + fld.getDeclaringClass());
                System.out.println("type = " + fld.getType());
                int mod = fld.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(mod));
                System.out.println("-----");
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }

    /**
     * Invoking Methods by Name
     */

    @Test
    public void shouldInvokingMethodByName() {
        try {
            Class cls = Class.forName("gyliarde.reflection.model.Person");
            Class partypes[] = new Class[1];
            partypes[0] = Integer.TYPE;
            Method meth = cls.getMethod("setAge", partypes);
            Person methobj = new Person();
            Object arglist[] = new Object[1];
            arglist[0] = new Integer(37);
            Object retobj = meth.invoke(methobj, arglist);
            Integer retval = (Integer)retobj;
            System.out.println(retval.intValue());
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }


    /**
     * Changing Values of Fields
     */

    @Test
    public void shouldChangeValueOfFields(){
        try {
            Class cls = Class.forName("gyliarde.reflection.model.Person");
            Field fld = cls.getField("age");
            Person person = new Person();
            System.out.println("age = " + person.getAge());
            fld.setInt(person, 33);
            System.out.println("age = " + person.getAge());
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }

    /**
     * Using Arrays
     */

    @Test
    public void shouldUseArraysWithReflection() {
        try {
            Class cls = Class.forName("java.lang.String");
            Object arr = Array.newInstance(cls, 10);
            Array.set(arr, 5, "this is a test");
            String s = (String)Array.get(arr, 5);
            System.out.println(s);
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }


}

package sizeof;

/**
 * Created by liuhui-ds9 on 2018/7/25.
 */
import java.lang.instrument.Instrumentation;

public class ObjectShallowSize {
    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation instP){
        inst = instP;
        Class[] clazzes = inst.getAllLoadedClasses();
        for(Class clazz : clazzes){
            System.out.println(clazz.getName() + ":" +sizeOf(clazz));
        }
    }

    public static long sizeOf(Object obj){
        return inst.getObjectSize(obj);
    }
}
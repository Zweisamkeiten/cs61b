package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    /*
     * Integer a == Integer b, 对象的比较为引用的比较. 又因为 autoboxing 机制 int 传入函数参数时自动创建
     * Integer 对象, 引用不相等, 所有比较不通过
     */
    @Test
    public void testFlikTest1() { // fail
        int a = 500;
        int b = 501;
        int c = 500;

        assertEquals(false, Flik.isSameNumber(a, b));
        assertEquals(true, Flik.isSameNumber(a, a));
        assertEquals(true, Flik.isSameNumber(a, c));
    }

    /*
     * -128 到 127 的范围是来自于 Java 的 Integer 类的设计, 是 Java 标准库的一个实现细节. Java 的 Integer
     * 类中定义了一个称为 IntegerCache 的内部静态缓存, 它会缓存 -128 到 127 范围内的 Integer 对象.
     */
    @Test
    public void testFlikTest2() { // pass
        int a = 100;
        int b = 101;
        int c = 100;

        assertEquals(false, Flik.isSameNumber(a, b));
        assertEquals(true, Flik.isSameNumber(a, a));
        assertEquals(true, Flik.isSameNumber(a, c));
    }

}

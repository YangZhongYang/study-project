package cn.codeyang;

import cn.codeyang.mockito.utils.IsValid;
import cn.codeyang.mockito.utils.UserProvider;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by meicai on 2016/1/18
 */
public class MockitoTest {


    /**
     * Let's verify some behaviour!
     * 验证行为
     */
    @Test
    public void test01(){
        //创建一个mock
        List mockedList = mock(List.class);

        //使用mock对象
        mockedList.add("one");
        mockedList.clear();

        //验证
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * How about some stubbing?
     * 返回期望值
     */
    @Test(expected = RuntimeException.class)
    public void test02(){
        LinkedList mockedList = mock(LinkedList.class);

        //设置期望值
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        assertEquals("first", mockedList.get(0));
        mockedList.get(1);
    }


    /**
     * Argument matchers
     * 参数匹配
     */
    @Test
    public void test03(){
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(anyInt())).thenReturn("element");
        when(mockedList.contains(argThat(new IsValid()))).thenReturn(false);

        assertEquals("element", mockedList.get(999));
        verify(mockedList).get(anyInt());

        //此处处所
        verify(mockedList).set(1, anyString());
    }

    /**
     * Note: 使用参数匹配容易出错的地方
     */
    @Test
    public void test03_1(){
        Comparator comparator = mock(Comparator.class);
        comparator.compare("nihao", "hello");

        verify(comparator).compare(anyString(), eq("hello"));
        verify(comparator).compare("nihao", "hello");
    }

    /**
     * Verifying exact number of invocations / at least x / never
     * 验证调用的具体次数/最少次数/从未调用
     */
    @Test
    public void test04(){
        LinkedList mockedList = mock(LinkedList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //使用 never()验证从未调用过得
        verify(mockedList, never()).add("never happend");

        //至少掉用过一次
        verify(mockedList, atLeastOnce()).add("three times");
        //至少两次
        verify(mockedList, atLeast(2)).add("twice");
        //至多3次
        verify(mockedList, atMost(3)).add("three time");
    }

    /**
     * Stubbing void methods with exceptions
     * 设置void方法的返回值为抛异常
     */
    @Test(expected = RuntimeException.class)
    public void test05(){
        LinkedList mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        mockedList.clear();
    }

    /**
     * Verification in order
     * 验证调用顺序
     */
    @Test
    public void test06(){
        List singleMock = mock(List.class);

        singleMock.add("was added first");
        singleMock.add("was added second");

        //验证单个对象的调用顺序
        InOrder inOrder = inOrder(singleMock);
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        //验证多个对象的调用顺序
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("was called first");
        firstMock.add("was called second");

        InOrder inOrder2 = inOrder(firstMock, secondMock);
        inOrder2.verify(firstMock).add("was called first");
        inOrder2.verify(firstMock).add("was called second");
    }

    /**
     * Making sure interaction(s) never happened on mock
     * 确保Mock对象从未调用过
     */
    @Test
    public void test07(){
        LinkedList mockedList = mock(LinkedList.class);
        LinkedList mockedTwo = mock(LinkedList.class);
        LinkedList mockedThree = mock(LinkedList.class);

        mockedList.add("one");

        verify(mockedList).add("one");

        verify(mockedList, never()).add("two");

        //验证未被的调用过的对象
        verifyZeroInteractions(mockedTwo, mockedThree);
    }

    /**
     * Finding redundant invocations
     * 寻找冗余的调用
     */
    @Test
    public void test08(){
        LinkedList mockedList = mock(LinkedList.class);

        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");
        verify(mockedList).add("two");

        verifyNoMoreInteractions(mockedList);
    }

    /**
     * Shorthand for mocks creation - @Mock annotation
     * 使用注解@Mock快速创建mock对象
     */
    @Test
    public void test09(){
        //TODO
    }

    /**
     * Stubbing consecutive calls (iterator-style stubbing)
     * 迭代调用
     */
    @Test
    public void test10(){
        LinkedList mockedList = mock(LinkedList.class);

//        when(mockedList.get(1)).thenReturn("one", "two", "three");
        when(mockedList.get(1)).thenReturn("one").thenReturn("two").thenReturn("three");

        assertEquals("one", mockedList.get(1));
        assertEquals("two", mockedList.get(1));
        assertEquals("three", mockedList.get(1));
    }

    /**
     * Stubbing with callbacks
     * 回调函数作为期望值
     */
    @Test
    public void test11(){
        LinkedList mockedList = mock(LinkedList.class);
        
        when(mockedList.get(0)).thenAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                Object mock  = invocation.getMock();
                return "called with arguments: " + args.length;
            }
        });

        System.out.println(mockedList.get(0));
    }

    /**
     * doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() family of methods
     * void方法常用的stubbing
     */
    @Test(expected = RuntimeException.class)
    public void test12(){
        LinkedList mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        //此处会抛出异常
        mockedList.clear();
    }

    /**
     * Spying on real objects
     * 监控一个真实对象
     */
    @Test
    public void test13(){
        List list = new LinkedList();
        List spy = spy(list);
        LinkedList mockedList = mock(LinkedList.class);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");
        mockedList.add("one");

        assertEquals("one", spy.get(0));
        //此处会报错
//        assertEquals("one", mockedList.get(0));
        assertEquals(100, spy.size());

        verify(spy).add("one");
        verify(spy).add("two");

    }
}

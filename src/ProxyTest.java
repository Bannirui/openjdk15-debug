import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dingrui
 * @since 2023/1/31
 */
public class ProxyTest {

    interface IHello {
        void sayHi();
    }

    static class Hello implements IHello {

        @Override
        public void sayHi() {
            System.out.println("Hello::sayHi...");
        }
    }

    static class MyProxy implements InvocationHandler {

        private Object delegate;

        // 创建代理对象
        public Object bind(Object delegate) {
            this.delegate = delegate;
            return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("MyProxy::enhance...");
            return method.invoke(this.delegate, args);
        }
    }

    public static void main(String[] args) {
        IHello proxy = (IHello) new MyProxy().bind(new Hello());
        proxy.sayHi();
    }
}

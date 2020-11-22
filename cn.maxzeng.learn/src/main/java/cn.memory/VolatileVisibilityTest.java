package cn.memory;

/**
 * @ClassName VolatileVisibilityTest
 * @Description TODO
 * @Author max.zeng
 * @Date 2020/11/22 16:29
 */
public class VolatileVisibilityTest
{
    public static volatile boolean initFlag = false; // volatile

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("waiting data...");
            while (!initFlag) {

            }
            System.out.println("=============success");
        }).start();

        Thread.sleep(2000);

        new Thread(() -> prepareData()).start();
    }

    public static void prepareData() {
        System.out.println("prepare data ...");
        initFlag = true;
        System.out.println("prepare data end ...");
    }
}
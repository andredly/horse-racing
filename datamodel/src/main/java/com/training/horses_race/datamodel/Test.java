package racers.entity.user;

public class Test {
    public Test() {
        System.out.println("Привет");
    }

    public static void main(String[] args) {

        while (true) {
//            Runtime.getRuntime().gc();
            System.gc();
            new Test();

        }

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Меня вызвали!");
        super.finalize();
    }
}

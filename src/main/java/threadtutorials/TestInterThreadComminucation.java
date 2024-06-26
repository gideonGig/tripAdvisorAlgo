package threadtutorials;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** still learning intyer thread communication */
public class TestInterThreadComminucation {
    public final Lock lock = new ReentrantLock();
    public final Condition lockCondition = lock.newCondition();
    public String userName;
    public String password;
    public boolean isAuthenticated = false;
    private final TestCache cache;

    public TestInterThreadComminucation(TestCache cache) {
        this.cache = cache;
    }

    public void checkAuthentication(String inputUserName, String inputPassword) throws InterruptedException {
        lock.lock();
        try {
            while ((inputUserName.equalsIgnoreCase(userName) && inputPassword.equalsIgnoreCase(password)) == false) {
                        lockCondition.await();
            }
            
            isAuthenticated = true;
            System.out.println("valid user name and password");
            
        } finally {
            lock.unlock();
        }
    }

    public void setAuthentication() throws InterruptedException {
        lock.lock();
        try {
            Scanner scanner = new Scanner(System.in);
            while (isAuthenticated == false) {
                System.out.println("Enter User name");
                userName = scanner.nextLine();

                System.out.println("Enter password");
                password = scanner.nextLine();
                
                lockCondition.signal(); 
                Thread.sleep(1000);
            }
        } finally {
            lock.unlock();
        }

    }

    public static class TestCache {
        private String name;
        private String password;

        public TestCache(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }

    public static class TestUI extends Thread {
        private TestInterThreadComminucation testInterThreadComminucation;

        public TestUI(TestInterThreadComminucation testInterThreadComminucation) {
            this.testInterThreadComminucation = testInterThreadComminucation;
        }

        public void run() {
          try {
            testInterThreadComminucation.checkAuthentication("gideon", "Gidizi");
        } catch (InterruptedException e) {
          
            e.printStackTrace();
        }
        }
    }

    public static class TestBackGround extends Thread {
        private TestInterThreadComminucation testInterThreadComminucation;

        public TestBackGround(TestInterThreadComminucation testInterThreadComminucation) {
            this.testInterThreadComminucation = testInterThreadComminucation;
        }
         public void run() {
            try {
                testInterThreadComminucation.setAuthentication();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         }
    }

    public static void main(String[] args) {
        TestCache testCache = new TestCache("gideon", "Gidiziz");
        TestInterThreadComminucation testInterThreadComminucation = new TestInterThreadComminucation(testCache);


        TestUI testUI = new TestUI(testInterThreadComminucation);

        TestBackGround testBackGround = new TestBackGround(testInterThreadComminucation);

        
        testUI.setName("UI-Thread");
        testUI.start();


        testBackGround.setName("BackGround-Thread");
        testBackGround.start();

    }
}

package jvmPerformance;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HeadTest {

    private byte[] a=new byte[1024*100]; //100kb

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeadTest> heapTests=new ArrayList<HeadTest>();
        while(true){
            heapTests.add((new HeadTest()));
            TimeUnit.NANOSECONDS.sleep(200);
        }

    }
}

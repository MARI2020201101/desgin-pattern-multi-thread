package ch12.activeobject;

import java.util.Arrays;

class Servant implements ActiveObject{
    @Override
    public Result makeString(int count, char c) {
        char[] buff = new char[count];
        for (int i = 0; i < count; i++) {
            buff[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        RealResult result = new RealResult(Arrays.toString(buff));
        return result;
    }

    @Override
    public void displayString(String str) {
        System.out.println("Display String : "+ str);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {}
    }
}

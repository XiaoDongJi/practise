package com.cckeep.jdk.thread.semaphore;


import java.util.concurrent.Semaphore;

public class Print extends Thread {
    private String ch;
    private Semaphore cur;
    private Semaphore next;

    public Print(String ch,Semaphore cur,Semaphore next){
        this.ch = ch;
        this.cur = cur;
        this.next = next;
    }

    @Override
    public void run() {
        try {
            for(int i = 0;i < 10;i++){
                cur.acquire();
                System.out.print(ch);
                next.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        Print A = new Print("A",semaphoreA,semaphoreB);
        Print B = new Print("B",semaphoreB,semaphoreC);
        Print C = new Print("C",semaphoreC,semaphoreA);

        A.start();
        B.start();;
        C.start();
    }



}

package com.test.java.chap02;

/**
 * Created by zhangxin on 15-5-29.
 */
public class First {
    private String context;
    private PrivateInnerClass privateInnerInstance;

    public First() {
        context = "default";
        privateInnerInstance = new PrivateInnerClass();
        privateInnerInstance.setInnnerName("inner default name");
    }

    public First(String context) {
        this.context = context;
        privateInnerInstance = new PrivateInnerClass();
        privateInnerInstance.setInnnerName("inner " + context + " name");
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public PrivateInnerClass getPrivateInnerInstance() {
        return privateInnerInstance;
    }

    public void setPrivateInnerInstance(PrivateInnerClass privateInnerInstance) {
        this.privateInnerInstance = privateInnerInstance;
    }

    public void showPrivateInnerName() {
        System.out.println(privateInnerInstance.getInnnerName());
    }

    public class InnerClass {
        public void showContext() {
            System.out.println(context);
        }
    }

    private class PrivateInnerClass {
        private String innnerName;

        public String getInnnerName() {
            return innnerName;
        }

        public void setInnnerName(String innnerName) {
            this.innnerName = innnerName;
        }
    }

    public static void main(String[] args) {
        First ff = new First("First");
        First ff1 = new First("hahahahaha");
        First.InnerClass ii = ff.new InnerClass();
        ii.showContext();
        First.InnerClass ii1 = ff1.new InnerClass();
        ii1.showContext();
        System.out.println("------------------------");
        First ff2 = new First("world");
        ff2.showPrivateInnerName();
    }
}

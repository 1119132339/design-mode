package com.design.mode.proxy.dynamic;

public class StaticProxy {

    private Animal animal;
    public StaticProxy(Animal animal){
        this.animal = animal;
    }
    public void dosomething(){
        System.out.println("静态代理");
        animal.dosomething();
    }

}

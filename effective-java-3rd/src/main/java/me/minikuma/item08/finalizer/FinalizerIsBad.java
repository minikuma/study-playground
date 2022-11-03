package me.minikuma.item08.finalizer;

public class FinalizerIsBad {
    @Override
    protected void finalize() {
        System.out.println("");
    }
}

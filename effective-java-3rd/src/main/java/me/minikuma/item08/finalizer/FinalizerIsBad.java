package me.minikuma.item08.finalizer;

public class FinalizersBad {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("");
    }
}

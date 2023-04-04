package me.minikuma.item03.eunmtype;

public enum Elvis {
    INSTANCE;

    public void leaveToBuilding() {
        System.out.println("나갈께~");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveToBuilding();
    }
}

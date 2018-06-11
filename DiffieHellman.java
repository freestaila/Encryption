public class DiffieHellman{
    private long openP;
    private long openG;
    private long  secretA;
    private long secretB;
    private long openA;
    private long openB;
    private long secretS;

    public DiffieHellman(long openP,long openG, long secretA, long secretB){
        this.openP= openP;
        this.openG=openG;
        this.secretA= secretA;
        this.secretB= secretB;
        publicznyA();
        publicznyB();
        tajnyS();
    }
    public long getLong(long openP,long openG, long secretA, long secretB){
        this.openP=openP;
        this.openG=openG;
        this.secretA=secretA;
        this.secretB=secretB;
        return openP;
    }
    public void publicznyA(){
        openA=(long) Math.pow(openG,secretA)%openP;
    }
    public void publicznyB(){
        openB=(long) Math.pow(openG,secretB)%openP;
    }
    public void tajnyS(){
        //wyswietlanie sekretnego klucza A
        secretS=(long) Math.pow(openB,secretA)%openP;
        System.out.println("Sekret A=" + secretS);
        //wyswietlanie sekretnego klucza B
        secretS=(long) Math.pow(secretA,openB)%openP;
        System.out.println("Sekret B=" + secretS);
    }
}
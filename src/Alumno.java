import java.util.Random;

public class Alumno extends Thread{

    //Callback
    Profesor callback;

    public Alumno(Profesor callback){
        this.callback = callback;
    }


    @Override
    public void run() {
        try {
            // hacemos un random para tener un numero aleatorio de llegada
            Random random = new Random();
            int pausa = random.nextInt(4000);
            sleep(pausa);
            System.out.println("El "+getName()+" ha llegado");
            System.out.println("Puedo comenzar cuando quiera el profesor");
            callback.notificaComienzo(this);
            callback.notificaFinal(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

import java.util.Random;

import static java.lang.Thread.sleep;

public class EmpiezaExamen {

    public synchronized void aviso(){
        notifyAll();
    }
    public synchronized void notificacionComienzo(Alumno alumno) throws InterruptedException {
        // este wait viene despues de notificar que el examen ha comenzado
        wait();
        // ponemos un tiempo minimo que es lo que tarda el profesor en dar el examen
        Random random = new Random();
        sleep(random.nextInt(2000));
        System.out.println("El "+alumno.getName()+" ha recibido el examen");
    }

    public synchronized void notificacionFinal(Alumno alumno) throws InterruptedException {
        // este wait viene despues de notificar el final del examen
        wait();
        sleep(2000);
        // hacemos un random a la hora de entregar el examen
        Random random = new Random();

        // vamos a crear un metodo para que evalue aprobados y suspensos
        // en este caso es booleano
        boolean apruebaoSuspende = random.nextBoolean();
        if(apruebaoSuspende == true){
            System.out.println("El "+alumno.getName()+" me da su examen y su nota: APROBADO");
        }else{
            System.out.println("El "+alumno.getName()+" me da su examen y su nota: SUSPENSO");
        }
    }


}

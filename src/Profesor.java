public class Profesor extends Thread{

    // esta clase es la que va a sincronizar todo
    EmpiezaExamen comienzaExamen = new EmpiezaExamen();


    @Override
    public void run() {
        try {
            sleep(10000);
            System.out.println("------------------El profesor avisa del comienzo del examen---------------");
            // en este paso tenemos que notificar a los alumnos el comienzo del examen
            comienzaExamen.aviso();
            sleep(15000);
            System.out.println("------------------El profesor avisa que el examen a finalizado---------------");
            comienzaExamen.aviso();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // esta clase se ha de crear en EmpiezaExamen, para que syncronize todo
    public void notificaComienzo(Alumno alumno) throws InterruptedException{
        comienzaExamen.notificacionComienzo(alumno);
    }

    // esta clase se ha de crear en EmpiezaExamen, para que syncronize todo
    public void notificaFinal(Alumno alumno) throws InterruptedException{
        comienzaExamen.notificacionFinal(alumno);
    }

}

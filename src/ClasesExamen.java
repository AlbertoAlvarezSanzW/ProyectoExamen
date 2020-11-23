
public class ClasesExamen {

    public ClasesExamen(){

        Profesor profe = new Profesor();
        profe.start();
        for (int i = 0; i < 10; i++){
            // dentro del for con el Alumno creado le tenemos que pasar al profesor
            Alumno alumno = new Alumno(profe);
            alumno.setName("Alumno "+i);
            alumno.start();
        }
    }
}

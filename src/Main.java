import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        boolean error;
        for (int i=0;i<2;i++){
        do {
            error = false;
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoje de quien ingresar los datos:\n 1.- Jugador\n 2.- Equipo\n 3.- Salir"));
                switch (opcion) {
                    case 1:
                        datosDelJugador();
                        break;
                    case 2:
                        datosDelEquipo();
                        break;
                    case 3:
                        i=3;
                        break;
                    default:
                        error = true;
                        throw new Exception("Debes escojer la opcion 1, 2 o 3");

                }

            } catch (NullPointerException e) {
                error=true;
                JOptionPane.showMessageDialog(null, "Si deseas cerrar el programa escoje la opcion 3 en el menu");
            }catch (NumberFormatException e){
                error=true;
                JOptionPane.showMessageDialog(null,"Debes introducir un numero");
            }catch (DateTimeParseException e){
                error=true;
                JOptionPane.showMessageDialog(null,"Introduce una fecha real");
            }catch (Exception e) {
                error=true;
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage() + " " + e.getClass());
            }
        }while (error);
    }
    }

    public static void datosDelJugador() throws Exception {
        String nombre = validarNombreDelJugador();
        String apellidos= validarApellidosDelJugador();
        LocalDate fechaDeNacimiento= validarFechaDeNacimentoJugador();
        String nacionalidad= validarNacionalidadDelJugador();
        String nickname=validarNicknameDelJugador();
        int sueldo=validarSueldoDelJugador();
    }

    public static String validarNombreDelJugador() throws Exception {
        boolean i;
        String nombre;
        do {
            i=true;
            nombre = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
            if(nombre!= null && !nombre.isBlank() && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+$"))
                i=false;
            else
                JOptionPane.showMessageDialog(null,"El nombre solo puede contener letras");
        }while(i);
        return nombre;
    }

    public static String validarApellidosDelJugador() throws Exception{
        String apellidos;
        boolean i;
        do {
            i=true;
            apellidos = JOptionPane.showInputDialog("Introduce los apelllidos del jugador:");
            if(apellidos != null && !apellidos.isBlank() && apellidos.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+(\\s^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+)+$"))
                i=false;
            else
                JOptionPane.showMessageDialog(null,"Los apellidos deben contener solo letras");
        }while(i);
        return apellidos;
    }

    public static LocalDate validarFechaDeNacimentoJugador()throws Exception{
        LocalDate fechaDeNacimineto = null;
        boolean i;
        String fechaTexto;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            i=true;
            fechaTexto = JOptionPane.showInputDialog("Introduce la fecha de nacimiento en formato dia-mes-año:");
            if(fechaTexto!=null && !fechaTexto.isBlank() && fechaTexto.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-[0-9]{4}$")&& LocalDate.parse(fechaTexto,formato).isBefore(LocalDate.now())) {
             fechaDeNacimineto= LocalDate.parse(fechaTexto,formato);
                i = false;
            }  else
                JOptionPane.showMessageDialog(null,"Introduce una fecha valida en formato dia-mes-año");
        }while(i);
        return fechaDeNacimineto;
    }

    public static String validarNacionalidadDelJugador() throws Exception {
        String nacionalidad;
        boolean i;
        do {
            i=true;
            nacionalidad = JOptionPane.showInputDialog("Introduce la nacionalidad del jugador:");
            if(nacionalidad!=null && !nacionalidad.isBlank() && nacionalidad.matches("^[a-zA-Z\\s]+$"))
                i=false;
            else
                JOptionPane.showMessageDialog(null,"La nacionlaidad solo puede estar compuesta por letras");
        }while(i);
        return nacionalidad;
    }

    public static String validarNicknameDelJugador() throws Exception{
        String nickname;
        boolean i;
        do {
            i=true;
            nickname = JOptionPane.showInputDialog("Introduce el nickname del jugador:");
            if(!nickname.isBlank() && nickname!=null)
                i=false;
            else
                JOptionPane.showMessageDialog(null,"Debes introducir un nickname para el jugador");
        }while(i);
        return nickname;
    }

    public static int validarSueldoDelJugador() throws Exception{
        int sueldo;
        boolean i;
        do {
            i=true;
            sueldo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el sueldo mensual del jugador:"));
            if(sueldo>1221)
                i=false;
            else
                JOptionPane.showMessageDialog(null,"El sueldo debe de ser mayor que el sueldo minimo mensual interprofesional (1221€)");
        }while(i);
        return  sueldo;
    }

    public static void datosDelEquipo()throws Exception{
        String nombreEquipo=validarNombreDelEquipo();
        LocalDate fechaFundacion=validarFechaDeFundacion();
    }

    public static String validarNombreDelEquipo() throws  Exception{
        String nombre;
        boolean i;
        do {
            i=true;
            nombre = JOptionPane.showInputDialog("Introduce el nombre del equipo:");
            if(nombre!=null && !nombre.isBlank() && nombre.matches("^[a-zA-Z\s]+$"))
                i=false;
            else
                JOptionPane.showMessageDialog(null,"El nombre del equipo solo debe contener letras");
        }while(i);
        return nombre;
    }

    public static LocalDate validarFechaDeFundacion()throws Exception{
       LocalDate fecha = null;
        boolean i;
        String fechaTexto;
        do {
            i=true;
            fechaTexto = JOptionPane.showInputDialog("Introduce la fecha de creacion en formato dia-mes-año:");
            if(fechaTexto!=null && !fechaTexto.isBlank() && fechaTexto.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-[0-9]{4}$")) {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                fecha= LocalDate.parse(fechaTexto,formato);
                i = false;
            }  else
                JOptionPane.showMessageDialog(null,"La fecha de creacion debe estar estrictamente en el formato dia-mes-año");
        }while(i);
        return fecha;

    }
}
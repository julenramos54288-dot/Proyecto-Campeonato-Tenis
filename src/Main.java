import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        boolean error;

        do {
            error = false;
            try {
                /*la estructura actual no es la mas correcta. pero esta pensada para en un futuro poder cambiar con mas
                * facilidad y que sea posible registrar tanto mas jugadores como mas equipos*/
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoje de quien ingresar los datos primero:\n 1.- Jugador\n 2.- Equipo\n 3.- Salir"));
                switch (opcion) {
                    case 1:
                        datosDelJugador();
                        datosDelEquipo();
                        break;
                    case 2:
                        datosDelEquipo();
                        datosDelJugador();
                        break;
                    case 3:
                        break;
                    default:
                        throw new Exception("Debes escoger la opcion 1, 2 o 3");

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

    public static void datosDelJugador() throws Exception {
        String nombre = validarNombreDelJugador();
        String apellido1= validarApellido1DelJugador();
        String apellido2= validarApellido2DelJugador();
        LocalDate fechaDeNacimiento= validarFechaDeNacimentoJugador();
        String nacionalidad= validarNacionalidadDelJugador();
        String rol=pedirRol();
        String nickname=validarNicknameDelJugador();
        int sueldo=validarSueldoDelJugador();
        confirmacionRegistroJugador(nombre,apellido1,apellido2,fechaDeNacimiento,nacionalidad,rol,nickname,sueldo);
    }

    public static String validarNombreDelJugador() throws Exception {
        boolean i;
        String nombre;
        do {
            i=true;
            nombre = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
            if(nombre!= null && !nombre.isBlank() && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$"))
                i=false;
            else
                JOptionPane.showMessageDialog(null,"El nombre solo puede contener letras");
        }while(i);
        return nombre;
    }

    public static String validarApellido1DelJugador() throws Exception{
        String apellido;
        boolean i;
        do {
            i=true;
            apellido = JOptionPane.showInputDialog("Introduce el primer apellido del jugador:");
            if(apellido != null && !apellido.isBlank() && apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$"))
                i=false;
            else
                JOptionPane.showMessageDialog(null,"El apellido deben contener solo letras");
        }while(i);
        return apellido;
    }
    public static String validarApellido2DelJugador() throws Exception{
        String apellido;
        boolean i;
        do {
            i=true;
            apellido = JOptionPane.showInputDialog("Introduce el segundo apellido del jugador:");
            if(apellido != null && !apellido.isBlank() && apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$"))
                i=false;
            else
                JOptionPane.showMessageDialog(null,"El apellido deben contener solo letras");
        }while(i);
        return apellido;
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
            if(nacionalidad!=null && !nacionalidad.isBlank() && nacionalidad.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$"))
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
        confirmacionRegistroEquipo(nombreEquipo,fechaFundacion);
    }

    public static String validarNombreDelEquipo() throws  Exception{
        String nombre;
        boolean i;
        do {
            i=true;
            nombre = JOptionPane.showInputDialog("Introduce el nombre del equipo:");
            if(nombre!=null && !nombre.isBlank() && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$"))
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
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            fechaTexto = JOptionPane.showInputDialog("Introduce la fecha de creacion en formato dia-mes-año:");
            if(fechaTexto!=null && !fechaTexto.isBlank() && fechaTexto.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-[0-9]{4}$") && LocalDate.parse(fechaTexto,formato).isBefore(LocalDate.now())) {

                fecha= LocalDate.parse(fechaTexto,formato);
                i = false;
            }  else
                JOptionPane.showMessageDialog(null,"La fecha de creacion debe estar estrictamente en el formato dia-mes-año");
        }while(i);
        return fecha;

    }

    public static String  pedirRol() throws Exception{
String rol;
boolean i;
do {
    i=true;
    rol=JOptionPane.showInputDialog(null, "Introduce el rol del jugador:");
    if(rol!=null && !rol.isBlank() && rol.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$"))
        i=false;
    else
        JOptionPane.showMessageDialog(null,"El rol del jugador solo debe contener letras y espacios");

}while(i);
return rol;
    }

    public static void confirmacionRegistroJugador(String nombre, String apellido1, String apellido2, LocalDate fechaDeNacimiento, String nacionalidad, String rol, String nickname, int sueldo)  {
        boolean error;
        int i;
        do{
            error=false;
        try {
            do {
                i = JOptionPane.showConfirmDialog(null, "Son todos los datos correctos?\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellidos: " + apellido1 + " " + apellido2 + "\n" +
                        "Fecha de nacimienato: " + fechaDeNacimiento + "\n" +
                        "Nacionalidad: " + nacionalidad + "\n" +
                        "Rol: " + rol + "\n" +
                        "Nickname: " + nickname + "\n" +
                        "Sueldo: " + sueldo + "\n", null, JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "Jugador registrado correctamente.");
                } else {

                    do {
                        error = false;
                        int opcion;
                        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Que dato esta mal: \n" +
                                "1.- Nombre\n" +
                                "2.- Apellido 1\n" +
                                "3.- Apellido 2\n" +
                                "4.- Fecha de nacimineto\n" +
                                "5.- Rol\n" +
                                "6.- Nickname\n" +
                                "7.- Sueldo\n" +
                                "8.- Nacionalidad"));
                        switch (opcion) {
                            case 1 -> nombre = validarNombreDelJugador();
                            case 2 -> apellido1 = validarApellido1DelJugador();
                            case 3 -> apellido2 = validarApellido2DelJugador();
                            case 4 -> fechaDeNacimiento = validarFechaDeNacimentoJugador();
                            case 5 -> rol = pedirRol();
                            case 6 -> nickname = validarNicknameDelJugador();
                            case 7 -> sueldo = validarSueldoDelJugador();
                            case 8 -> nacionalidad=validarNacionalidadDelJugador();
                            default -> {
                                JOptionPane.showMessageDialog(null, "Introduce un numero entre el 1 y el 7 ");
                                error = true;
                            }
                        }
                    } while (error);

                }
            } while (i == 1);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Debes escoger una opcion");
            error=true;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        }while(error);
    }

    public static void confirmacionRegistroEquipo(String nombreEquipo, LocalDate fechaFundacion) throws Exception{
        boolean error;
        int i;
        do{
            error=true;
        try{
        do{
            i=JOptionPane.showConfirmDialog(null, "Son todos los datos correctos?\n" +
                    "Nombre: " + nombreEquipo + "\n" +
                    "Fecha de funadación: " +fechaFundacion + "\n",null,
                     JOptionPane.YES_NO_OPTION);
            if (i==0) {
                JOptionPane.showMessageDialog(null, "Equipo registrado correctamente");
            }
            else
            {
                do {
                    error=false;
                    int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoje el dato incorrecto:\n" +
                            "1.- Nombre del equipo\n" +
                            "2.- Fecha de fundación"));
                    switch (opcion) {
                        case 1 -> nombreEquipo = validarNombreDelEquipo();
                        case 2 -> fechaFundacion = validarFechaDeFundacion();
                        default -> {
                            JOptionPane.showMessageDialog(null, "Debes escoger una de las dos opciones");
                            error = true;
                        }
                    }
                }while(error);
            }
        }while(i==1);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Debes escoger una opcion");
            error=true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }while(error);
    }
}
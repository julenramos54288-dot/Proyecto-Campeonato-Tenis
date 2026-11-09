import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            char opcion;
            do {
                opcion = MostrarMenu();
                switch (opcion){
                    case 'a'->{
                        NombreEquipo();
                        break;
                    }
                    case 'b'->{
                        FechaEquipo();
                        break;
                    }
                    case 'c'->{
                        DatosJugador();
                        break;
                    }
                }
            }while (opcion != 'd');
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"--ERRORES DESCONOCIDOS--"+ e.getMessage());
        }
    }
    public static char MostrarMenu(){
        char opcion=' ';
        boolean error;
        do {
            try {
                String respuesta = JOptionPane.showInputDialog("--ELIGE UNA OPCIÓN--\n" + "--(A) NOMBRE DEL EQUIPO--\n" + "--(B) FECHA DE CREACION DEL EQUIPO--\n" + "--(C) DATOS DEL JUGADOR--\n" + "--(D) SALIR--\n");
                if (respuesta.length()>1){
                    throw new Exception("--HAY QUE ELEGIR ALGUNA DE LAS OPCIONES--");
                }
                opcion = respuesta.toLowerCase().charAt(0);
                if (opcion != 'a' && opcion != 'b' && opcion != 'c' && opcion != 'd'){
                    throw new Exception("--LA OPCION ELEGIDA NO ES CORRECTA--");
                }
                error = false;
            }catch (IndexOutOfBoundsException e){
                error=true;
                JOptionPane.showMessageDialog(null,"--HAY QUE INDICAR UNA OPCIÓN--");
            }catch (NullPointerException e){
                error = true;
                JOptionPane.showMessageDialog(null,"--PARA SALIR PRESIONE 'D'--");
            }catch (Exception e){
                error = true;
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        } while (error);
        return opcion;
    }

    public static void DatosJugador() {
            NombreJugador();
            Apellido1Jugador();
            Apellido2Jugador();
            NacionalidadJugador();
            FechaJugador();
            Nickname();
            Rol();
            Sueldo();
    }


    // funciones de jugador
    public static String NombreJugador (){
        String nombre = "";
        boolean error;
        do {
            try {

                nombre = JOptionPane.showInputDialog(null, " --INGRESE EL NOMBRE DEL JUGADOR-- ");
                Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
                Matcher mat1 = Par1.matcher(nombre);
                if (!mat1.matches()) {
                    throw new Exception(" solo se admiten letras ");
                }
                error = false;
            } catch (Exception e) {
                error= true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());

            }
        }while (error);


        return nombre;
    }
    public static String Apellido1Jugador (){
        String apellido1 ="";
        boolean error;
        do {
            try {
                apellido1 = JOptionPane.showInputDialog(null, " --INGRESE EL APELLIDO 1 DEL JUGADOR-- ");
                Pattern Par2 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
                Matcher mat2 = Par2.matcher(apellido1);
                if (!mat2.matches()) {
                    throw new Exception(" solo se admiten letras ");
                }
            error = false;
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
            }
        } while (error);

        return apellido1;
    }
    public static String Apellido2Jugador (){
        String apellido2 ="";
        boolean error;
        do {
            try {
                apellido2 = JOptionPane.showInputDialog(null, " --INGRESE EL APELLIDO 2 DEL JUGADOR-- ");
                Pattern Par2 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
                Matcher mat2 = Par2.matcher(apellido2);
                if (!mat2.matches()) {
                    throw new Exception(" solo se admiten letras ");
                }
            error = false;
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
            }
        }while (error);

        return apellido2;
    }
    public static String NacionalidadJugador (){
        String nacionalidad ="";
        boolean error;
        do {
            try {
                nacionalidad = JOptionPane.showInputDialog(null, " --INGRESE LA NACIONALIDAD DEL JUGADOR-- ");
                Pattern Par3 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
                Matcher mat3 = Par3.matcher(nacionalidad);
                if (!mat3.matches()) {
                    throw new Exception(" solo se admiten letras ");
                }
            error = false;
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
            }
        }while (error);
        return nacionalidad;
    }
    public static LocalDate FechaJugador (){
        boolean error = true;
        do {
            try {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaNacimiento = JOptionPane.showInputDialog(null, " --INGRESE LA FECHA DE NACIMIENTO 'dia/mes/año'-- ");

                Pattern Par4 = Pattern.compile("(0[1-9]|[12][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$");
                Matcher mat4 = Par4.matcher(fechaNacimiento);
                if (!mat4.matches()) {
                    JOptionPane.showMessageDialog(null, " --FORMATO DE FECHA INVALIDO-- ");
                } else {
                    LocalDate FechaNacido = LocalDate.parse(fechaNacimiento, formato);
                    error = false;
                    return FechaNacido;
                }

            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (error);
        return null;
    }
    public static String Nickname (){
        String nickname = "";
        boolean error;
        do {
            try {
                nickname = JOptionPane.showInputDialog(null, " --INGRESE EL NICKNAME DEL JUGADOR-- ");
                Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9_ -]+");
                Matcher mat1 = Par1.matcher(nickname);
                if (!mat1.matches()) {
                    throw new Exception(" solo se admiten letras y núemros ");
                }
                error = false;
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
            }
        }while(error);
        return nickname;
    }
    public static String Rol (){
        String Rol = "";
        boolean error;
        do {
            try {
                Rol = JOptionPane.showInputDialog(null, " --INGRESE EL ROL DEL JUGADOR-- ");
                Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9_ -]+");
                Matcher mat1 = Par1.matcher(Rol);
                if (!mat1.matches()) {
                    throw new Exception(" solo se admiten letras y núemros ");
                }
                error = false;
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
            }
        }while (error);
        return Rol;
    }
    public static int Sueldo (){
        String sueldo = "";
        boolean error;
        int Sueldo;
        do {
            try {
                sueldo = JOptionPane.showInputDialog(null, " --INGRESE EL SUELDO DEL JUGADOR--");
                Pattern Par1 = Pattern.compile("[0-9]+");
                Matcher mat1 = Par1.matcher(sueldo);
                if (!mat1.matches()) {
                    throw new IllegalArgumentException(" ingrese solo numeros");
                }
                Sueldo = Integer.parseInt(sueldo);
                if (Sueldo <= 1221) {
                    throw new IllegalArgumentException(" el sueldo del jugador debe ser mayor a 1.221 euros");
                }
                error = false;
                return Sueldo;
            } catch (IllegalArgumentException e) {
                error = true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
            }
        }while (error);

        return 0;
    }
    // funciones de equipo
    public static String NombreEquipo (){
        String NombreEquipo = "";
        boolean error;
        do {
            try {
                NombreEquipo = JOptionPane.showInputDialog(null, " --INGRESE EL NOMBRE DEL EQUIPO-- ");
                Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9 ]+");
                Matcher mat1 = Par1.matcher(NombreEquipo);
                if (!mat1.matches()) {
                    throw new Exception(" solo se admiten letras ");
                }
                error = false;
            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, "ha ocurrido algo mal al ingresar los datos. " + e.getMessage());

            }
        }while (error);
        return NombreEquipo;
    }
    public static LocalDate FechaEquipo(){
        boolean error;
        do {
            try {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaEquipo = JOptionPane.showInputDialog(null, " --INGRESE LA FECHA DE FUNDACION DEL EQUIPO ASI 'dia/mes/año'-- ");

                Pattern Par4 = Pattern.compile("(0[1-9]|[12][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$");
                Matcher mat4 = Par4.matcher(fechaEquipo);
                if (!mat4.matches()) {
                    throw new Exception(" --FORMATO DE FECHA INVALIDO-- ");
                } else {
                    LocalDate FechaFundacion = LocalDate.parse(fechaEquipo, formato);
                    error = false;
                    return FechaFundacion;
                }

            } catch (Exception e) {
                error = true;
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while (error);

        return null;
    }



}
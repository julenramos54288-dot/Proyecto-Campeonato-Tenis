import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        DatosEquipo();


        
    }
    public static void DatosEquipo(){
        NombreEquipo();
        FechaEquipo();
        DatosJugador();
    }

    public static void DatosJugador() {
        // se pediran datos del jugaro, esta funcion se reutilizara si quieren en la funcion DatosEquipo.
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
        try {
            nombre = JOptionPane.showInputDialog(null, " --INGRESE EL NOMBRE DEL JUGADOR-- ");
            Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
            Matcher mat1 = Par1.matcher(nombre);
            if (!mat1.matches()) {
                throw new Exception(" solo se admiten letras ");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());

        }
        return nombre;
    }
    public static String Apellido1Jugador (){
        String apellido1 ="";
        try {
            apellido1 = JOptionPane.showInputDialog(null, " --INGRESE EL APELLIDO 1 DEL JUGADOR-- ");
            Pattern Par2 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
            Matcher mat2 = Par2.matcher(apellido1);
            if (!mat2.matches()) {
                throw new Exception(" solo se admiten letras ");
            }

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
        }

        return apellido1;
    }
    public static String Apellido2Jugador (){
        String apellido2 ="";
        try {
            apellido2 = JOptionPane.showInputDialog(null, " --INGRESE EL APELLIDO 2 DEL JUGADOR-- ");
            Pattern Par2 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
            Matcher mat2 = Par2.matcher(apellido2);
            if (!mat2.matches()) {
                throw new Exception(" solo se admiten letras ");
            }

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
        }

        return apellido2;
    }
    public static String NacionalidadJugador (){
        String nacionalidad ="";
        try {
            nacionalidad = JOptionPane.showInputDialog(null, " --INGRESE LA NACIONALIDAD DEL JUGADOR-- ");
            Pattern Par3 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+");
            Matcher mat3 = Par3.matcher(nacionalidad);
            if (!mat3.matches()) {
                throw new Exception(" solo se admiten letras ");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
        }
        return nacionalidad;
    }
    public static LocalDate FechaJugador (){
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaNacimiento = JOptionPane.showInputDialog(null, " --INGRESE LA FECHA DE NACIMIENTO 'dia/mes/año'-- ");

            Pattern Par4 = Pattern.compile("(0[1-9]|[12][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$");
            Matcher mat4 = Par4.matcher(fechaNacimiento);
            if (!mat4.matches()) {
                JOptionPane.showMessageDialog(null, " --FORMATO DE FECHA INVALIDO-- ");
            } else {
                LocalDate FechaNacido = LocalDate.parse(fechaNacimiento, formato);
                return FechaNacido;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return null;
    }
    public static String Nickname (){
        String nickname = "";
        try {
            nickname = JOptionPane.showInputDialog(null, " --INGRESE EL NICKNAME DEL JUGADOR-- ");
            Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9_ -]+");
            Matcher mat1 = Par1.matcher(nickname);
            if (!mat1.matches()) {
                throw new Exception(" solo se admiten letras y núemros ");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());

        }
        return nickname;
    }
    public static String Rol (){
        String Rol = "";
        try {
            Rol = JOptionPane.showInputDialog(null, " --INGRESE EL ROL DEL JUGADOR-- ");
            Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9_ -]+");
            Matcher mat1 = Par1.matcher(Rol);
            if (!mat1.matches()) {
                throw new Exception(" solo se admiten letras y núemros ");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());

        }
        return Rol;
    }
    public static int Sueldo (){
        String sueldo = "";
        int Sueldo;
        try{
            sueldo = JOptionPane.showInputDialog(null," --INGRESE EL SUELDO DEL JUGADOR--");
            Pattern Par1 = Pattern.compile("[0-9]+");
            Matcher mat1 = Par1.matcher(sueldo);
            if (!mat1.matches()){
                throw new IllegalArgumentException(" ingrese solo numeros");
            }
            Sueldo = Integer.parseInt(sueldo);
            if (Sueldo <= 1221){
                throw new IllegalArgumentException(" el sueldo del jugador debe ser mayor a 1.221 euros");
            }
            return Sueldo;

        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());
        }

        return 0;
    }
    // funciones de equipo
    public static String NombreEquipo (){
        String NombreEquipo = "";
        try {
            NombreEquipo = JOptionPane.showInputDialog(null, " --INGRESE EL NOMBRE DEL EQUIPO-- ");
            Pattern Par1 = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9_ -]+");
            Matcher mat1 = Par1.matcher(NombreEquipo);
            if (!mat1.matches()) {
                throw new Exception(" solo se admiten letras ");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ha ocurrido algo mal al ingresar los datos. " + e.getMessage());

        }
        return NombreEquipo;
    }
    public static LocalDate FechaEquipo(){
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaEquipo = JOptionPane.showInputDialog(null, " --INGRESE LA FECHA DE FUNDACION DEL EQUIPO ASI 'dia/mes/año'-- ");

            Pattern Par4 = Pattern.compile("(0[1-9]|[12][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$");
            Matcher mat4 = Par4.matcher(fechaEquipo);
            if (!mat4.matches()) {
                throw new Exception(" --FORMATO DE FECHA INVALIDO-- ");
            } else {
                LocalDate FechaFundacion = LocalDate.parse(fechaEquipo, formato);
                return FechaFundacion;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        return null;
    }



}
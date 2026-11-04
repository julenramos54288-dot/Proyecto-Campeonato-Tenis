import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String MENU;
    public static void main(String[] args) {
        try{
            do {
                mostrarMenu();
                recibirdatoMenu();

            }while(!"c".equalsIgnoreCase(MENU));


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage()+e.getClass());
        }


    }
    public static void mostrarMenu(){
        MENU= JOptionPane.showInputDialog(null,"¿Qué desea realizar? \n" +
                "a) Introducir los datos de un jugador \n" +
                "b) Introducir los datos de un equipo \n" +
                "c) salir");
    }
    public static void recibirdatoMenu(){
        if (MENU== null){
            JOptionPane.showMessageDialog(null,"Debes introducir una opción");
        }else {
            MENU= MENU.toLowerCase();
            switch (MENU){
                case "a"->solicitarDatosJugador();
                case "b" ->solicitarDatosEquipo();
                case "c"-> JOptionPane.showMessageDialog(null,"Cerrando el programa");
                default -> JOptionPane.showMessageDialog(null,"Opción incorrecta");
            }
        }

    }
    public static void solicitarDatosJugador(){
        String nombre = validarNombre();
        String apellidos= validarApellidos();
       String nacionalidad= validarNacionalidad();
       LocalDate fechaNacimiento= validarFechaNacimiento();
       String nickname= validarNickname();
        double sueldo= validarSueldo();
    }
    public static String validarNombre(){
        boolean valido= false;
        String nombre="";
        String regex="^[A-Za-záÁéÉóÓíÍÜüñÑúÚ ]{3,}$";
        Pattern pat= Pattern.compile(regex);
        while (!valido){
            nombre= JOptionPane.showInputDialog(null,"Introduce el nombre del jugador");
            if (nombre== null || nombre.isBlank()){
                JOptionPane.showMessageDialog(null,"No puedes dejar el campo en blanco");
            }else {
                Matcher mat= pat.matcher(nombre);
                if (!mat.matches()){
                    JOptionPane.showMessageDialog(null,"el nombre  no puede contener números ni caracteres especiales");
                }else {
                    valido=true;
                }
            }
        }
        return nombre;
    }
    public static String validarApellidos(){
        boolean valido= false;
        String apellidos="";
        String regex="^[A-Za-záÁéÉóÓíÍÜüñÑúÚ ]{3,}$";
        Pattern pat= Pattern.compile(regex);
        while (!valido){
            apellidos= JOptionPane.showInputDialog(null,"Teclea los apellidos del jugador");
            if (apellidos== null || apellidos.isBlank()){
                JOptionPane.showMessageDialog(null,"No puedes dejar el campo en blanco");
            }else {
                Matcher mat= pat.matcher(apellidos);
                if (!mat.matches()){
                    JOptionPane.showMessageDialog(null,"Los apellidos no pueden contener números ni caracteres especiales");
                }else {
                    valido=true;
                }
            }
        }
        return apellidos;
    }
    public static String validarNacionalidad(){
        boolean valido= false;
        String nacionalidad="";
        String regex="^[A-Za-záÁéÉóÓíÍÜüñÑúÚ ]{4,}$";
        Pattern pat= Pattern.compile(regex);
        while (!valido){
            nacionalidad= JOptionPane.showInputDialog(null,"Teclea la nacionalidad del jugador");
            if (nacionalidad== null || nacionalidad.isBlank()){
                JOptionPane.showMessageDialog(null,"No puedes dejar el campo en blanco");
            }else {
                Matcher mat= pat.matcher(nacionalidad);
                if (!mat.matches()){
                    JOptionPane.showMessageDialog(null,"La nacionalidad no puede contener números ni carácteres especiales");
                }else {
                    valido=true;
                }
            }
        }
        return nacionalidad;
    }
    public static LocalDate validarFechaNacimiento(){
        String fecha;
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaNacimiento=null;
        LocalDate hoy= LocalDate.now();
        boolean valido= false;
        while (!valido){
            try{
                fecha=JOptionPane.showInputDialog(null,"Teclea la fecha de nacimiento del jugador en el siguiente formato: \n dd-MM-yyyy");

                 if (fecha==null || fecha.isBlank()){
                     JOptionPane.showMessageDialog(null,"No puedes dejar la fecha vacía");
                 }else {
                     fechaNacimiento= LocalDate.parse(fecha, formato);
                     if (fechaNacimiento.isAfter(hoy)){
                         JOptionPane.showMessageDialog(null,"la fecha de nacimiento no puede ser posterior a la fecha actual");
                     }else {
                         valido=true;
                     }
                 }


                
            }catch (DateTimeException e){
                JOptionPane.showMessageDialog(null,"Error: Debes de teclear una fecha en este formato (dd-MM-yyyy)");
            }
        }
        return fechaNacimiento;
    }
    public static String validarNickname(){
        boolean valido= false;
        String nickname="";
        String regex="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ0-9-. _]{4,16}$";
        Pattern pat= Pattern.compile(regex);
        while (!valido){
            nickname= JOptionPane.showInputDialog(null,"Introduce el nickname del jugador");
            if (nickname== null || nickname.isBlank()){
                JOptionPane.showMessageDialog(null,"No puedes dejar el campo en blanco");
            }else {
                Matcher mat= pat.matcher(nickname);
                if (!mat.matches()){
                    JOptionPane.showMessageDialog(null,"El nickname debe tener entre 4 y 16 caracteres y solo puede contener letras, números, espacios, - y _.");

                }else {
                    valido=true;
                }
            }
        }
        return nickname;
    }
    public static double validarSueldo(){
        boolean valido=false;
        double sueldo=0.0;
       while (!valido){
           try{
               sueldo= Double.parseDouble(JOptionPane.showInputDialog(null,"Teclea el sueldo mensual bruto sin el simbolo del €"));
               if (sueldo>=0){
                   valido=true;
               }else {
                   JOptionPane.showMessageDialog(null,"El sueldo no puede ser negativo");
               }

           }catch (NumberFormatException e){
               JOptionPane.showMessageDialog(null,"el sueldo solo puede contener números");
           }catch (NullPointerException e){
               JOptionPane.showMessageDialog(null,"Debes de teclear el sueldo");
           }
       }
       return sueldo;
    }
    public static void solicitarDatosEquipo(){
        String nombre= validarNombreEquipo();
        LocalDate fechaFundacion= validarFechaFundacion();
    }
    public static String validarNombreEquipo(){
        boolean valido= false;
        String nombre="";
        String regex="^[A-Za-záÁéÉóÓíÍÜüñÑúÚ ]{3,}$";
        Pattern pat= Pattern.compile(regex);
        while (!valido){
            nombre= JOptionPane.showInputDialog(null,"Teclea el nombre del equipo");
            if (nombre== null || nombre.isBlank()){
                JOptionPane.showMessageDialog(null,"No puedes dejar el campo en blanco");
            }else {
                Matcher mat= pat.matcher(nombre);
                if (!mat.matches()){
                    JOptionPane.showMessageDialog(null,"El nombre del equipo no puede contener números ni caracteres especiales");
                }else {
                    valido=true;
                }
            }
        }
        return nombre;
    }
    public static LocalDate validarFechaFundacion(){
        LocalDate hoy= LocalDate.now();
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaFundacion=null;
        String fecha;
        boolean valido= false;
        while (!valido){
            try{
                fecha=JOptionPane.showInputDialog(null,"Teclea la fecha de fundación del equipo en el siguiente formato: \n dd-MM-yyyy");

                if (fecha==null || fecha.isBlank()){
                    JOptionPane.showMessageDialog(null,"No puedes dejar la fecha vacía");
                }else {
                    fechaFundacion= LocalDate.parse(fecha, formato);
                    if (fechaFundacion.isAfter(hoy)){
                        JOptionPane.showMessageDialog(null,"la fecha de fundación no puede ser posterior a la fecha actual");
                    }else {
                        valido=true;
                    }
                }

            }catch (DateTimeException e){
                JOptionPane.showMessageDialog(null,"Error: Debes de teclear una fecha en este formato (dd-MM-yyyy)");
            }
        }
        return fechaFundacion;
    }


}
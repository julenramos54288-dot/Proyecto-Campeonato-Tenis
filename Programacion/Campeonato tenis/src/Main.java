import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

void main(String[] args) {
    String nombre, naciomalidad, edad , alturast , peso , apellido1 , apellido2 , nombreEquipo, fecha, elegir;
    boolean continuar;
    Pattern patnm = Pattern.compile("^[A-Z][a-z]+([A-Z][a-z])*$");
    Pattern patnum = Pattern.compile("[0-9]+([0-9])*$");
    do {
        continuar=true;
        try {


    elegir = JOptionPane.showInputDialog(null, "Que quieres hacer? \n a) Registrar jugador. \n b) Registrar equipo. \n c) Salir.");
    switch (elegir) {
        case "a":
            do {
                continuar = true;
                try {
                    nombre = preguntarNombre(patnm);
                    apellido1 = preguntarApellido1(patnm);
                    apellido2 = preguntarApellido2(patnm);
                    naciomalidad = preguntarNacionalidad(patnm);
                    edad = preguntarEdad(patnum);
                    alturast = preguntarAltura(patnum);
                    peso = preguntarPeso(patnum);
                    JOptionPane.showMessageDialog(null, "Saludos " + nombre + " " + apellido1 + " " + apellido2 + " de " + naciomalidad + ". \n Por favor, dime si los siguiente datos son correctos: \n - Tienes " + edad + " años. \n - Tu altura es de " + alturast + "cm. \n - Tu peso es de " + peso + "kg.");
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Algo salio mal, por favor intentelo de nuevo.");
                    continuar = false;
                }
            } while (!continuar);
            break;
        case "b":
            nombreEquipo = preguntarNombreEquipo();
            fecha = preguntarFecha();
            JOptionPane.showMessageDialog(null ,"Has registrado al equipo " + nombreEquipo + " creado en " + fecha);
            break;
        case "c":
            JOptionPane.showMessageDialog(null, "Ádios");
            break;
        default:
            JOptionPane.showMessageDialog(null, "Selecciona una opción valida");
            continuar = false;
    }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Opción no valida, por favor selecciona una de las tres opciones");
            continuar = false;
        }
    } while (!continuar);
}
public static String preguntarNombreEquipo() {
    boolean continuar;
    String nombre = "";
    Pattern pat = Pattern.compile("^[A-Z]+[a-z]*$");
    do {
        try {
            continuar = true;
            nombre = JOptionPane.showInputDialog("Cual es el nombre del equipo?");
            Matcher mat = pat.matcher(nombre);
            if (!mat.matches()) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Error, nombre no valido");
            }
        } catch (NullPointerException e) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Por favor, rellena los datos");
        }
    } while (!continuar);
    return nombre;
}
public static String preguntarFecha() {
    String fecha = "";
    boolean continuar;
    DateTimeFormatter format= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    do {
        try {
            continuar = true;
            fecha = String.format(fecha, format);
            fecha = JOptionPane.showInputDialog(null, "Cual es la fecha de creación del equipo? \n (usa el siguiente formato: dd/MM/yyyy");
            LocalDate.parse(fecha, format);
        } catch (NullPointerException | DateTimeParseException e) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Datos invalidos, por favor rellenalos correctamente");
        }
    } while (!
            continuar);
    return fecha;
}
public static String preguntarNombre(Pattern patnm) {
    String nombre;
    boolean continuar;
    do {
        continuar = true;
        nombre = JOptionPane.showInputDialog(null, "Dime tu nombre");
        Matcher mat = patnm.matcher(nombre);
        if (!mat.matches()) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "El nombre no es valido");
        }
    } while (!continuar);
    return nombre;
}
public static String preguntarApellido1(Pattern patnm) {
    String apellido1;
    boolean continuar;
    do {
        continuar = true;
        apellido1 = JOptionPane.showInputDialog(null, "Dime tu primer apellido");
        Matcher mat = patnm.matcher(apellido1);
        if (!mat.matches()) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "El primer apellido no es valido");
        }
    } while (!continuar);
    return apellido1;
}
public static String preguntarApellido2(Pattern patnm) {
    String apellido2;
    boolean continuar;
    do {
        continuar = true;
        apellido2 = JOptionPane.showInputDialog(null, "Dime tu segundo apellido");
        Matcher mat = patnm.matcher(apellido2);
        if (!mat.matches()) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "El segundo apellido no es valido");
        }
    } while (!continuar);
    return apellido2;
}
public static String preguntarNacionalidad(Pattern patnm) {
    String naciomalidad;
    boolean continuar;
    do {
        continuar = true;
        naciomalidad = JOptionPane.showInputDialog(null, "Dime tu nacionalidad");
        Matcher mat = patnm.matcher(naciomalidad);
        if (!mat.matches()) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "La nacionalidad no es valida");
        }
    } while (!continuar);
    return naciomalidad;
}
public static String preguntarEdad(Pattern patnum) {
    String edad;
    boolean continuar;
    do {
        continuar = true;
        edad = JOptionPane.showInputDialog(null, "Dime tu edad");
        Matcher mat = patnum.matcher(edad);
        if (!mat.matches()) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Tu edad no es valida");
        }
    } while (!continuar);
    return edad;
}
public static String preguntarAltura (Pattern patnum) {
    String alturast;
    boolean continuar;
    do {
        continuar = true;
        alturast = JOptionPane.showInputDialog(null, "Dime tu altura en cm");
        Matcher mat = patnum.matcher(alturast);
        if (!mat.matches()) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Tu altura no es valida");
        }
    } while (!continuar);
    return alturast;
}
public static String preguntarPeso (Pattern patnum) {
    String peso;
    boolean continuar;
    do {
        continuar = true;
        peso = JOptionPane.showInputDialog(null, "Dime tu peso en kg");
        Matcher mat = patnum.matcher(peso);
        if (!mat.matches()) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Tu peso no es valido");
        }
    } while (!continuar);
    return peso;
}
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

void main(String[] args)    {
    Pattern patnm = Pattern.compile("^[A-Z][a-z]+([A-Za-z ñÑáéíóúÁÉÍÓÚüÜ])*$");
    Pattern patnum = Pattern.compile("[0-9]+([0-9])*$");
    Pattern patdos = Pattern.compile("^[a-z][A-Z][0-9]+([a-zA-Z0-9\\sñÑáéíóúÁÉÍÓÚüÜ])*$");
    String mostrar = mostrarMenu(patnm,patnum,patdos);
    JOptionPane.showMessageDialog(null, mostrar);
}
public static String mostrarMenu (Pattern patnm, Pattern patnum,Pattern patdos) {
    String elegir;
    boolean continuar;
    do {
        continuar=true;
        try {
            elegir = JOptionPane.showInputDialog(null, "Que quieres hacer? \n a) Registrar jugador. \n b) Registrar equipo. \n c) Salir.");
            switch (elegir) {
                case "a":
                    return registrarJugador(patnm,patnum,patdos);
                case "b":
                    return registrarEquipo();
                case "c":
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
    return "Ádios";
}
public static String registrarEquipo() {
    String nombreEquipo, fecha;
    nombreEquipo = preguntarNombreEquipo();
    fecha = preguntarFecha();
    return STR."Es correcta la información del equipo \{nombreEquipo} creado en \{fecha}?";
}
public static String registrarJugador(Pattern patnm , Pattern patnum, Pattern patdos) {
    String nombre , apellido1 , apellido2 , naciomalidad , edad , alturast , peso , nickname , rol , sueldo, texto="";
    boolean continuar;
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
            nickname = preguntarNickname(patdos);
            rol = preguntarRol(patdos);
            sueldo = preguntarSueldo(patnum);
            texto = "Saludos " + nombre + " " + apellido1 + " " + apellido2 + " de " + naciomalidad + ". \n Por favor, dime si los siguiente datos son correctos: \n - Tienes " + edad + " años. \n - Tu altura es de " + alturast + "cm. \n - Tu peso es de " + peso + "kg. \n - Tu nickname es " + nickname + "\n - Tu rol es " + rol + " \n - Tu sueldo es de " + sueldo;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Algo salio mal, por favor intentelo de nuevo.");
            continuar = false;
        }
    } while (!continuar);
    return texto;
}
public static String preguntarNombreEquipo() {
    boolean continuar;
    String nombre = "";
    Pattern pat = Pattern.compile("^[A-Z]+[a-z0-9ñÑ\\s,áéíóúÁÉÍÓÚÜü]*");
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
    String fechast = "";
    boolean continuar;
    DateTimeFormatter format= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    do {
        try {
            continuar = true;
            fechast = JOptionPane.showInputDialog(null, "Cual es la fecha de creación del equipo? \n (usa el siguiente formato: dd/MM/yyyy");
            fechast = String.format(fechast, format);
            LocalDate.parse(fechast, format);
            LocalDate fecha = LocalDate.parse(fechast, format);
            if (fecha.isAfter(LocalDate.now())) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "La fecha no puede ser posterior a la actual");
            }
        } catch (Exception e) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Datos invalidos, por favor rellenalos correctamente");
        }
    } while (!continuar);
    return fechast;
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
public static String preguntarNickname (Pattern patdos) {
    String nickname = "";
    boolean continuar;
    do {
        continuar = true;
        try {
            nickname = JOptionPane.showInputDialog(null, "Cual es el nickname del jugador");
            Matcher mat = patdos.matcher(nickname);
            if (mat.matches()) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "El nombre no es valido");
            }
        } catch (Exception e) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Solo puede incluir letras y la primera mayúscula");
        }
    } while (!continuar);
    return nickname;
}
public static String preguntarRol (Pattern patdos) {
    boolean continuar;
    String rol="";
    do {
        continuar = true;
        try {
            rol = JOptionPane.showInputDialog(null, "Dime tu rol");
            Matcher mat = patdos.matcher(rol);
            if (!mat.matches()){
                continuar = false;
                JOptionPane.showMessageDialog(null,"Rol no valido");
            }
        } catch (Exception e) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "Rellena la información");
        }
    } while (!continuar);
    return rol;
}
public static String preguntarSueldo(Pattern patnum) {
    String sueldo = "";
    boolean continuar;
    do {
        continuar = true;
        try {
            sueldo = JOptionPane.showInputDialog("Cual es el sueldo del jugador");
            Matcher mat = patnum.matcher(sueldo);
            int sueldoint = Integer.parseInt(sueldo);
            if (!mat.matches() || sueldoint<1221) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "El sueldo debe ser mayor que 1221€ y solo contener numeros");
            }
        }catch (Exception e) {
            continuar = false;
            JOptionPane.showMessageDialog(null, "El sueldo debe ser mayor que 1221€ y solo contener numeros");
        }
    } while (!continuar);
    return sueldo;
}
package utiles;

import io.github.palexdev.materialfx.controls.MFXTextField;

public class Validaciones {

    public static boolean validarLetras(String valor, String nombreObject, StringBuilder errors) {
        boolean a = false;
        if (validarCampoVacio(valor,nombreObject, errors)) {
            a = true;
        } else if (!valor.matches("[a-zA-Z]*")) {
            errors.append("El campo ").append(nombreObject).append(" solo permite letras \n");
            a = true;
        }
        return a;
    }
    public static boolean validarNumeros(String valor, String nombreObject, StringBuilder errors) {
        boolean a = true;
        if (validarCampoVacio(valor,nombreObject, errors)) {
            a = false;
        } else if (!valor.matches("\\d*")) {
            errors.append("El campo ").append(nombreObject).append(" solo permite letras\n");
            a = false;
        }
        return a;
    }
    public static boolean validarCampoVacio(String valor, String nombreObject, StringBuilder errors) {
        boolean a = false;
        if (valor.isEmpty()) {
            errors.append("El campo ").append(nombreObject).append(" está vacío\n");
            a = true;
        }
        return a;
    }
}

package es.babel.ejercicioahorcado;

import es.babel.ejercicioahorcado.app.AppAhorcado;
import es.babel.ejercicioahorcado.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.module.Configuration;

@SpringBootApplication
public class EjercicioAhorcadoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AppAhorcado appAhorcado = context.getBean(AppAhorcado.class);
        appAhorcado.run();
    }







    /*
Juego del ahorcado
Las posibles palabras las seleccionará de un listado de 10 palabras generado al arrancar la app que semantendrá  de forma fija en memoria de la app.
Este juego será de un solo jugador y al arrancar nos mostrará un menú para empezar un juego nuevo o salir.
Al entrar en juego nuevo, el jugador comenzará y tendrá 8 intentos para adivinar la palabra.
Al principio el juego nos mostrara un guion bajo ( _ ) por cada letra a adivinar y cuando el usuario indique una  letra, la aplicación comprobara la misma y si existe cambiara el guion bajo.
por la letra allí donde aparezca. Si el usuario introdujera más de un carácter se realizaría la comprobación de toda la palabra y si es correcta ganaría el juego.
El jugador gana si:
Introduce la palabra completa y esta correcta
Si letra a letra va completando la palabra y ya tendría todas rellenas.
Si el jugador no acierta ninguna letra se le van restando intentos hasta llegar a cero. En caso de que llegue a cero el usuario pierde y se le mostrara la palabra completa final.
En cada vuelta de introducción de letra o palabra se mostrará lo siguiente:
Palabra con guiones bajos o letras según haya ido acertando letras.
Número de intentos restantes (8 o menos)
Ejemplos:
Menú:
1.-Juego nuevo
2.- Salir.
8 intentos restantes P
P _ _ _ _ _ 8 intentos restantes A
P _ _ _ _ A 8 intentos restantes D
P _ _ _ D A 8 intentos restantes D
Realizar un análisis bien antes de comenzar el juego. Pensar en el/los modelos a realizar para soportar el juego.
    */

}

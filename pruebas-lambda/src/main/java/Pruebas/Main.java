package Pruebas;

import Pruebas.entidades.Producto;
import Pruebas.repositorios.ProductoRepository;
import org.atsistemas.entidades.Pelicula;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ProductoRepository repo = new ProductoRepository();

        repo.agregar(new Producto(1,"primer prodcuto",50));
        repo.agregar(new Producto(3, "Producto C", 19.99));
        repo.agregar(new Producto(2, "Producto B", 14.99));
        repo.agregar(new Producto(1, "Producto A", 9.99));
        Collection<Integer> listilla = Arrays.asList(1,2,3,4,5,6);
        // Ejemplo de Suppliers, No necesita que le pasemos parámetros y devuelve algo
        Stream.generate(() -> new Random().nextInt(1,50)).limit(5).forEach(System.out::println);

        //Consumidor y Biconsumidor, Recibe una variable genérica, hace algo con ella y luego no devuelve nada
        listilla.forEach(System.out::println);

        //Predicado y BiPredicado a clase Predicate tiene un método llamado test, que recibe un argumento y devuelve un booleano.
        //Podemos concluir que este método se utiliza para validar hipótesis
        listilla.stream().filter(x -> x*2==10).forEach(System.out::println);

        //Función y Bifuncion , La interfaz funcional Function es la más genérica. Tiene la definición más básica de función: recibe algo y devuelve algo.
        listilla.stream().map(x -> x*2).toList().forEach(System.out::println);

        //UnaryOperator y BiUnaryOperator , nuestros argumentos y retornos deben ser del mismo tipo para funcionar en el UnaryOperator. Recibe 2 y retorna 1
       Optional<Integer> numerofinal = listilla.stream().reduce((x, y) -> x*y);
        System.out.println(numerofinal);

        // Debería devolver True.
        List<String> listaDeNombres = Arrays.asList("Juan", "Pedro", "María", "Lucía");
        Long cantidadNombres = listaDeNombres.stream().filter(nombre->nombre.startsWith("L")).count();
        System.out.println(cantidadNombres);







    }
}

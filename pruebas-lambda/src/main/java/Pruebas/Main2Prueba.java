package Pruebas;

import Pruebas.entidades.Producto;
import Pruebas.repositorios.ProductoRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2Prueba {
    public static void main(String[] args) {
        ProductoRepository repo = new ProductoRepository();

        repo.agregar(new Producto(1,"primer prodcuto",50));
        repo.agregar(new Producto(3, "Producto C", 19.99));
        repo.agregar(new Producto(2, "Producto B", 14.99));
        repo.agregar(new Producto(1, "Producto A", 9.99));

        // Obtenemos el precio y filtramos por los que tienen un precio por debajo de 15
        Collection<Producto> products = repo.buscarPorCondicion(s->s.getPrecio()<15);
        //System.out.println(products);
        //Buscamos productos con precio por debajo de 15, lo ordenamos a la inversa y lo almacenamos en una lista de productos
        List<Producto> resultado = repo.buscarPorCondicion(producto -> producto.getPrecio() < 15)
                .stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        //System.out.println(resultado);



        // Probando cositas , con strings y lambdas
        // Creamos una lista de Strings con diferentes nombres.
        List<String> names = List.of("John", "John", "Mariam", "Alex", "Mohammado", "Mohammado", "Vincent", "Alex",
                "Alex");
        // Usamos el Stream y filtramos los nombres que contienen "ham" y lo almacenamos en una lista de String
        List<String> nombrefinal = names.stream().filter(name->name.contains("ham")).toList();
        // Aqui simplemente lo mostramos por pantalla, el resultado
        names.stream().filter(name->name.contains("o")).forEach(System.out::println);

        System.out.println(nombrefinal);







    }
}



package Pruebas.repositorios;
import Pruebas.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ProductoRepository {
    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    public void eliminar(int id) {
        productos.removeIf(producto -> producto.getId() == id);
    }

    public void actualizarPrecio(int id, double nuevoPrecio) {
        productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .ifPresent(producto -> producto.setPrecio(nuevoPrecio));
    }

    public List<Producto> buscarPorCondicion(Predicate<Producto> condicion) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto producto : productos) {
            if (condicion.test(producto)) {
                resultado.add(producto);
            }
        }
        return resultado;
    }

    public List<Producto> obtenerTodos() {
        return productos;
    }
}


package org.example.clases;
import org.example.interfaces.HelloService;
import org.example.interfaces.NombreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private NombreService nombreService;
    public void sayHello(){
        System.out.println("Hola Que tal: " + nombreService.diNombre());
    };
}

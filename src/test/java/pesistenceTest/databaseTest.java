package pesistenceTest;

import com.unimed.entities.Caso;
import com.unimed.entities.Credenciales;
import com.unimed.entities.Usuario;
import com.unimed.persistence.database.DatabaseAdapter;
import com.unimed.persistence.database.mySQLConnection;
import javafx.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class databaseTest {

    DatabaseAdapter database = mySQLConnection.getInstance();

    private static String user_id = "638761f5163842e0700001b3";
    private static String eps_id = "63865b81163842e07000002e";
    private static String username = "test@gmail.com";

    @Test
    void testCrearCaso() throws Exception {
        Caso c_true = new Caso("caso_prueba","test_descripcion",0,user_id, eps_id);
        Caso c_test = database.crearCaso(c_true);
        Assertions.assertEquals(c_true.nombre, c_test.nombre);
    }

    @Test
    void testConsultarCasos() throws Exception {
        List<Caso> casos = database.consultarCasos(user_id);
        Assertions.assertNotEquals(casos.size(), 0);
    }
    @Test
    void testConsultarUsuario()  {
        try {
            Usuario u = database.consultarUsuario(user_id);
            Assertions.assertEquals(u.id, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetCredenciales()  {
        try {
            Credenciales credenciales = database.getCredenciales(user_id);
            Assertions.assertEquals(user_id, credenciales.getUser_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testGetCredencialesByUsername()  {
        try {
            Credenciales credenciales = database.getCredencialesByUsername(username);
            Assertions.assertEquals(username,credenciales.getUsername() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testCrearUsuario() throws Exception {
        String[] nombres = {"juan", "pedro", "ana", "camila", "jose", "maria", "luis", "carlos", "daniel", "julian"};
        String[] apellidos = {"perez", "gomez", "lopez", "gutierrez", "rodriguez", "martinez", "sanchez", "perez", "gomez", "lopez"};
        String nombre = nombres[(int) (Math.random() * nombres.length)] + " " + apellidos[(int) (Math.random() * apellidos.length)];
        int edad = (int) (Math.random() * 100);
        Usuario usuario = new Usuario(nombre, edad, 170, 20, "0+", eps_id);
        Credenciales credenciales = new Credenciales(nombre.split(" ")[0]+"@gmail.com", "test");
        Pair<Credenciales, Usuario> user_info = database.crearUsuario(credenciales, usuario);
        Assertions.assertEquals(credenciales.getUsername(), user_info.getKey().getUsername());
    }
}

package pesistenceTest;

import com.unimed.entities.Caso;
import com.unimed.entities.Credenciales;
import com.unimed.entities.Eps;
import com.unimed.entities.Usuario;
import com.unimed.persistence.auth.Auth;
import com.unimed.persistence.database.DatabaseAdapter;
import com.unimed.persistence.database.mySQLConnection;
import javafx.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.util.List;

public class databaseTest {

    DatabaseAdapter database = mySQLConnection.getInstance();

    private static final String user_id = "638761f5163842e0700001b3";
    private static final String eps_id = "63865b81163842e07000002e";
    private static final String username = "test@gmail.com";

    @Test
    void testCrearCaso() throws Exception {
        Caso c_true = new Caso("leucemia","test_descripcion",0,"6387ffaf163842e070000322", eps_id);
        Caso c_test = database.crearCaso(c_true);
        Assertions.assertEquals(c_true.getNombre(), c_test.getNombre());
    }

    @Test
    @Disabled
    void testGetEPS() throws Exception{
        List<Eps > epsList =  database.getEPS();
        Assertions.assertEquals(epsList.get(0).id, eps_id);
//        Assertions.assertEquals(c_true.getNombre(), c_test.getNombre());
    }


    @Test
    @Disabled
    void testConsultarCasos() throws Exception {
        List<Caso> casos = database.consultarCasos(user_id);
        Assertions.assertNotEquals(casos.size(), 0);
    }
    @Test
    void testConsultarUsuario()  {
        try {
            Usuario u = database.consultarUsuario(user_id);
            Assertions.assertEquals(user_id, u.id);
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
        Credenciales credenciales = new Credenciales(nombre.split(" ")[0]+"@gmail.com", Auth.hashPassword("test"));
        Pair<Credenciales, Usuario> user_info = database.crearUsuario(credenciales, usuario);
        Assertions.assertEquals(credenciales.getUsername(), user_info.getKey().getUsername());
    }
}

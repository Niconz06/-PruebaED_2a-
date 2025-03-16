import instituto.Persona;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    // Tests para el constructor y métodos básicos
    @Test
    public void testConstructorVacio() {
        Persona persona = new Persona();
        assertEquals("", persona.getNombre());
        assertEquals(' ', persona.getGenero());
        assertEquals(1990, persona.getNacimiento().getYear());
    }

    @Test
    public void testConstructorConNif() {
        Persona persona = new Persona(12345678);
        assertEquals("12345678", persona.getNif().toString().split("-")[0]);
    }

    // Test para getEdad()
    @Test
    public void testGetEdad() {
        Persona persona = new Persona(12345678, "Ana López", 'M', 
            15, 5, LocalDate.now().getYear() - 25);
        assertEquals(25, persona.getEdad());
    }

    // Tests para equals()
    @Test
    public void testEqualsMismoNif() {
        Persona p1 = new Persona(12345678);
        Persona p2 = new Persona(12345678);
        assertTrue(p1.equals(p2));
    }

    @Test
    public void testEqualsDiferenteNif() {
        Persona p1 = new Persona(11111111);
        Persona p2 = new Persona(22222222);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void testEqualsObjetoNulo() {
        Persona p1 = new Persona(12345678);
        assertFalse(p1.equals(null));
    }

    // Test para compareTo()
    @Test
    public void testCompareTo() {
        Persona p1 = new Persona(11111111);
        Persona p2 = new Persona(22222222);
        assertTrue(p1.compareTo(p2) < 0);
    }

    // Test para toString()
    @Test
    public void testToStringNombreSimple() {
        Persona persona = new Persona(12345678, "Juan", 'H', 1, 1, 2000);
        assertTrue(persona.toString().contains("Juan\t\t\t"));
    }

    @Test
    public void testToStringNombreCompuesto() {
        Persona persona = new Persona(87654321, "María García", 'M', 1, 1, 1995);
        assertTrue(persona.toString().contains("María\tGarcía"));
    }
}

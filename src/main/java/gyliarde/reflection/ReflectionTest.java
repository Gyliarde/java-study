package gyliarde.reflection;

import gyliarde.reflection.model.Person;
import gyliarde.reflection.model.Product;
import gyliarde.reflection.model.ReflectionMapper;
import org.junit.Test;

import java.util.Map;

/**
 * http://blog.gabrielamorim.com/java-reflection-um-exemplo-pratico/
 */
public class ReflectionTest {

    @Test
    public void shouldReturnAllGetMethodsFromClass() {
        Person person = new Person();
        person.setId(1);
        person.setName("Gabriel");
        person.setLastName("Amorim");
        person.setAge(25);

        Product product = new Product();
        product.setId(1);
        product.setDescription("Oxford Dictionary");
        product.setPrice(11.90);
        product.setQuantity(1);

        Map<String, Object> attributes = ReflectionMapper.getAttributesMap(person);

        for(String key : attributes.keySet()) {
            System.out.println(key + ": " + attributes.get(key));
        }

        attributes = ReflectionMapper.getAttributesMap(product);

        for(String key : attributes.keySet()) {
            System.out.println(key + ": " + attributes.get(key));
        }

    }
}

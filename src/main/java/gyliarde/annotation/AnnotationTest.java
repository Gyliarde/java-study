package gyliarde.annotation;

import gyliarde.annotation.model.JsonSerializationException;
import gyliarde.annotation.model.ObjectToJsonConverter;
import gyliarde.annotation.model.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnnotationTest {

    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);

        System.out.println(jsonString);

        assertEquals(
                "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}",
                jsonString);
    }
}

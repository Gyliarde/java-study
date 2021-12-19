package gyliarde.optional;

import gyliarde.optional.model.Computer;
import gyliarde.optional.model.SoundCard;
import gyliarde.optional.model.Usb;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class OracleExamples {

    @Test
    public void shouldReturnComputerName() {
        Optional<Computer> computer = Optional.ofNullable(null);
        System.out.println(computer);


        String name = computer.flatMap(Computer::getSoundCard)
                .flatMap(SoundCard::getUsb)
                .map(Usb::getVersion)
                .orElse("UNKNOWN");


        Assert.assertEquals("UNKNOWN", name);
    }
}

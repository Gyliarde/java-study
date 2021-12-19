package gyliarde.optional.model;

import java.util.Optional;

public class SoundCard {
    private Optional<Usb> usb = Optional.empty();

    public Optional<Usb> getUsb() {
        return usb;
    }

    public void setUsb(Usb usb) {
        this.usb = Optional.ofNullable(usb);
    }
}

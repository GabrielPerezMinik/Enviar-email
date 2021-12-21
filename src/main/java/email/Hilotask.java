package email;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.apache.commons.mail.Email;

public class Hilotask extends Task {

    Email email;
    public Hilotask(Email email){
        this.email=email;
    }
    @Override
    protected Object call() throws Exception {
        email.send();


        return null;
    }
}

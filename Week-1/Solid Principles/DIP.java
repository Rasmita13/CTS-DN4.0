interface AlertService {
    void triggerAlert(String msg);
}

class PushNotificationService implements AlertService {
    public void triggerAlert(String msg) {
        System.out.println("Push Alert: " + msg);
    }
}

class AlertManager {
    private AlertService service;
    public AlertManager(AlertService service) {
        this.service = service;
    }

    public void sendAlert(String message) {
        service.triggerAlert(message);
    }
}

public class DIP {
    public static void main(String[] args) {
        AlertService service = new PushNotificationService();
        AlertManager manager = new AlertManager(service);
        manager.sendAlert("Server is down!");
    }
}

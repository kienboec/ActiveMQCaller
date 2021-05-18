import communication.Consumer;
import communication.Producer;
import service.ToUpperStringService;

public class Main {
    public static void main(String[] args) {
        // http://localhost:8161/admin/queues.jsp

        System.out.println("Run 'hello world'");
        Producer.send("hello world", "MicroService.Input", "tcp://localhost:61616");

        System.out.println("Start Service ToUpper");
        new ToUpperStringService().execute(
                "MicroService.Input",
                "MicroService.Output",
                "tcp://localhost:61616");

        String output = Consumer.receive("MicroService.Output", 30000, "tcp://localhost:61616");
        System.out.println("Results in '" + output + "'");
    }
}

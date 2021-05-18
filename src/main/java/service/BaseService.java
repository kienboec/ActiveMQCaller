package service;

import communication.Consumer;
import communication.Producer;

public abstract class BaseService {

    public void execute(String inDestination, String outDestination, String brokerUrl) {
        String input = Consumer.receive(inDestination, 10000, brokerUrl);
        var output = executeInternal(input);
        Producer.send(output, outDestination, brokerUrl);
    }

    protected abstract String executeInternal(String input);
}

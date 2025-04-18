package mastercard;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectorFactory {
    private int totalNumberOfConnectors;

    public List<Connector> createConnectors(int portNumber,
                                            final String databaseAddress,
                                            int numberOfConnectors) {
        List<Connector> connectors = new ArrayList<>();

        for (int i = 0; i < numberOfConnectors; i++) {
            Connector connector = new Connector() {
                @Override
                public boolean connect() {
                    // Not yet implemented
                    return true;
                }

                @Override
                public void disconnect() {
                    // Not yet implemented
                }
            };
            connectors.add(connector);
        }
        return connectors;
    }

    interface Connector {
        boolean connect();

        void disconnect();
    }
}
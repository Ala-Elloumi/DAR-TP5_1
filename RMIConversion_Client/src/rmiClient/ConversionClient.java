package rmiClient;
import rmiService.IConversion;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionClient {
    public static void main(String[] args){

        try {
            // Adresse et port du registre RMI
            String serverAddress = "localhost";
            int serverPort = 1099;

            // Obtention du registre RMI
            Registry registry = LocateRegistry.getRegistry(serverAddress, serverPort);

            // Obtention du service RMI à partir du registre
            IConversion conversionService = (IConversion) registry.lookup("ConversionService");

            // Utilisez le service RMI
            double montantDinar = 100.0;
            double montantEuros = conversionService.convertirMontant(montantDinar);

            System.out.println("Montant en Dinar : " + montantDinar);
            System.out.println("Montant converti en Euros : " + montantEuros);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

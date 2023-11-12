package rmiServer;
import rmiService.ConversionImpl;
import rmiService.IConversion;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ConversionServer {
    public static void main(String[] args){

        try {
            // Création d'une instance du service de conversion
            IConversion conversionService = new ConversionImpl();

            // Création du registre RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Enregistrement du service dans le registre RMI sous le nom "ConversionService"
            registry.rebind("ConversionService", (Remote) conversionService);

            System.out.println("Serveur RMI prêt.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

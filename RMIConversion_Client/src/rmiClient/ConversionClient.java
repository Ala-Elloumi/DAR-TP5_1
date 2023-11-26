package rmiClient;
import rmiService.IConversion;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionClient {
    public static void main(String[] args){

        try {
            // Declaration de l'Adresse et le port du registre RMI
            String serverAddress = "localhost";
            int serverPort = 1099;

            // Obtention d'une référence à un registre RMI d'objets distant
            Registry registre = LocateRegistry.getRegistry(serverAddress, serverPort);

            // Récupération du service RMI à partir du registre
            IConversion conversionService = (IConversion) registre.lookup("ConversionService");

            // Utilisation du service RMI
            double montantDinar = 100.00;
            double montantEuros = conversionService.convertirMontant(montantDinar);

            // Affichage avant conversion
            System.out.println("Montant en Dinars : " + montantDinar);

            // Affichage aprés conversion
            System.out.println("Montant converti en Euros : " + montantEuros);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

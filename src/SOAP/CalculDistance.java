package SOAP;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;
import javax.xml.ws.Endpoint;

@WebService()
public class CalculDistance {
    @WebMethod
    public Double retourneDistance(Double latitude_A, Double longitude_A, Double latitude_B, Double longitude_B ) {
        //Passage en radians des variables en paramètres
        longitude_A = Math.toRadians(longitude_A);
        longitude_B = Math.toRadians(longitude_B);
        latitude_A = Math.toRadians(latitude_A);
        latitude_B = Math.toRadians(latitude_B);


        double distance = longitude_B - longitude_A;
        double rayon = Math.acos((Math.sin(latitude_A) * Math.sin(latitude_B)) + (Math.cos(latitude_A) * Math.cos(latitude_B) * Math.cos(distance)));

        //Passage du rayon en degrees
        rayon = Math.toDegrees(rayon);
        double resultat = rayon * 60 * 1.1515 * 1.609344;
        resultat = Math.round(resultat);
        System.out.println(resultat);
        return resultat;
    }

    public static void main(String[] args) {

    }
}

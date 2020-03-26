package FunctionLayer;

/**
 * Formålet med denne klasse er at kunne gi tilbakemelding til en bruger av websiden når noe går galt
 *
 */
public class LoginSampleException extends Exception {
    /**
     * Denne metode gjør det mulig å gi bruger av webside en mer utfyllende forklaring på hva der er gået galt
     * @param msg
     */

    public LoginSampleException(String msg) {
        super(msg);
    }
    

}

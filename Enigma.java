import java.util.Scanner;
import java.util.HashMap;

public class Enigma{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        // mimicing a Enigma M3 machine

        Setup my_enigma = new Setup();

        int rotor1 = 0, rotor2 = 0, rotor3 = 0;
        HashMap<String, String> rotor = new HashMap<String, String>(),
                                reflector = new HashMap<String, String>();
        HashMap<Character, Character> plugboard = new HashMap<Character, Character>();

        String[] rotor_set = my_enigma.rotor_set.split(" ");

        // rotor and reflector set of the Enigma: https://www.cryptomuseum.com/crypto/enigma/i/index.htm

        rotor.put("I", "EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        rotor.put("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE");
        rotor.put("III", "BDFHJLCPRTXVZNYEIWGAKMUSQO");
        rotor.put("IV", "ESOVPZJAYQUIRHXLNFTGKDCMWB");
        rotor.put("V", "VZBRGITYUPSDNHLXAWMJQOFECK");

        reflector.put("UKW-A", "EJMZALYXVBWFCRQUONTSPIKHGD");
        reflector.put("UKW-B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");
        reflector.put("UKW-C", "FVPJIAOYEDRZXWGCTKUQSBNMHL");

        rotor1 = rotor.get(my_enigma.rotor_set.split(" ")[0]).indexOf(my_enigma.rotor_pos.split(" ")[0]);
        rotor2 = rotor.get(my_enigma.rotor_set.split(" ")[1]).indexOf(my_enigma.rotor_pos.split(" ")[1]);
        rotor3 = rotor.get(my_enigma.rotor_set.split(" ")[2]).indexOf(my_enigma.rotor_pos.split(" ")[2]);


        for(int i = 0; i < 26; i++){
            plugboard.put((char)('A' + i), (char)('A' + i));
        }
        for(int i = 0; i < my_enigma.plugboard.length(); i += 3){
            plugboard.put(my_enigma.plugboard.charAt(i), my_enigma.plugboard.charAt(i+1));
            plugboard.put(my_enigma.plugboard.charAt(i+1), my_enigma.plugboard.charAt(i));
        }

        // Ask user for input
        // and store the input inside a object called "text"
        System.out.println("\nEnter text to encrypt/decrypt:");
        String text = input.nextLine();

        System.out.println("\nOutput:");


        Character character;
        //For each characters entered:
        for(int i = 0; i < text.length(); i++){
            character = text.charAt(i);

            if(character == ' '){
                System.out.print(' ');
                continue;
            }

            // firstly, the character is altered by the plugboard
            character = plugboard.get(character);
            // next, the character was passed over the rotors
            // rotor 1:
            character = (char)((character + rotor.get(rotor_set[0]).charAt(rotor1) - 2 * 'A') % 26 + 'A');
            // rotor 2:
            character = (char)((character + rotor.get(rotor_set[1]).charAt(rotor2) - 2 * 'A') % 26 + 'A');
            // rotor 3:
            character = (char)((character + rotor.get(rotor_set[2]).charAt(rotor3) - 2 * 'A') % 26 + 'A');

            // next, the character was passed to the reflector
            character = reflector.get(rotor_set[3]).charAt((int)(character - 'A'));

            // after that, the reflected character is passed back to the rotors
            // rotor 3:
            character = (char)((character - rotor.get(rotor_set[2]).charAt(rotor3) + 26) % 26 + 'A');
            // rotor 2:
            character = (char)((character - rotor.get(rotor_set[1]).charAt(rotor2) + 26) % 26 + 'A');
            // rotor 1:
            character = (char)((character - rotor.get(rotor_set[0]).charAt(rotor1) + 26) % 26 + 'A');

            // lastly, the character is altered again by the plugboard
            character = plugboard.get(character);

            // note that the first rotor shift once every time after the user typed a character
            rotor1++;
            // the second rotor shift once every time the first rotor finishes a cycle
            if(rotor1 == 26){
                rotor1 = 0;
                rotor2++;
            }
            // the third rotor shift once every time the second rotor finishes a cycle
            if(rotor2 == 26){
                rotor2 = 0;
                rotor3++;
            }
            if(rotor3 == 26){
                rotor3 = 0;
            }


            // finally, the machine displays the altered character
            System.out.print(character);
        }

        System.out.println("\n");
    }
}

package controller;
import sdk.connection;
import models.book;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by Ejer on 24-11-2016.
 */
public class controller {


    Scanner input;

    public controller() {
        Scanner input = new Scanner(System.in);
    }


    public void hovedMenu() {

        String username;
        String password;

        System.out.println("Velkommen til Bookit");
        System.out.println("Her er login menuen");
        // indsæt opret bruger
        System.out.println("Indtast dit Brugernavn");
        username = input.nextLine();
        System.out.println("Indtast dit password");
        password = input.nextLine();

        //Hvis brugernavn og password stemmer overens med dem i databasen
        // så bliver man sendt videre til brugermenuen

        String token = connection.authorizeLogin(username, password);

        if (token != null) {
            do {
                System.out.println("Login menu");
                System.out.println("Tryk 1. for at printe bøger");
                System.out.println("Tryk 2. for at vise pensumliste");
                System.out.println("Tryk 3. for at opdatere dine brugeroplysninger");
                System.out.println("Tryk 4. for at slette bruger");
                switch (input.nextInt()) {
                    case 1:
                        printBooks();
                        break;
                    case 2:
                        //vis pensumliste(r)
                        break;

                    case 3:
                        // opdater bruger
                        break;

                    case 4:
                        //slet bruger
                        break;

                    default:
                        System.out.println("Du bedes bruge én af valgmulighederne");

                }
            } while (true); //
        } else {
            System.out.println("Forkert brugernavn eller adgangskode");
        }
    }
            //Her er klassen til printBooks. Den g
        public void printBooks () {
            ArrayList<book> books = connection.getBooks();
            System.out.println("Her er alle bøger");
            for (book Book : books) {
                System.out.println("id: " + book.getBookID() + "titel" + book.getTitle());
            }
        }


    }




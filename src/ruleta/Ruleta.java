/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ruleta;

import java.util.Scanner;

/**
 *
 * @author Manel
 */
public class Ruleta {

    // una funcio per fer el print del tauler:
    public static void tauler() {
        int numerosTaula = 0;
        System.out.println("   " + numerosTaula + "   ");
        for (int i = 0; i < 12; i++) {
            for (int j = 3; j > 0; j--) {
                numerosTaula++;
                if (numerosTaula < 10) {
                    System.out.print("0" + numerosTaula + " ");
                } else {
                    System.out.print(numerosTaula + " ");
                }
            }
            System.out.println();
        }
    }

    public static int fesAposta(int aposta, int diners) {
        Scanner scan = new Scanner(System.in);
        // Digues cuant apostes
        System.out.println("No va mes");
        System.out.print("Digues la cuantitat de diners que vols apostar: ");
        do {
            aposta = scan.nextInt();
            scan.nextLine();
            if (aposta < 1 || diners - aposta < 0) {
                System.out.println("No pots ni apostar menys de 0 ni apostar mes diners del que tens");
                System.out.println("Encara tens " + diners + " euros");
                System.out.println("Cuant apostes?");
            }
        } while (aposta < 1 || diners - aposta < 0);
        return aposta;
    }
    
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Comença la ruleta
        System.out.println("Benvinguts al Casino Daza on l'ultim que es perd son els diners!");
        System.out.println("          _____\n"
                + "         |A .  | _____\n"
                + "         | /.\\ ||A ^  | _____\n"
                + "         |(_._)|| / \\ ||A _  | _____\n"
                + "         |  |  || \\ / || ( ) ||A_ _ |\n"
                + "         |____V||  .  ||(_'_)||( v )|\n"
                + "                |____V||  |  || \\ / |\n"
                + "                       |____V||  .  |\n"
                + "                              |____V|");

        // Variables globals
        int casino = 0;
        int motiuSortida = 0;
        int tipusAposta = 0;
        int guanyades = 0;
        int randy = 0;

        // Arrays
        String partides[] = new String[10];
        int apostats[] = new int[10];

        //Estadistiques
        int diners = 100;

        for (int i = 0; i < 10; i++) {
            int aposta = 0;
            if (i == 9) {
                motiuSortida = 1;
            }
            System.out.println("Que voleu fer?");
            System.out.println("1. Jugar!!!");
            System.out.println("2. Consultar resultats");
            System.out.println("3. Sortir");
            casino = scan.nextInt();
            if (diners == 0) {
                System.out.println("Que fas aqui? NO ET QUEDEN DINERS! FORA!");
                casino = 3;
                motiuSortida = 2;
            }
            switch (casino) {
                case 1:
                    System.out.println("Facin joc");
                    System.out.println("1. Color");
                    System.out.println("2. Parells/Imparell");
                    System.out.println("3. Pasa/Falta");
                    System.out.println("4. Dotzena");
                    System.out.println("5. Columna");
                    System.out.println("6. Doble dotzena");
                    System.out.println("7. Doble columna");
                    System.out.println("8. Sisena");
                    System.out.println("9. Quadre");
                    System.out.println("10. Transversal");
                    System.out.println("11. Cavall");
                    System.out.println("12. Ple");
                    System.out.println("Altre. Sortir");

                    // Impressio del tauler
                    tauler();

                    tipusAposta = scan.nextInt();
                    scan.nextLine();
                    System.out.println();

                    switch (tipusAposta) {
                        case 1:
                            partides[i] = "Color";
                            // Digues cuant apostes
                            aposta = fesAposta(aposta, diners);
                            
                            apostats[i] = aposta;
                            String color = "";
                            boolean vermell = false;

                            // Escull color
                            do {
                                System.out.println("Quin color? (v/n)");
                                color = scan.nextLine();
                            } while (color.compareTo("v") != 0 && color.compareTo("n") != 0);

                            // Tira la ruleta
                            randy = (int) (Math.random() * 37);

                            //Els colors de la ruleta no tenen ningun patro més que aquest:
                            if ((randy > 0 && randy < 10) && randy % 2 == 1) {
                                vermell = true;
                            } else if ((randy > 10 && randy < 19) && randy % 2 == 0) {
                                vermell = true;
                            } else if ((randy > 18 && randy < 28) && randy % 2 == 1) {
                                vermell = true;
                            } else if (randy > 29 && randy % 2 == 0) {
                                vermell = true;
                            }

                            // Resultat ruleta
                            System.out.println("El numero de la ruleta es: " + randy);
                            if (randy == 0) {
                                System.out.println("Mala sort! em quedo la meitat");
                                aposta /= 2;
                                diners -= aposta;
                            } else if ((vermell == true && color.compareTo("v") == 0) || (vermell == false && color.compareTo("n") == 0)) {
                                System.out.println("Henorabona! Gaunyes!");
                                diners += aposta;
                                guanyades++;
                            } else {
                                System.out.println("Quina pena! Em quedo tots els diners");
                                diners -= aposta;
                            }

                            break;
                        case 2:
                            partides[i] = "Parells/Imparells";
                            // Digues cuant apostes
                            aposta = fesAposta(aposta, diners);
                            apostats[i] = aposta;
                            
                            // Escull Parell imparell
                            do {
                                System.out.println("Parell o imparell? (p/i)");
                                color = scan.nextLine();
                            } while (color.compareTo("p") != 0 && color.compareTo("i") != 0);

                            // Tira la ruleta
                            randy = (int) (Math.random() * 37);

                            // Resultat ruleta
                            System.out.println("El numero de la ruleta es: " + randy);
                            if (randy == 0) {
                                System.out.println("Mala sort! em quedo la meitat");
                                aposta /= 2;
                                diners -= aposta;
                            } else if ((randy % 2 == 1 && color.compareTo("i") == 0) || (randy % 2 == 0 && color.compareTo("p") == 0)) {
                                System.out.println("Henorabona! Gaunyes!");
                                diners += aposta;
                                guanyades++;
                            } else {
                                System.out.println("Quina pena! Em quedo tots els diners");
                                diners -= aposta;
                            }

                            break;
                        case 3:
                            partides[i] = "Pasa/Falta";
                            // Digues cuant apostes
                            aposta = fesAposta(aposta, diners);
                            apostats[i] = aposta;
                            
                            // Escull Pasa Falta
                            do {
                                System.out.println("Pasa o Falta? (p/f)");
                                color = scan.nextLine();
                            } while (color.compareTo("p") != 0 && color.compareTo("f") != 0);

                            // Tira la ruleta
                            randy = (int) (Math.random() * 37);

                            // Resultat ruleta
                            System.out.println("El numero de la ruleta es: " + randy);
                            if (randy == 0) {
                                System.out.println("Mala sort! em quedo la meitat");
                                aposta /= 2;
                                diners -= aposta;
                            } else if ((randy < 19 && color.compareTo("p") == 0) || (randy > 18 && color.compareTo("f") == 0)) {
                                System.out.println("Henorabona! Gaunyes!");
                                diners += aposta;
                                guanyades++;
                            } else {
                                System.out.println("Quina pena! Em quedo tots els diners");
                                diners -= aposta;
                            }
                            
                            break;
                        case 4:
                            partides[i] = "Dotzena";
                            // Digues cuant apostes
                            aposta = fesAposta(aposta, diners);
                            apostats[i] = aposta;

                            // Escull Dotzena
                            int dotzena = 0;
                            do {
                                System.out.println("Quina dotzena vols?");
                                System.out.println("1. Del 1 al 12");
                                System.out.println("2. Del 13 al 24");
                                System.out.println("3. Del 25 al 36");
                                dotzena = scan.nextInt();
                                
                            } while (dotzena != 1 && dotzena != 2 && dotzena != 3);

                            // Tira la ruleta
                            randy = (int) (Math.random() * 37);
                            
                            // Resultat ruleta
                            System.out.println("El numero de la ruleta es: " + randy);
                            if (randy == 0) {
                                System.out.println("Mala sort! em quedo la meitat");
                                aposta /= 2;
                                diners -= aposta;
                            } else if ((randy < 13 && dotzena == 1) || (randy < 25 && randy > 12 && dotzena == 2) || (randy < 37 && randy > 24 && dotzena == 3)) {
                                System.out.println("Henorabona! Gaunyes Doble!");
                                aposta = aposta * 2;
                                diners += aposta;
                                guanyades++;
                            } else {
                                System.out.println("Quina pena! Em quedo tots els diners");
                                diners -= aposta;
                            }
                            
                            break;
                        case 5:
                            partides[i] = "Columna";
                            // Digues cuant apostes
                            aposta = fesAposta(aposta, diners);
                            apostats[i] = aposta;
                            
                            
                            // Crear cada columna 
                            int dreta[] = new int[12];
                            int centre[] = new int[12];
                            int esquerra[] = new int[12];
                            int bucleDreta = 0;
                            int bucleCentre = 0;
                            int bucleEsquerra = 0;
                            
                            for(int x = 1; x <= 36; x++){
                                if(x % 3 == 1){
                                    dreta[bucleDreta] = x;
                                    bucleDreta++;
                                }else if(x % 3 == 2){
                                    centre[bucleCentre] = x;
                                    bucleCentre++;
                                }else if(x % 3 == 0){
                                    esquerra[bucleEsquerra] = x;
                                    bucleEsquerra++;
                                }
                            }
                            
                            
                            // Escull Columna
                            int col = 0;
                            do {
                                System.out.println("Quina dotzena vols?");
                                System.out.println("1. Columna dreta");
                                System.out.println("2. Columna centre");
                                System.out.println("3. Columna esquerra");
                                col = scan.nextInt();
                            } while (col != 1 && col != 2 && col != 3);
                            
                            
                            // Tira la ruleta
                            randy = (int) (Math.random() * 37);
                            
                            // Resultat ruleta
                            /*System.out.println("El numero de la ruleta es: " + randy);
                            if (randy == 0) {
                                System.out.println("Mala sort! em quedo la meitat");
                                aposta /= 2;
                                diners -= aposta;
                            } else if ((randy < 13 && dotzena == 1) || (randy < 25 && randy > 12 && dotzena == 2) || (randy < 37 && randy > 24 && dotzena == 3)) {
                                System.out.println("Henorabona! Gaunyes Doble!");
                                aposta = aposta * 2;
                                diners += aposta;
                                guanyades++;
                            } else {
                                System.out.println("Quina pena! Em quedo tots els diners");
                                diners -= aposta;
                            }*/
                            
                            break;
                        case 6:

                            break;
                        case 7:

                            break;
                        case 8:

                            break;
                        case 9:

                            break;
                        case 10:

                            break;
                        case 11:

                            break;
                        case 12:

                            break;
                        default:
                            System.out.println("Ets tot un cobejat!");
                            i--;
                    }
                    break;
                case 2:

                    System.out.println("Partides jugades: " + i);
                    System.out.println("Partides guanyades: " + guanyades);
                    System.out.println("Partides perdudes: " + (i - guanyades));
                    System.out.println("Tipus aposta per partida i diners apostats");
                    for (int j = 0; j < i; j++) {

                        System.out.println("-    Partida " + (j + 1) + " del joc " + partides[j] + " diners apostats: " + apostats[j]);
                    }

                    System.out.println("Et queden " + diners + " euros");
                    System.out.println("Escriu cualsevol caracter per sortir");
                    scan.nextInt();
                    i--;
                    break;
                case 3:
                    i = 10;
                    break;
                default:
                    System.out.println("Numero no valid");
            }
        }

        switch (motiuSortida) {
            case 0:
                System.out.println("Torna aviat! (Sortit per voluntat propia)");
                break;
            case 1:
                System.out.println("Has arribat al maxim de jugades! Torna dema");
                break;
            case 2:
                System.out.println("Ets expulsat del casino per pobre");
                break;
            default:
                System.out.println("Torna aviat! (Sortit per voluntat propia)");
        }
    }

}

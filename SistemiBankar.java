import java.util.Scanner;

// Klasa për të menaxhuar llogarinë
class LlogariaBankare {
    private String emri;
    private double bilanci;

    // Konstruktori për krijimin e llogarisë
    public LlogariaBankare(String emri, double shumaFillestare) {
        this.emri = emri;
        this.bilanci = shumaFillestare;
    }

    // Metoda për depozitim
    public void depozito(double shuma) {
        if (shuma > 0) {
            bilanci += shuma;
            System.out.println("Depozitimi u krye me sukses!");
        } else {
            System.out.println("Shuma duhet të jetë pozitive!");
        }
    }

    // Metoda për tërheqje me kontroll if-else
    public void terhiq(double shuma) {
        if (shuma > bilanci) {
            System.out.println("Gabim: Mjete të pamjaftueshme!");
        } else if (shuma <= 0) {
            System.out.println("Shuma duhet të jetë pozitive!");
        } else {
            bilanci -= shuma;
            System.out.println("Tërheqja u krye me sukses!");
        }
    }

    // Metoda për të parë bilancin
    public void shfaqBilancin() {
        System.out.println("\n--- Bilanci i Llogarisë ---");
        System.out.println("Klienti: " + emri);
        System.out.println("Bilanci aktual: " + bilanci + " Euro");
    }
}

public class SistemiBankar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LlogariaBankare llogaria = null;
        int zgjedhja;
        boolean vazhdo = true;

        System.out.println("Miresevini ne Sistemin Bankar!");

        // Cikli while për të mbajtur programin hapur
        while (vazhdo) {
            System.out.println("\n--- MENUJA ---");
            System.out.println("1 - Krijo llogari");
            System.out.println("2 - Depozito para");
            System.out.println("3 - Tërhiq para");
            System.out.println("4 - Shfaq bilancin");
            System.out.println("5 - Dil nga programi");
            System.out.print("Zgjedhja juaj: ");
            zgjedhja = input.nextInt();

            // Struktura switch për menunë
            switch (zgjedhja) {
                case 1:
                    input.nextLine(); // Pastron buffer-in
                    System.out.print("Shkruani emrin tuaj: ");
                    String emri = input.nextLine();
                    System.out.print("Shkruani shumën fillestare: ");
                    double shuma = input.nextDouble();
                    llogaria = new LlogariaBankare(emri, shuma);
                    System.out.println("Llogaria u krijua me sukses!");
                    break;

                case 2:
                    if (llogaria != null) {
                        System.out.print("Shuma për depozitim: ");
                        double d = input.nextDouble();
                        llogaria.depozito(d);
                    } else {
                        System.out.println("Ju lutem krijoni një llogari fillimisht (Opsioni 1).");
                    }
                    break;

                case 3:
                    if (llogaria != null) {
                        System.out.print("Shuma për tërheqje: ");
                        double t = input.nextDouble();
                        llogaria.terhiq(t);
                    } else {
                        System.out.println("Ju lutem krijoni një llogari fillimisht.");
                    }
                    break;

                case 4:
                    if (llogaria != null) {
                        llogaria.shfaqBilancin();
                    } else {
                        System.out.println("Nuk ka asnjë llogari aktive.");
                    }
                    break;

                case 5:
                    vazhdo = false;
                    System.out.println("Faleminderit që përdorët sistemin tonë. Mirupafshim!");
                    break;

                default:
                    System.out.println("Zgjedhje e gabuar! Provoni përsëri.");
            }
        }
        input.close();
    }
}
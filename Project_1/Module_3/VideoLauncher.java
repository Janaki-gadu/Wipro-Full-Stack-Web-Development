import java.util.Scanner;

public class VideoLauncher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VideoStore store = new VideoStore();

        int choice;

        do {

            System.out.println("\nMAIN MENU");
            System.out.println("=========");
            System.out.println("1. Add Videos");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter the name of the video: ");
                    String add = sc.nextLine();
                    store.addVideo(add);
                    break;

                case 2:
                    System.out.print("Enter the name of the video to checkout: ");
                    String check = sc.nextLine();
                    store.doCheckout(check);
                    break;

                case 3:
                    System.out.print("Enter the name of the video to return: ");
                    String ret = sc.nextLine();
                    store.doReturn(ret);
                    break;

                case 4:
                    System.out.print("Enter the name of the video: ");
                    String rateVideo = sc.nextLine();

                    System.out.print("Enter Rating: ");
                    int rate = sc.nextInt();

                    store.receiveRating(rateVideo, rate);
                    break;

                case 5:
                    store.listInventory();
                    break;

                case 6:
                    System.out.println("Exiting...!! Thanks for using the application.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
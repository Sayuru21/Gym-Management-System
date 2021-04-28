
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsoleUI extends Application {
    private static final MyGymManager manager = new MyGymManager();
    private static int count = 0;
    private static NewDate newDate;
    TableView<GUIData> table;

    public ConsoleUI() {
    }

    public void start(Stage primaryStage) throws Exception {
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter no. 1 for Add a new member.");
                System.out.println("Enter no. 2 for Delete a member.");
                System.out.println("Enter no. 3 for Print the list of members.");
                System.out.println("Enter no. 4 for Save member details.");
                System.out.println("Enter no. 5 for see the list of members.");
                System.out.println("Enter no. 6 for sort and print the list of members.");
                System.out.println("Enter no. \"-2\" for quit. \n");
                System.out.print("Enter your choice : ");
                int yourChoice = scanner.nextInt();
                if (yourChoice == 1) {
                    System.out.println("\n                                 Add new members  \n  ");

                    while(true) {
                        addNewMember();
                        System.out.print("If you want to quit enter \"-1\" : ");
                        int input = scanner.nextInt();
                        System.out.println(" ");
                        if (input == -1) {
                            break;
                        }
                    }
                } else if (yourChoice == 2) {
                    deleteMember();
                    System.out.println("");
                } else if (yourChoice == 3) {
                    manager.printListOfMembers();
                    System.out.println("");
                } else if (yourChoice == 4) {
                    manager.save();
                    System.out.println("");
                } else if (yourChoice == 5) {
                    this.gUI();
                    System.out.println("");
                } else if (yourChoice == 6) {
                    manager.sort();
                    manager.printListOfMembers();
                    System.out.println("");
                } else {
                    if (yourChoice == -2) {
                        return;
                    }

                    System.out.println("Select a valid number \n");
                    System.out.println("-----------------------------------------------------------------");
                }
            } catch (Exception var5) {
                System.out.println("Please enter valid input.\n");
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }

    private static void deleteMember() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Enter the membership number : ");
            String membershipNumber = scanner.next();
            if (membershipNumber.length() == 4) {
                boolean result = manager.deleteAMember(membershipNumber);
                if (result) {
                    --count;
                }

                return;
            }

            System.out.println("Membership number should have 4 digits.");
            System.out.println("-----------------------------------------------------------------");
        }
    }

    private static void addNewMember() {
        Scanner scanner = new Scanner(System.in);
        if (count >= 100) {
            System.out.println("There are no space to members.");
        } else {
            while(true) {
                System.out.print("Enter the membership number : ");
                String membershipNumber = scanner.next();
                if (membershipNumber.length() == 4) {
                    System.out.print("Enter member's name : ");
                    String name = scanner.next();
                    System.out.println("Enter the member's start membership date(YYYY/MM/DD) this format.");
                    String startMembershipDate = null;
                    NewDate var10000 = newDate;
                    String newValidate = NewDate.validate();
                    String type = null;

                    while(true) {
                        System.out.print("Enter the type of membership (D - Default member/ S - Student member/ O - Over 60 member): ");
                        type = scanner.next();
                        if (type.equals("D") || type.equals("d") || type.equals("S") || type.equals("s") || type.equals("O") || type.equals("o")) {
                            DefaultMember member = null;
                            if (!type.equals("D") && !type.equals("d")) {
                                if (!type.equals("S") && !type.equals("s")) {
                                    if (!type.equals("O") && !type.equals("o")) {
                                        System.out.println("Invalid input");
                                        System.out.println("-----------------------------------------------------------------");
                                    } else {
                                        int age = 0;
                                        member = new Over60Member(name, membershipNumber, newValidate, age);
                                        manager.addANewMember(member);
                                    }
                                } else {
                                    System.out.print("School name : ");
                                    String schoolName = scanner.next();
                                    member = new StudentMember(name, membershipNumber, newValidate, schoolName);
                                    manager.addANewMember(member);
                                }
                            } else {
                                member = new DefaultMember(name, membershipNumber, newValidate);
                                manager.addANewMember(member);
                            }

                            ++count;
                            return;
                        }

                        System.out.println("Please select one of above.");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }

                System.out.println("Membership number should have 4 digits.");
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    private void gUI() {
        Stage stage = new Stage();
        stage.setTitle("List of members");
        this.table = new TableView();
        TableColumn<GUIData, String> nameColumn = new TableColumn("Member's name");
        nameColumn.setMinWidth(200.0D);
        nameColumn.setCellValueFactory(new PropertyValueFactory("gUIName"));
        TableColumn<GUIData, String> membershipNumberColumn = new TableColumn("Membership Number");
        membershipNumberColumn.setMinWidth(200.0D);
        membershipNumberColumn.setCellValueFactory(new PropertyValueFactory("gUIMembershipNumber"));
        TableColumn<GUIData, String> membershipTypeColumn = new TableColumn("Membership Type");
        membershipTypeColumn.setMinWidth(200.0D);
        membershipTypeColumn.setCellValueFactory(new PropertyValueFactory("gUIMembershipType"));
        TableColumn<GUIData, String> startMembershipDateColumn = new TableColumn("Start Membership Date");
        startMembershipDateColumn.setMinWidth(200.0D);
        startMembershipDateColumn.setCellValueFactory(new PropertyValueFactory("gUIStartMembershipDate"));
        this.table.setItems(this.getGUIData());
        this.table.getColumns().addAll(new TableColumn[]{nameColumn, membershipNumberColumn, membershipTypeColumn, startMembershipDateColumn});
        new Button();
        VBox vb = new VBox();
        vb.getChildren().add(this.table);
        Scene scene = new Scene(vb);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public ObservableList<GUIData> getGUIData() {
        ObservableList<GUIData> gUIData = FXCollections.observableArrayList();

        gUIData.add(new GUIData("", "","", ""));
        return gUIData;
    }
}

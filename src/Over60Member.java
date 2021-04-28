import java.util.Scanner;

public class Over60Member extends DefaultMember {
    private int age;

    public Over60Member(String name, String membershipNumber, String startMembershipDate, int age) {
        super(name, membershipNumber, startMembershipDate);
        this.setAge(age);
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Age : ");
                int newAge = scanner.nextInt();
                if (newAge >= 60 && newAge <= 100) {
                    this.age = newAge;
                    return;
                }

                System.out.println("Age should be above 60 or below 100.");
                System.out.println("-----------------------------------------------------------------");
            } catch (Exception var4) {
                System.out.println("Age is not valid.");
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }
}

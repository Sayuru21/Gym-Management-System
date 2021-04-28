
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyGymManager implements GymManager {
    private List<DefaultMember> memberList = new ArrayList();
    private DefaultMember member;

    public MyGymManager() {
    }

    public void addANewMember(DefaultMember member) {
        if (this.memberList.size() < 100) {
            this.memberList.add(member);
        } else {
            System.out.println("There are no space for new members.");
        }

        System.out.println("");
        System.out.println("Number of joined members: " + this.memberList.size());
        System.out.println("Number of members can join: " + (100 - this.memberList.size()));
        System.out.println("");
    }

    public boolean deleteAMember(String membershipNumber) {
        boolean indicate = false;
        Iterator var3 = this.memberList.iterator();

        while(var3.hasNext()) {
            DefaultMember member = (DefaultMember)var3.next();
            if (member.getMembershipNumber().equals(membershipNumber)) {
                indicate = true;
                this.memberList.remove(member);
                System.out.println("Membership number " + membershipNumber + " is successfully removed.");
                System.out.println("");
                System.out.println("Number of joined members: " + this.memberList.size());
                System.out.println("Number of members can join: " + (100 - this.memberList.size()));
                if (member instanceof StudentMember) {
                    System.out.println("Membership type : Student member");
                } else if (member instanceof Over60Member) {
                    System.out.println("Membership type : Over 60 member");
                } else {
                    System.out.println("Membership type : Default member");
                }

                System.out.println("");
                break;
            }
        }

        if (!indicate) {
            System.out.println("Not found");
        }

        return indicate;
    }

    public void printListOfMembers() {
        Iterator var1 = this.memberList.iterator();

        while(var1.hasNext()) {
            DefaultMember member = (DefaultMember)var1.next();
            System.out.println("Membership Number : " + member.getMembershipNumber() + " ");
            if (member instanceof StudentMember) {
                System.out.println("Membership type : Student member");
            } else if (member instanceof Over60Member) {
                System.out.println("Membership type : Over 60 member");
            } else {
                System.out.println("Membership type : Default member");
            }

            System.out.println("Name is : " + member.getName() + " ");
            System.out.println("Start date of membership is : " + member.getStartMembershipDate());
            System.out.println("");
        }

        if (this.memberList.size() == 0) {
            System.out.println("Empty list");
        }

    }

    public void sort() {
        Collections.sort(this.memberList);
    }

    public void save() throws FileNotFoundException {
        if (this.memberList.size() != 0) {
            PrintWriter writer = new PrintWriter("Details of members.txt");
            Iterator var2 = this.memberList.iterator();

            while(var2.hasNext()) {
                DefaultMember member = (DefaultMember)var2.next();
                writer.println("Membership Number : " + member.getMembershipNumber() + " ");
                if (member instanceof StudentMember) {
                    writer.println("Membership type : Student member");
                } else if (member instanceof Over60Member) {
                    writer.println("Membership type : Over 60 member");
                } else {
                    writer.println("Membership type : Default member");
                }

                writer.println("Name is : " + member.getName() + " ");
                writer.println("Start date of membership is : " + member.getStartMembershipDate());
                System.out.println("");
            }

            writer.flush();
            writer.close();
        } else {
            System.out.println("Empty list nothing to save.");
            System.out.println("-----------------------------------------------------------------");
        }

    }

    public List<DefaultMember> getMemberList() {
        return this.memberList;
    }

    public DefaultMember getMemberByMembershipNumber(String membershipNumber) {
        return null;
    }

    public DefaultMember[] getMemberByName(String name) {
        return new DefaultMember[0];
    }
}

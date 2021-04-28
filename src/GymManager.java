import java.io.FileNotFoundException;
import java.util.List;

public interface GymManager {
    void addANewMember(DefaultMember var1);

    boolean deleteAMember(String var1);

    void printListOfMembers();

    void sort();

    void save() throws FileNotFoundException;

    List<DefaultMember> getMemberList();

    DefaultMember getMemberByMembershipNumber(String var1);

    DefaultMember[] getMemberByName(String var1);
}

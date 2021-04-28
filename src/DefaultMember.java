public class DefaultMember implements Comparable<DefaultMember> {
    private String name;
    private String membershipNumber;
    private String startMembershipDate;

    public DefaultMember(String name, String membershipNumber, String startMembershipDate) {
        this.name = name;
        this.membershipNumber = membershipNumber;
        this.startMembershipDate = startMembershipDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipNumber() {
        return this.membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getStartMembershipDate() {
        return this.startMembershipDate;
    }

    public void setStartMembershipDate(String startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    public int compareTo(DefaultMember other) {
        int compareInt = this.name.compareTo(other.name);
        if (compareInt < 0) {
            return -1;
        } else {
            return compareInt > 0 ? 1 : 0;
        }
    }
}

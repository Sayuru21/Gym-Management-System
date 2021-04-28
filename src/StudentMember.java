public class StudentMember extends DefaultMember {
    private String schoolName;

    public StudentMember(String name, String membershipNumber, String startMembershipDate, String schoolName) {
        super(name, membershipNumber, startMembershipDate);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}

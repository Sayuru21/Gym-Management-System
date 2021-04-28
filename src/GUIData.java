public class GUIData {
    private String gUIName;
    private String gUIMembershipType;
    private String gUIMembershipNumber;
    private String gUIStartMembershipDate;

    public GUIData() {
        this.gUIName = "";
        this.gUIMembershipType = "";
        this.gUIMembershipNumber = "";
        this.gUIStartMembershipDate = "";
    }

    public GUIData(String gUIName, String gUIMembershipType, String gUIMembershipNumber, String gUIStartMembershipDate) {
        this.gUIName = gUIName;
        this.gUIMembershipType = gUIMembershipType;
        this.gUIMembershipNumber = gUIMembershipNumber;
        this.gUIStartMembershipDate = gUIStartMembershipDate;
    }

    public String getGUIName() {
        return this.gUIName;
    }

    public void setGUIName(String gUIName) {
        this.gUIName = gUIName;
    }

    public String getGUIMembershipType() {
        return this.gUIMembershipType;
    }

    public void setGUIMembershipType(String gUIMembershipType) {
        this.gUIMembershipType = gUIMembershipType;
    }

    public String getGUIMembershipNumber() {
        return this.gUIMembershipNumber;
    }

    public void setGUIMembershipNumber(String gUIMembershipNumber) {
        this.gUIMembershipNumber = gUIMembershipNumber;
    }

    public String getGUIStartMembershipDate() {
        return this.gUIStartMembershipDate;
    }

    public void setGUIStartMembershipDate(String gUIStartMembershipDate) {
        this.gUIStartMembershipDate = gUIStartMembershipDate;
    }
}

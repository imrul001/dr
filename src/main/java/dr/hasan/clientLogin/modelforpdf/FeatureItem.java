package dr.hasan.clientLogin.modelforpdf;

public class FeatureItem {
    private long id;

    private String name;

    private int type;

    private char isPrivilege;

    private char isTransactional;

    private char showInMenu;

    private long featureParentId;

    private char isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public char getIsPrivilege() {
        return isPrivilege;
    }

    public void setIsPrivilege(char isPrivilege) {
        this.isPrivilege = isPrivilege;
    }

    public char getIsTransactional() {
        return isTransactional;
    }

    public void setIsTransactional(char isTransactional) {
        this.isTransactional = isTransactional;
    }

    public char getShowInMenu() {
        return showInMenu;
    }

    public void setShowInMenu(char showInMenu) {
        this.showInMenu = showInMenu;
    }

    public long getFeatureParentId() {
        return featureParentId;
    }

    public void setFeatureParentId(long featureParentId) {
        this.featureParentId = featureParentId;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }
}

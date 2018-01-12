package dr.hasan.clientLogin.modelforpdf;

public class CustomerMenuEntity{
    private int id;
    private int featureItemId;
    private String menuCode;
    private String menuText;
    private String menuUrl;
    private int parentID;
    private char hasSub;
    private char showInUserMenu;
    private char isActive;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public char getHasSub() {
        return hasSub;
    }

    public void setHasSub(char hasSub) {
        this.hasSub = hasSub;
    }


    public int getFeatureItemId() {
        return featureItemId;
    }

    public void setFeatureItemId(int featureItemId) {
        this.featureItemId = featureItemId;
    }

    public char getShowInUserMenu() {
        return showInUserMenu;
    }

    public void setShowInUserMenu(char showInUserMenu) {
        this.showInUserMenu = showInUserMenu;
    }

    public char getIsActive() {
        return isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

}

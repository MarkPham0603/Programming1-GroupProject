/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Pham Minh Hoa,Chau The Kien
  ID: s3929256, s3790421
  Acknowledgement: Tom huynh https://github.com/TomHuynhSG/COSC2081-Lab-Solutions
                   My old project https://github.com/Devtorious/Programming-1
*/
public class OrderForm {

    private String ID, Cname, Cphone, Pname, Pcategory, status;
    private double Pprice;

    public OrderForm(String ID, String cname, String cphone, String pname, String pcategory, String status, double pprice) {
        this.ID = ID;
        Cname = cname;
        Cphone = cphone;
        Pname = pname;
        Pcategory = pcategory;
        this.status = status;
        Pprice = pprice;
    }

    @Override
    public String toString() {
        return ID + "," + Cname + "," + Cphone + "," + Pname + "," + Pcategory + "," + status + "," + Pprice;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCphone() {
        return Cphone;
    }

    public void setCphone(String cphone) {
        Cphone = cphone;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPcategory() {
        return Pcategory;
    }

    public void setPcategory(String pcategory) {
        Pcategory = pcategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPprice() {
        return Pprice;
    }

    public void setPprice(double pprice) {
        Pprice = pprice;
    }
}

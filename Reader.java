/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleForTest;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author NGOC TY
 */
public class Reader extends Book implements Serializable{//muốn đọc ghi file theo kiểu đối tượng Reader thì phải implements serilizable
    private int readerID;//xxxxxxxx
    private String fullName;
    private String address;
    private String phoneNumber;
    
    public int getReaderID() {
        return readerID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void input(){
        Scanner scan=new Scanner(System.in);
        System.out.println("readerID: "+ readerID);
        System.out.printf("fullName: ");
        this.fullName=scan.nextLine();
        System.out.printf("address: ");
        this.address=scan.nextLine();
        System.out.printf("phoneNumber: ");
        this.phoneNumber=scan.nextLine();
    }

    @Override
    public String toString() {
        return "Reader{" + "readerID=" + readerID + ", fullName=" + fullName + ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }

    
}
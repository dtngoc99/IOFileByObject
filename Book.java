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
public class Book implements Serializable{//muốn đọc ghi file theo kiểu đối tượng Book thì phải implements serilizable
    private int bookID;//xxxxxx
    private String bookName;
    private String author;
    private String specialization;//đầu sách
    private int publishYear;
    private int quantity;
    private String note;
    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public void input(){
        Scanner scan=new Scanner(System.in);
        System.out.println("bookID: "+bookID);
        System.out.printf("bookName: ");
        this.bookName=scan.nextLine();
        System.out.printf("author: ");
        this.author=scan.nextLine();
        System.out.printf("specialization(Science,Art,Economic,IT): ");
        this.specialization=scan.nextLine();
        System.out.printf("publishYear(ex:1994): ");
        this.publishYear=scan.nextInt();
        System.out.printf("quantity: " );
        this.quantity=scan.nextInt();
        System.out.printf("Note: ");
        scan.nextLine();
        this.note=scan.nextLine();
    }

    @Override
    public String toString() {
        return "Book{" + "bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", specialization=" + specialization + ", publishYear=" + publishYear + ", quantity=" + quantity + ", note=" + note + '}';
    }



    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleForTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author NGOC TY
 */
public class Management {
    ArrayList<Reader> listReader=new ArrayList<>();//danh sách thành viên
    ArrayList<Book> listBook=new ArrayList<>();//danh sách các quyển sách trong kho
    ArrayList<BookReaderManagement> listBookBorrow=new ArrayList<>();
    IOFile file=new IOFile();
    private Boolean check;
    public void readFile(){
        listReader=file.readList("listReader.DAT");
        listBook=file.readList("listBook.DAT"); 
        listBookBorrow=file.readList("listBookBorrow.DAT");
    }
    public void writeFile(){
        file.writeList(listBook, "listBook.DAT");
        file.writeList(listReader,"listReader.DAT");
        file.writeList(listBookBorrow, "listBookBorrow.DAT");
    }
    public void borrowBook(){
        int readerID;
        int bookID;
        Scanner scan=new Scanner(System.in);
        BookReaderManagement br=new BookReaderManagement();
        Boolean ch=false;
        do{
            System.out.printf("readerID(xxxxxxxx): ");
            readerID=scan.nextInt();
            for(Reader re: listReader){
                if(readerID==re.getReaderID()){
                    ch=true;
                    br.setReaderID(readerID);
                    br.setFullName(re.getFullName());
                    br.setAddress(re.getAddress());
                    br.setPhoneNumber(re.getPhoneNumber());
                    break;
                }
            }
        }
        while(ch==false);
        ch=false;
        do{
            System.out.printf("bookID(xxxxxx): ");
            bookID=scan.nextInt();
            for(Book bo: listBook){
                if(bookID==bo.getBookID()){
                    br.setBookID(bo.getBookID());
                    br.setBookName(bo.getBookName());
                    br.setAuthor(bo.getAuthor());
                    br.setSpecialization(bo.getSpecialization());
                    br.setPublishYear(bo.getPublishYear());
                    ch=true;
                    break;
                }
            }
        }
        while(ch==false);
        System.out.printf("quantity: ");
        br.setQuantity(scan.nextInt());
        System.out.printf("Note: ");
        scan.nextLine();
        br.setNote(scan.nextLine());
        listBookBorrow.add(br);
    }
    public void addReader(){
        Reader read=new Reader();
        if(listReader.isEmpty()){
            read.setReaderID(10000000);
        }
        else{
            read.setReaderID(listReader.get(listReader.size()-1).getReaderID()+1);
        }
        read.input();
        listReader.add(read);
    }
    public void addBook(){
        Book book=new Book();
        if(listBook.isEmpty()){
            book.setBookID(100000);
        }
        else{
            book.setBookID(listBook.get(listBook.size()-1).getBookID()+1);
        }
        book.input();
        listBook.add(book);
    }
    public void showListBook(){
        listBook.forEach((bo) -> {
            System.out.println(bo.toString());
        });

    }
    public void showListReader(){
        listReader.forEach((re) -> {
            System.out.println(re.toString());
        });
    }
    public void showReaderBook(){
        listReader.forEach((re)->{
            check=false;
            listBookBorrow.forEach((br)->{
                if(re.getReaderID()==br.getReaderID()){
                    if(check==false){
                        System.out.println(re.toString());
                        check=true;
                    }
                    System.out.println("\t"+br.toString());
                }
                
            });    
        });

    }
    public void sortByQuantity(){
        
    }
    
    public void menu(){
        readFile();
        while(true){
            int choice;
            Scanner scan=new Scanner(System.in);
            System.out.println("\t\t0.Exit");
            System.out.println("\t\t1.Add Book");
            System.out.println("\t\t2.Show List Book");
            System.out.println("\t\t3.Add Reader");
            System.out.println("\t\t4.Show List Reader");
            System.out.println("\t\t5.Borrow Book");
            System.out.println("\t\t6.Show List Reader and Books borrowed");
            System.out.println("\t\t7.Sort by ReaderName on listBookBorrow");
            System.out.println("\t\t8.Sort descending by number on listBookBorrow");
            System.out.println("\t\t9.Search and Show by Reader on listBookBorrow");
            System.out.printf("\tInput choice: ");
            choice=scan.nextInt();
            switch(choice){
                case 0:
                    writeFile();
                    return;
                case 1:
                    addBook();
                    break;
                case 2:
                    showListBook();
                    break;
                case 3:
                    addReader();
                    break;
                case 4:
                    showListReader();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    showReaderBook();
                    break;
                case 7:
                    Collections.sort(listBookBorrow,BookReaderManagement.compare);
                    for(BookReaderManagement b:listBookBorrow){
                        System.out.println("readerID= "+b.getReaderID()+",readerName= "+b.getFullName()+"\n\tbookID= "+b.getBookID()+",booName= "+b.getBookName()+",quantity= "+b.getQuantity()+",Note= "+b.getNote());
                    }
                    break;
                case 8:
                    break;
                case 9:
                    String readerName;
                    System.out.printf("readerName= ");
                    scan.nextLine();
                    readerName=scan.nextLine();
                    for(BookReaderManagement b:listBookBorrow){
                        if(b.getFullName().equals(readerName)){
                            System.out.println("readerID= "+b.getReaderID()+",readerName: "+b.getFullName()+"\n\tbookID= "+b.getBookID()+",bookName= "+b.getBookName()+",quantity= "+b.getQuantity()+",note: "+b.getNote());
                        }
                    }
                    break;
                default:
                    writeFile();
                    return;
            }
            
        }
        
    }    
}

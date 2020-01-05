/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleForTest;

import java.util.Comparator;



/**
 *
 * @author NGOC TY
 */
public class BookReaderManagement extends Reader{
    @Override
    public String toString(){
        return "bookID: "+this.getBookID()+",bookName: "+this.getBookName()+",quantity: "+this.getQuantity()+",note: "+this.getNote();
    }
    public static Comparator<BookReaderManagement> compare=new Comparator<BookReaderManagement>(){
        @Override
        public int compare(BookReaderManagement o1, BookReaderManagement o2) {
            return o1.getFullName().compareTo(o2.getFullName());
        }

    };

}

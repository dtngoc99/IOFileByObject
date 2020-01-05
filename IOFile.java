/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleForTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author NGOC TY
 */
public class IOFile {
    public void writeList(ArrayList list,String fileName){
        try (FileOutputStream fos=new FileOutputStream(new File(fileName))){
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("got an exception in write data out file");
        }
    }
    public ArrayList readList(String fileName){
        ArrayList list=new ArrayList();
        try(FileInputStream fos=new FileInputStream(new File(fileName))) {
            ObjectInputStream ois=new ObjectInputStream(fos);
            list=(ArrayList)ois.readObject();
        } catch (Exception e) {
            System.out.println("got an exception in read data from file");
        }
        return list;
    }
}

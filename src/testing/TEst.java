/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author vijay
 */
public class TEst {
    public static void main(String[] args)throws IOException {
        String value;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Any Email : ");
        value= reader.readLine();
       if(value.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z-0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
              System.out.println("Valid Email");
          }else{
              System.out.println("Invalid Email please right in correct order.");
          }
    }
}

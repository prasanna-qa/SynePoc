package org.sync.qa.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExp {

	public static void main(String[] args) {

String s[]={"Komal","Ram","Mohan","Kushal","Manohar"};
Predicate<String> p=str->(str.charAt(0)=='k') || (str.charAt(0)=='K') ;
for(String x : s){
if(p.test(x)){
	System.out.println(x);
}
}

int x[]={0,5,10,15,20,25};
String str[]= {"abc","def","fgh"};

Predicate<Integer> p1=i->i>10;
Predicate<Integer> p2=   i->i%2==0;
Predicate<String> p3=m->m.contains("a");


System.out.println("The numbers greater than 10");
m1(p1,x);
System.out.println("The numbers which are even");
m1(p2,x);

System.out.println("The numbers which are not greater than 10:");
m1(p1.negate(),x);

System.out.println("The nubmers which are greater than 10 and even");
m1(p1.and(p2),x);

System.out.println("The numbers which are greate than 10 or even");
m1(p1.or(p2),x);

System.out.println("The String containing a");
m2(p3,str);

//predefined
Predicate<String> pre=Predicate.isEqual("RajaRam");
//System.out.println(pre.test("RajaRam"));
System.out.println(pre.test("RamRam"));

//Function interface

Function<String,Integer> f1=st->st.length();
System.out.println(f1.apply("prasanna"));

Function<Integer,Integer> f2=o->o*o;
System.out.println(f2.apply(9));

String str3="I will be master in JAVA8 after this training";
Function<String,Boolean> f4=strr->strr.contains("master");
System.out.println(f4.apply(str3));

//Function chaning
//f1.andThen(f2)
//f1.compose(f1)


Function<Integer, Integer> f11=i->i*i;
Function<Integer,Integer> f21= i-> i + i;

System.out.println("square of 2  ="+f11.apply(21));
System.out.println("Addition of its own number ="+f2.apply(2));

System.out.println(f11.andThen(f21).apply(2));  //8
System.out.println(f11.compose(f21).apply(2)); //16

//Consumer
 //Consumer<String> c1=str->System.out.println(str.);
 Consumer<String> c2=strrr->System.out.println("Length of a string is "+strrr.length());
 c2.accept("prasannakumar");
	



	}
	
	
	public static void m2(Predicate<String> p, String x[]){
		for(String x1 : x){
			if(p.test(x1)){
				System.out.println(x1);
			}
		}
	}

public static void m1(Predicate<Integer> p, int x[]){
	for(int x1 : x){
		if(p.test(x1)){
			System.out.println(x1);
		}
	}
}}
//p1: Given number is Greater than 10?
	//p2: is Even number?
	
	
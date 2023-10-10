package org.myproject;

import org.testng.annotations.Test;

public class Sample {


@Test(enabled=false)
private void tc1() 
{
	System.out.println("Hi");
}
@Test
private void tc3() {
System.out.println("Test Case 3");

}

@Test
private void tc2() {
System.out.println("Test Case 2");

}


}

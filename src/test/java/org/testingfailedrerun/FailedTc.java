package org.testingfailedrerun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailedTc implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation r,
			Class testClass, Constructor testConstructor, Method testMethod) { 
		  
		IRetryAnalyzer res= r.getRetryAnalyzer();
		if(res==null)
		{
			r.setRetryAnalyzer(Rerun.class);
		}
		
	}

}

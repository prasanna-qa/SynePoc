package org.sync.qa.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.sync.qa.helpers.RetryAnalyser;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class AnnotationTransform implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyser.class);
		
	}
	

}

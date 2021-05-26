package jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

public class LoadClassDemo extends ClassLoader{
	
	public static void main(String[] args){
		try {
			Class a = new LoadClassDemo().findClass("Hello");
			Object o = a.newInstance();
			Method[] m = a.getDeclaredMethods();
			for(int i=0;i<m.length;i++) {
				try {
					m[i].invoke(o, null);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			Class c= new LoadClassDemo().findClassForFile("Hello");
//			c.getDeclaredMethod("hello", null).invoke(c.newInstance(), null);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	//Base64
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classStr = "NQFFQf///8v/4/X/+f/x9v/w/+/3/+71/+3/7Pj/6/j/6v7/+cOWkZaLwf7//NfWqf7/+7yQm5r+//CzlpGasYqSnZqNq56dk5r+//qXmpOTkP7/9ayQio2cmrmWk5r+//W3mpOTkNGVnome8//4//f4/+nz/+j/5/7/7Leak5OQ09+ck56MjLOQnpuajd74/+bz/+X/5P7/+reak5OQ/v/vlZ6JntCTnpGY0LCdlZqci/7/75WeiZ7Qk56RmNCshoyLmpL+//yQiov+/+qzlZ6JntCWkNCvjZaRi6yLjZqeksT+/+yVnome0JaQ0K+NlpGLrIuNmp6S/v/4j42WkYuTkf7/6tezlZ6JntCTnpGY0KyLjZaRmMTWqf/e//r/+f///////f/+//j/9//+//b////i//7//v////rVSP/+Tv////7/9f////n//v////7//v/0//f//v/2////2v/9//7////2Tf/97fxJ//tO/////v/1////9f/9////+//3//r//v/z/////f/y";
		byte[] bytes = decode(classStr);
		return getBytes(bytes,name);
	}
	
	public Class<?> getBytes(byte[] bytes,String name) {
		for(int i=0;i<bytes.length;i++){
			bytes[i]=(byte) (0xff-bytes[i]); //0xff或255
		}
		return defineClass(name,bytes,0,bytes.length);
	}
	
	public byte[] decode(String classStr){
		return Base64.getDecoder().decode(classStr);
	}

	//读取文件
	public Class<?> findClassForFile(String name) throws FileNotFoundException {
		File f = new File("src/jvm/Hello.xlass");
		long fileSize = f.length();
		FileInputStream fis = new FileInputStream(f);
		byte[] buffer = new byte[(int)fileSize];
		int offset = 0;
		int readnum = 0;
		try {
			while(offset < buffer.length&& (readnum = fis.read(buffer, offset, buffer.length - offset)) >= 0 ) {
				offset += readnum;
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getBytes(buffer,name);
	}
	
}
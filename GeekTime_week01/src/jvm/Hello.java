package jvm;

public class Hello {

  public static void main(String[] args) {
	int num1 = 1;
	double num2 = 2.0D;
	long num3 = 3l;
	byte num4 = 4;
	for (int i = 0; i < num1; i++) {
		System.out.println("四则运算 num1*num3=" + (num1*num3));
	}
	if(num4 < 10) {
		System.out.println("运算 num2+num4=" +(num2+num4));
	}
}

}
package ql.geekTime.atomic;

public class Count {

    private int num=0;

    public  int add(){
        return num++;
    }

    public int getNum(){
        return num;
    }
}

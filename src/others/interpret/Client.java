package cn.edu.bnuz.interpret;

import java.util.SortedMap;

public class Client {
//    解释器模式——四则表达式
//    表达式a*b+c/10-d，其中 a=b,b=3,c=3,d=9
//    变量|常量|加|减|乘|除|开方|乘方
public static void main(String[] args) {
    IExpress constant=  new Constant(10.0);//定义常量
    Variable variable=new Variable("A");//定义变量
//////    变量赋值
    Context context=new Context();
    context.assign(variable,5.0);
//
    Variable variable2=new Variable("B");//定义变量
    context.assign(variable2,3.0);
////
//////a*b
    IExpress multuply =new Multiply(variable,variable2);
    double m=multuply.interpret(context);
//    System.out.println(m);
////    c/10
    Variable variable3=new Variable("C");
    context.assign(variable3,3.0);
    IExpress divide=new Divide(variable3,constant);
//
////加法表达式
    IExpress plus=new Plus(multuply,divide);
////减法表达式
    Variable variable4=new Variable("D");
    context.assign(variable4,9.0);
    IExpress minus=new Minus(plus,variable4);
    double result=minus.interpret(context);
    System.out.println(result);
//开方表达式
    Variable variable5=new Variable("E");
    context.assign(variable5,9.0);
    IExpress prescribing=new Prescribing(variable5);
    double rp=prescribing.interpret(context);
    System.out.println(rp);
//    乘方运算符
    Variable variable6=new Variable("F");
    context.assign(variable6,3);
    IExpress power=new Power(variable3,variable6);
    double rpp=prescribing.interpret(context);
    System.out.println(rpp);
}


}

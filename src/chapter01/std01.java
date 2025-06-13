package chapter01;

public class std01 {
    /*
    ★final修飾子★
    final修飾子は、クラス・メソッド・変数に適用できる
    クラス：    final指定されたクラスを元にサブクラスを作ることができない
    メソッド：  final指定されたメソッドを、サブクラス側でオーバーライドできない
    変数：     final指定された変数は、定数となる
    * */
}

// final class================================================
final class test {
    public void text() {
        System.out.println("this is final class text!!");
    }
}

//これはfinal指定されたclassを継承しようとしているのでエラーになる
//class testA extends test {}
//=============================================================


//final method=================================================
class testB {
    final public void text() {
        System.out.println("this is final method text!!");
    }
}

//testBを継承してtextメソッドをオーバーライドしようとしたがfinal指定のあるメソッドのためエラーになる
class testC extends  testB {
//    public void text(){
//        System.out.println("this not override. this method is final");
//    }
}
//==============================================================


//final 変数===================================================
class testD {
    final String name = "angel"; //ここでfinal指定され定数となる

    //定数なので値を変更できないのにしようとしているためエラー
    // String name = "ren";
}

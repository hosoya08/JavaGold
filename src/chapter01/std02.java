package chapter01;

public class std02 {
    /*
    * # static修飾子
    * 　変数宣言にてstatic指定するとstatic変数として扱われる
    * 　メソッドにてstatic指定するとstaticメソッドとして扱われる
    *
    * ## staticを指定できるものは
    * 　・変数
    * 　・メソッド
    * ## staticを指定できないのは
    * 　・class
    * 　・コンストラクタ
    *
    * ## 呼び方
    * 　static変数　→　クラス変数
    * 　staticメソッド　→　クラスメソッド
    *
    * ## 保持
    * 　static指定されたものはインスタンス化されたクラスに影響をうけない。
    * 　クラスに保持されておらず、別の箇所にまとまって用意されている
    *
    * ## 呼び出し
    * 　staticメンバは1箇所にまとめられているため、インスタンス化しなくても呼び出すことができる。
    * 　「クラス名.static変数」、「クラス名.staticメソッド」という感じで呼び出す
    * 　
    * 　インスタンス化して呼び出す場合以下のように呼び出すことが可能
    * 「参照変数.staticメンバ名」
    *
    * ## インスタンスメンバとstaticメンバのクラス内でのアクセス（ルール）
    * 　・クラス内で定義した、インスタンスメンバ同士、staticメンバ同士は直接アクセス可能
    * 　・クラス内で定義した、インスタンスメンバはstaticメンバに直接アクセス可能
    * 　・クラス内で定義した、staticメンバはインスタンスメンバに直接アクセスは不可能
    * 　　アクセスする場合は一度インスタンス化すれば可能となる
    * 　
    * ## nullに対するstaticメンバ呼び出し
    * 　 88行目以降に記載
    * */
}

class testA {
    static String name = "hosoya"; // static変数 ・ クラス変数
    static public void txt() { // staticメソッド・クラスメソッド
        System.out.println("this is static method");

//        System.out.println(testA2.name); // 非staticのメンバをstaticから参照することはできない
//        testA2.text(); // 非staticをstatic側からは参照できない

    }
}

class testA2 {
    String name = "hosoya";
    public void text(){
        System.out.println("this is method");
        //static変数呼びし。非static は　staticへアクセス可能
        System.out.println("this is static変数：" + testA.name);
        //static methodの呼び出し。　非static は　staticへアクセス可能
        testA.txt();
    }
}

// static をインスタンス化して呼び出す際の呼び出し方
class std01A {
    testA tA = new testA();

    public void youName(){
        System.out.println("this name is : " + tA.name);
    }
}


class std01B {
    static public void staticMethod() {
        System.out.println("this is static method");
        // System.out.println("this name is : " + testA2.name); //これは非staticなので参照不可

        // staticメンバから非staticへアクセスしたい場合、一度インスタンス化する
        testA2 ta2 = new testA2();

        // インスタンス化したら問題なく、インスタンスメンバを呼び出すことができる
        System.out.println("this name is : " + ta2.name); //これは非staticなので参照不可

    }
}

// nullのときの説明
class std01C {
    static String staticValue = "static value";
    String instanceValue = "instance value";

    public void textValue() {
        std01C s = null;
        System.out.println(staticValue); // static value
        System.out.println(instanceValue); // NullPointerException
    }
     /*
         上記の出力結果：
         static value
         Exception in thread "main" java.lang.NullPointerException

         ■説明
         インスタンスメンバとstaticメンバの保持領域は別物でstaticメンバは
         クラスが読み込まれさえすれば、nullであってもstaticの領域から
         呼び出せるのでNullPointerExceptionにはならないため上記のような結果となる
     * */

}

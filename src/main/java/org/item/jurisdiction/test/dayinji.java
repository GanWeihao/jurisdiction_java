package org.item.jurisdiction.test;

public class dayinji {
    public void yin(zhi z, mohe mo){
        System.out.println("我正在打印");
        z.write();
        mo.dayin();
    }

    public static void main(String [] arg0){
        dayinji dyj = new dayinji();
        dyj.yin(new a3(),new heibai());
    }
}

class zhi{
    public void write(){
        System.out.println("我是纸");
    }
}
class a3 extends zhi{
    @Override
    public void write(){
        System.out.println("我是A3纸");
    }
}
class a4 extends zhi{
    @Override
    public void write(){
        System.out.println("我是A4纸");
    }
}
class mohe {
    public void dayin(){
        System.out.println("我是墨盒");
    }
}
class caise extends mohe{
    @Override
    public void dayin(){
        System.out.println("我是彩色墨盒");
    }
}
class heibai extends mohe{
    @Override
    public void dayin(){
        System.out.println("我是黑白墨盒");
    }
}


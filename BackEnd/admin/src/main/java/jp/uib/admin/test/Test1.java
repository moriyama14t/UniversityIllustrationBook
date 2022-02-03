package jp.uib.admin.test;

public class Test1 {

    // 車種名
    public String carName;

    // 燃料
    public int fuel;

    // 給油
    public void oiling() {
        this.fuel = 80;
        System.out.print(this.carName + "はガソリンスタンドで給油をした");
    }

    // 走行距離
    public void destance(int km) {

        // 1kmで消費する燃料
        int num = km / 10;

        // 給油した燃料から消費した燃料を算出
        this.fuel -= num;

        System.out.println(km + "km走って" + num + "Lのガソリンを消費した");
        System.out.println("残りの燃料は" + this.fuel + "Lです。");
    }
}

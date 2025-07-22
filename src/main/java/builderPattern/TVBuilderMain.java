package builderPattern;

public class TVBuilderMain {
    public static void main(String[] args) {
        TVBuilder tv1 = new TVBuilder.Builder(2160, 4).hdmiCount(4).refreshRate(144).build();
        TVBuilder tv2 = new TVBuilder.Builder(4096, 6).hdmiCount(6).refreshRate(167).channelCount(5).build();
        TVBuilder tv3 = new TVBuilder.Builder(1024, 2).hdmiCount(2).build();

        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
    }
}

import java.util.Arrays;
import java.util.Random;

public class Target {
    private int[] coordinates;
    private boolean isBeingHit;

    public Target() {
        Random random = new Random();
        this.coordinates = new int[]{random.nextInt(5), random.nextInt(5)};
//        System.out.println(Arrays.toString(this.coordinates));
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public boolean getIsBeingHit() {
        return isBeingHit;
    }

    public void setBeingHit(boolean beingHit) {
        isBeingHit = beingHit;
    }
}

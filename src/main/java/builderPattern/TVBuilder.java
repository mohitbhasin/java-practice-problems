package builderPattern;

public class TVBuilder {
    private final int pixelCount;
    private final int speakerCount;
    private final int channelCount;
    private final int hdmiCount;
    private final int refreshRate;

    public static class Builder {
        private final int pixelCount;
        private final int speakerCount;

        private int channelCount;
        private int hdmiCount;
        private int refreshRate;

        public Builder(int pixelCount, int speakerCount) {
            this.pixelCount = pixelCount;
            this.speakerCount = speakerCount;
        }
        public Builder channelCount(int val) {
            this.channelCount = val;
            return this;
        }
        public Builder hdmiCount(int val) {
            this.hdmiCount = val;
            return this;
        }
        public Builder refreshRate(int val) {
            this.refreshRate = val;
            return this;
        }

        public TVBuilder build() {
            return new TVBuilder(this);
        }
    }

    public TVBuilder(Builder builder) {
        this.pixelCount = builder.pixelCount;
        this.speakerCount = builder.speakerCount;
        this.channelCount = builder.channelCount;
        this.hdmiCount = builder.hdmiCount;
        this.refreshRate = builder.refreshRate;
    }

    @Override
    public String toString() {
        return "TVBuilder{" +
                "pixelCount=" + pixelCount +
                ", speakerCount=" + speakerCount +
                ", channelCount=" + channelCount +
                ", hdmiCount=" + hdmiCount +
                ", refreshRate=" + refreshRate +
                '}';
    }
}

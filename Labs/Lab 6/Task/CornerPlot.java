public class CornerPlot extends Plot {

    private double width;
    private double depth;
    private final double CORNER_PREMIUM_RATE = 0.08;

 CornerPlot(int streetNo, int houseNo, PlotShape shape, PlotType plotType,
                      String blockName, String housingSocietyName, String cityName,
                      double width, double depth) {
        super(streetNo, houseNo, shape, plotType, blockName, housingSocietyName, cityName);
        this.width = width;
        this.depth = depth;
        setPrice();
    }

CornerPlot(int streetNo, int houseNo, PlotShape shape, PlotType plotType,
                      String blockName, String housingSocietyName, String cityName) {
        super(streetNo, houseNo, shape, plotType, blockName, housingSocietyName, cityName);
        setPrice();
    }

    CornerPlot() {}



    public double calculateArea() {
        return super.calculateArea() + (width * depth);
    }

    @Override
    public double getPrice() {
        double basePrice = this.getPlotType().getBasePrice();
        return basePrice + (CORNER_PREMIUM_RATE * basePrice);
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }
}

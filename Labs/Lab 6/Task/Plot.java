public class Plot {
    private String plotID;
    private PlotType  type;
    private PlotShape shape;

   
    private double width;
    private double depth;
    private double front;
    private double back;

    private double area;
    private double price;
    private boolean isAvailable;


    public Plot(String id, PlotType type, ShapeType shape, double width, double depth, double front, double back) 
{

        this.plotID = id;
        this.type = type;
        this.shape = shape;
        this.width = width;
        this.depth = depth;
        this.front = front;
        this.back = back;
             
    }

public enum PlotShape {	
	RECTANGLE(15, 7), TRAPEZOID(12, 7, 15), L_SHAPE(10, 5, 5, 3);

	private double width;
	private double depth;
	private double front;
	private double back;
	private double SecondWidth;
	private double SecondDepth;

//Rectangle Plot
	PlotShape(double width, double depth) {
		this.width = width;
		this.depth = depth;
	}
// Trapozoid Plot
       PlotShape(double front, double back, double depth) {
		this.front = front;
		this.back = back;
		this.depth = depth;
	}
//L-Shape Plot
 PlotShape(double width, double depth, double SecondWidth, double  SecondDepth) {
		this.width = width; 
		this.depth = depth;
		this.SecondWidth = SecondWidth;
		this. SecondDepth =  SecondDepth;
	}

	public double calArea(PlotShape shape) {
		double area = 0;

		if (shape == PlotShape.RECTANGLE)
			area = this.width * this.depth;

		else if (shape == PlotShape.TRAPEZOID)
			area = ((this.front + this.back) / 2) * this.depth;

		else
			area = (this.width * this.depth) + (this.SecondWidth * this. SecondDepth);

		return area;
	}
}

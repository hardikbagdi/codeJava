import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
  
	private Point[] points;
	private LineSegment[] answer;
	private int numberOfSegments;
	public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
   {
	   if (points==null) {
		throw new NullPointerException();
	}
	   else
	   {
		   for(int i=0;i<points.length;i++){
			   if(points[i]==null)
			   throw new NullPointerException();
		   }
				   
	   }
	   
	   for (int i = 0; i < points.length; i++) {
		 for (int j = i+1; j < points.length; j++) {
			if(points[i].compareTo(points[j])==0)
				{StdOut.println(points[i]);
			StdOut.println(points[j]);
				throw new IllegalArgumentException();
				}
		}
	}
	   
	   this.points = points;
	   //compute();
   }
	
	   
	   
	   
   
   public int numberOfSegments()        // the number of line segments
   {
	
	   return numberOfSegments;   
   }
   public LineSegment[] segments()                // the line segments
   {
	   ArrayList<LineSegment> linesegments= new ArrayList<>();
	 //  Merge.sort(points);
	   Merge.sort(points);
	   StdOut.println("HelloWolrd");
	   for (int i = 0; i < points.length; i++) {
		StdOut.println(points[i]);
	}
	   
	   
	   
	   for (int i = 0; i < points.length+1; i++) {
		for (int j = i+1; j < points.length+2; j++) {
			for (int k = j+1; k < points.length+3; k++) {
				StdOut.println("Length: "+points.length);
				double slope1=points[i].slopeTo(points[j]);
				double slope2=points[j].slopeTo(points[k]);
				if(slope1==slope2){
				
								
								for (int l = k+1; l < points.length; l++) {
								
								double slope3=points[k].slopeTo(points[l]);
											if(slope1==slope3){
												linesegments.add(new LineSegment(points[i], points[l]));
												
												ArrayList<Point> newlist= new ArrayList<Point>(Arrays.asList(points));
												newlist.remove(points[i]);
												newlist.remove(points[j]);
												newlist.remove(points[k]);
												newlist.remove(points[l]);
												StdOut.println(points[i] + " -> " + points[l]);
												points = new Point[newlist.size()];
												newlist.toArray(points);
												
											}
								
								
								
							}
				
				}
			}
		}
	}
	   
	 //  linesegments.s
	   answer = new LineSegment[linesegments.size()];
	   linesegments.toArray(answer);   
	  numberOfSegments=answer.length;
	  return answer;
   }


   public static void main(String[] args) {

	    // read the N points from a file
	    In in = new In(args[0]);
	   //In in = new StdIn(); 
	   int N = in.readInt();
	    Point[] points = new Point[N];
	    for (int i = 0; i < N; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.show(0);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
	    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	}


}
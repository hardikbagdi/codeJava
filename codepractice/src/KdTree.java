

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
	
	//1 means left right, 0 means abovebelow
	private int orientation;
	
	
	private int size=0;
	private Node root=null;;
	private static class Node {
		   private Point2D p;      // the point
		  
		   private RectHV rect;    // the axis-aligned rectangle corresponding to this node
		  
		   private Node lb;        // the left/bottom subtree
		  
		   private Node rt;        // the right/top subtree
		
		   public Node(Point2D p) {
			   this.p=p;
			 
			// TODO Auto-generated constructor stub
		}
	}

	
	 public  KdTree()                               // construct an empty set of points 
	   {
		 
	   }
	   public boolean isEmpty()                      // is the set empty? 
	   {
		return root==null;
		   
	   }
	   public int size()                         // number of points in the set 
	   {
		return size;
		}
	   public void insert(Point2D p)              // add the point to the set (if it is not already in the set)
	   {
		  if(p==null) throw new NullPointerException();
		  System.out.println("inserting fn"+p);
		  if(root==null){
			  System.out.println("root null true"+p);
			  Node n= new Node(p);
			  root=n;
			  root.rect= new RectHV(0, 0, 1, 1);
			  size++;
			  return;
		  }
		  else {
			insert(root,p,1);
		}
	   
	   }
	   private Node insert(Node root, Point2D p, int currentorientation) {
		   System.out.println("qww");
		   if(root==null){
			   System.out.println("this should  print"+p);
			   size++;
			    return new Node(p);			   
		   }
		   if(p.equals(root.p)){return root;}
		   int nextOrientation= currentorientation^1;
		   
		   int compare= compare(p,root.p, currentorientation);
		   System.out.println("compare "+compare);
		 if(compare<0){
			
			 System.out.println("compare less");
			 root.lb=insert(root.lb, p, nextOrientation);
			 //update recthv
			 if(root.lb.rect==null){
				 System.err.println("inside rect"+currentorientation);
				 if(currentorientation==1){
					//left-right partition 
					 System.out.println("inserting "+p);
					 root.lb.rect= new RectHV(root.rect.xmin(),root.rect.ymin(),root.p.x(),root.rect.ymax());
					 System.err.println(root.lb.rect);
				 }
				 else {
					 root.lb.rect= new RectHV(root.rect.xmin(),root.rect.ymin(),root.rect.xmax(),root.p.y());
					//above below partition
				}
			 }
		 }
		 else {
			 root.rt=insert(root.rt, p, nextOrientation);
			//update recthv
			 if(root.rt.rect==null){
				 if(orientation==1){
					 
					//left-right partition
				 }
				 else {
					//above-below partition
				}
			 }
			 
			 
		 }
		   
		   
		 return root;
	}
	   
	   
	   public boolean contains(Point2D p)            // does the set contain point p? 
	   {
		   if(p==null) throw new NullPointerException();
		   
		   
		   boolean flag= containsHelper(root, p, 1);
		return flag;
		}
	   private boolean containsHelper(Node root, Point2D p, int currentOrientation){
		   if(root==null) return false;
		   if(root.p.equals(p)) return true;
		   int nextOrientation = currentOrientation^1;
		   int compareflag= compare(root.p,p,currentOrientation);
		   if(compareflag<0){
			   return containsHelper(root.lb, p, nextOrientation);
		   }
		   else {
			   return containsHelper(root.rt, p, nextOrientation);
		}
		   
	  }
	   
	   private int compare(Point2D p, Point2D p2, int currentOrientation) {
		// TODO Auto-generated method stub
		if(currentOrientation==1){
			
			//compare x
			return Double.compare(p.x(), p2.x());
		
		}
		else {
			return Double.compare(p.y(),p2.y());
			//compare y;
		}
	}
	   public void draw()                         // draw all points to standard draw 
	   {
		   if(root ==null) return;
		   draw(root,1);
	   }
	   
	   private void draw(Node root, int orientation) {
		   int nextOrientation = orientation^1;
		   
		   StdDraw.setPenColor(StdDraw.BLACK);
		   StdDraw.setPenRadius(0.01);
		   StdDraw.point(root.p.x(), root.p.y());
		   if(orientation==1){
			   StdDraw.setPenColor(StdDraw.RED);
			   StdDraw.setPenRadius(0.001);
			   StdDraw.line(root.p.x(),root.rect.ymin(), root.p.x(),root.rect.ymax());
		   }
		   else {
			   StdDraw.setPenColor(StdDraw.BLUE);
			   StdDraw.setPenRadius(0.001);
			   StdDraw.line(root.rect.xmin(),root.p.y(),root.rect.xmax(),root.p.y());
		}
		   draw(root.lb,nextOrientation);
		   draw(root.rt, nextOrientation);
		// TODO Auto-generated method stub
		
	}
	public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle 
	   {
		 if(rect==null) throw new NullPointerException();
		return null;
		}
	   public Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty 
	   {
		if(p==null) throw new NullPointerException();
		return p;
		}
	   public static void main(String[] args)                  // unit testing of the methods (optional) 
	   {
		   KdTree  tree= new KdTree();
		   tree.insert(new Point2D(0.5, 0.5));
		   tree.insert(new Point2D(0.25, 0.25));
		   tree.draw();
//		   int i=1;
//		   int j=i^1;
//		   System.out.println(j);
	   }
}

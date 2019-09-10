/*  Name: Ethan Chen
 *  PennKey: etc
 *  Recitation: 217
 *
 *  Execution: java Tour
 * 
 *  Models tour by used of linked list of Points
 */

public class Tour implements TourInterface {
    private Node head;
    private Node lastNode;
    
    //constructor
    public Tour() {
        head = null;
        lastNode = null;
    }
    
    //create a String representation of the Tour
    public String toString() {
        if (head == null) {
            return "";
        }
        Node x = head;
        String nodes = "";
        //if the call to the next node is not the last node, then continue
        while (x.next != null) {
            nodes += x.point.toString() + "\n";
            x = x.next;
        }
        return nodes + lastNode.point.toString() + "\n";
    }
    
    //draw the Tour using PennDraw
    //any edge starting or ending at p should be in a distinct colour
    public void draw(Point p) {
        //if tour empty just print out line
        if (head == null) {
            System.out.println();
        }
        else {
            Node x = head;
            while (x.next != null) {
                //set different color of adjacent lines
                if (x.point == p || x.next.point == p) {
                    PennDraw.setPenColor(140, 150, 249);
                }
                //draw points and reset color
                x.point.drawTo(x.next.point);
                x = x.next;
                PennDraw.setPenColor();
            }
        }
    }
    
    //number of Points in this Tour
    public int size() {
        //return 0 if tour empty
        if (head == null) {
            return 0;
        }
        //iterate through nodes and count them
        Node x = head;
        int numberNodes = 1;
        while (x.next != null) {
            numberNodes += 1;
            x = x.next;
        }
        //make sure not to double count lastNode
        if (head.next != null) {
            numberNodes -= 1;
        }
        return numberNodes;
        
    }
    
    //return the total distance of the Tour
    public double distance() {
        //return 0 if node empty
        if (head == null) {
            return 0.0;
        }
        Node x = head;
        double totalDistance = 0;
        //add up distances as iterating
        while (x.next != null) {
            totalDistance += x.point.distanceTo(x.next.point);
            x = x.next;
        }
        return totalDistance;
    }
    
    //insert p at the end of the Tour
    public void insertInOrder(Point p) {
        //create two node objects referring to same point
        if (head == null) {
            lastNode = new Node(p);
            head = new Node(lastNode, p);
        }
        //iterate through node until reaching the end or reference last node
        else {
            Node x = head;
            while (x.next != lastNode) {
                x = x.next;
            }
            //insert node referencing last node; next insert node will replace
            Node insert = new Node(lastNode, p);
            x.next = insert;
        }
    }
    
    //insert p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        //do same as insertInOrder if empty tour
        if (head == null) {
            insertInOrder(p);
        }
        //iterate through tour and compare distances to point to be inserted
        else {
            Node x = head;
            Node intendedNeighbor = head;
            double minDistance = Double.MAX_VALUE;
            while (x.next != null) {
                double currentDistance = x.point.distanceTo(p);
                //save node to be inserted after if distance smaller
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    intendedNeighbor = x;
                }
                x = x.next;
            }
            //insert node
            intendedNeighbor.next = new Node(intendedNeighbor.next, p);
        }
    }
    
    //insert p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        //if tour empty do same as insertInOrder
        if (head == null) {
            insertInOrder(p);
        }
        //iterate through tour and compare change in distances if insert node
        else {
            Node x = head;
            Node intendedNeighbor = head;
            double minDistance = Double.MAX_VALUE;
            while (x.next != null) {
                double firstDistance = x.point.distanceTo(p);
                double secondDistance = x.next.point.distanceTo(p);
                double sumDistance = firstDistance + secondDistance;
                double oldDistance = x.point.distanceTo(x.next.point);
                double diffDistance = sumDistance - oldDistance;
                //only save place of insertion if less than previous change
                //in distances
                if (diffDistance < minDistance) {
                    minDistance = diffDistance;
                    intendedNeighbor = x;
                }
                x = x.next;
            }
            //insert node
            intendedNeighbor.next = new Node(intendedNeighbor.next, p);
        }
    }
    
    public static void main(String[] args) {
        Tour tour = new Tour();
        Tour tourOne = new Tour();
        Tour tourTwo = new Tour();
        Tour tourFour = new Tour();
        System.out.print(tour.toString());
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(1, 1);
        Point d = new Point(0, 1);
        tourOne.insertInOrder(a);
        tourTwo.insertInOrder(a);
        tourFour.insertInOrder(a);
        tourTwo.insertInOrder(b);
        tourFour.insertInOrder(b);
        tourFour.insertInOrder(c);
        tourFour.insertInOrder(d);
        System.out.println(tour);
        System.out.println(tourOne);
        System.out.println(tourTwo);
        System.out.println(tourFour);
        System.out.println(tour.size());
        System.out.println(tourOne.size());
        System.out.println(tourTwo.size());
        System.out.println(tourFour.size());
        System.out.println(tour.distance());
        System.out.println(tourOne.distance());
        System.out.println(tourTwo.distance());
        System.out.println(tourFour.distance());
        tourFour.draw(a);
    }
}
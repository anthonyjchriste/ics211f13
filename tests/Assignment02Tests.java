import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Assignment02Tests {

  @Test
  public void testPointConstructors() {
    Point pointDefault = new Point();
    Point pointA = new Point(1.5, 3.5);  
    
    // Test that the constructors and getters work correctly
    assertEquals("Testing default constructor x", 0, pointDefault.getX(), 0);
    assertEquals("Testing default constructor y", 0, pointDefault.getY(), 0);
    assertEquals("Testing constructor pointA x", 1.5, pointA.getX(), 0);
    assertEquals("Testing constructor pointA y", 3.5, pointA.getY(), 0);
  }
  
  @Test
  public void testPointDistance() {
    Point pointDefault = new Point();
    Point pointA = new Point(1.5, 3.5);
    
    // Test distance formula
    assertEquals("Distance 0", 0, pointDefault.distance(new Point()), 0);
    assertEquals("Distance 0", 3.807, pointDefault.distance(pointA), .001);  
  }
  
  @Test
  public void testPointToString() {
    Point pointDefault = new Point();
    Point pointA = new Point(1.5, 3.5);  
    
    // Test toString method
    assertEquals("toString point", "(1.5,3.5)", pointA.toString());
  }

  @Test
  public void testSegmentHorizontal() {
    Point pointHorizontalA = new Point(1, 0);
    Point pointHorizontalB = new Point(3, 0);
    Segment horizontalSegment = new Segment(pointHorizontalA, pointHorizontalB);  
    
    // Test isHorizontal
    assertTrue("Test horizontal", horizontalSegment.isHorizontal());
  }
  
  @Test
  public void testSegmentVertical() {
    Point pointVerticalA = new Point(0, 1);
    Point pointVerticalB = new Point(0, 3);
    Segment verticalSegment = new Segment(pointVerticalA, pointVerticalB);

    // Test isVertical
    assertTrue("Test vertical", verticalSegment.isVertical());  
  }
  
  @Test
  public void testSegmentNonHorizontalVertical() {
    Point pointHorizontalA = new Point(1, 0);  
    Point pointVerticalA = new Point(0, 1);
    
    // Test for false values of is horizonal and is vertical
    Segment nonHorizontalVeritcal = new Segment(pointHorizontalA, pointVerticalA);
    assertFalse("Test not horizontal", nonHorizontalVeritcal.isHorizontal());
    assertFalse("Test not vertical", nonHorizontalVeritcal.isVertical());
  }
    
  @Test
  public void testSegmentLeft() {
    Point pointHorizontalA = new Point(1, 0);
    Point pointHorizontalB = new Point(3, 0);
    Segment horizontalSegment = new Segment(pointHorizontalA, pointHorizontalB);  
    assertEquals("Testing left", pointHorizontalA, horizontalSegment.left());  
  }
  
  @Test
  public void testSegmentRight() {
    Point pointHorizontalA = new Point(1, 0);
    Point pointHorizontalB = new Point(3, 0);
    Segment horizontalSegment = new Segment(pointHorizontalA, pointHorizontalB);  
    assertEquals("Testing right", pointHorizontalB, horizontalSegment.right());  
  } 
  
  @Test
  public void testSegmentUpper() {
    Point pointVerticalA = new Point(0, 1);
    Point pointVerticalB = new Point(0, 3);
    Segment verticalSegment = new Segment(pointVerticalA, pointVerticalB);  
    assertEquals("Testing upper", pointVerticalB, verticalSegment.upper());
  }
  
  @Test
  public void testSegmentLower() {
    Point pointVerticalA = new Point(0, 1);
    Point pointVerticalB = new Point(0, 3);
    Segment verticalSegment = new Segment(pointVerticalA, pointVerticalB);  
    assertEquals("Testing lower", pointVerticalA, verticalSegment.lower());
  }    
  
  @Test
  public void testSegmentLength() {
    Point pointHorizontalA = new Point(1, 0);
    Point pointHorizontalB = new Point(3, 0);
    Segment horizontalSegment = new Segment(pointHorizontalA, pointHorizontalB); 
    assertEquals("Testing length", 2, horizontalSegment.length(), 0);
  }
  
  @Test
  public void testSegmentToString() {
    Point pointHorizontalA = new Point(1, 0);
    Point pointHorizontalB = new Point(3, 0);
    Segment horizontalSegment = new Segment(pointHorizontalA, pointHorizontalB);
    Point pointVerticalA = new Point(0, 1);
    Point pointVerticalB = new Point(0, 3);
    Segment verticalSegment = new Segment(pointVerticalA, pointVerticalB);
    Segment nonHorizontalVeritcal = new Segment(pointHorizontalA, pointVerticalA);  
    
    assertEquals("toString horizontal", "(1.0,0.0)(3.0,0.0)", horizontalSegment.toString());
    assertEquals("toString vertical", "(0.0,1.0)(0.0,3.0)", verticalSegment.toString());
    assertEquals("toString slope", "(1.0,0.0)(0.0,1.0)", nonHorizontalVeritcal.toString());
  }
  
  
  @Test
  public void testSegmentNormalMove() {
    Point pointA = new Point(0, 0);
    Point pointB = new Point(7, 1.5);
    Point pointMove = new Point(-5.3, 0);
    Segment segment = new Segment(pointA, pointB);
    segment.move(pointMove);

    // Test that the lower point moved correctly
    assertEquals("Move segment to left by -5.3 units x lower", -5.3, segment.lower().getX(), .001);
    assertEquals("Move segment to left by -5.3 units y lower", 0, segment.lower().getY(), .001);

    // Test that the upper point moved correctly
    assertEquals("Move segment to left by -5.3 units x upper", 1.7, segment.upper().getX(), .001);
    assertEquals("Move segment to left by -5.3 units y upper", 1.5, segment.upper().getY(), .001);
  }
  
  @Test
  public void testSegmentHorizontalMove() {
    Point pointHorizontalA = new Point(1, 0);
    Point pointHorizontalB = new Point(3, 0);
    Segment horizontalSegment = new Segment(pointHorizontalA, pointHorizontalB);  
    
     // Perform the same tests, but this time use a horizontal segment
    horizontalSegment.move(new Point(0, 0));
    assertEquals("Move horizontal left by 1 units x left", 0, horizontalSegment.left().getX(), .001);
    assertEquals("Move horizontal left by 1 units y left", 0, horizontalSegment.left().getY(), .001);

    // Test that the upper point moved correctly
    assertEquals("Move horizontal left by 1 units x right", 2, horizontalSegment.right().getX(), .001);
    assertEquals("Move horizontal left by 1 units y right", 0, horizontalSegment.right().getY(), .001);
  }
}

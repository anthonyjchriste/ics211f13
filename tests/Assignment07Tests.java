import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Assignment07Tests {
  private ArrayQueue<String> arrayQueue;
  private LinkedQueue<String> linkedQueue;

  @Before
  public void setup() {
    arrayQueue = new ArrayQueue<String>();
    linkedQueue = new LinkedQueue<String>();
  }

  @Test
  public void testOfferNullArrayQueue() {
    assertFalse(arrayQueue.offer(null));
  }

  @Test
  public void testOfferNullLinkedQueue() {
    assertFalse(linkedQueue.offer(null));
  }

  @Test
  public void testOfferArrayQueueEmpty() {
    assertTrue(arrayQueue.offer("A"));
  }

  @Test
  public void testOfferLinkedQueueEmpty() {
    assertTrue(linkedQueue.offer("A"));
  }

  @Test
  public void testOfferArrayQueueNotEmpty() {
    assertTrue(arrayQueue.offer("A"));
    assertTrue(arrayQueue.offer("B"));
  }

  @Test
  public void testOfferLinkedQueueNotEmpty() {
    assertTrue(linkedQueue.offer("A"));
    assertTrue(linkedQueue.offer("B"));
  }

  @Test
  public void testOfferArrayQueueDuplicateFront() {
    arrayQueue.offer("A");
    arrayQueue.offer("B");
    assertFalse(arrayQueue.offer("A"));
  }

  @Test
  public void testOfferLinkedQueueDuplicateFront() {
    linkedQueue.offer("A");
    linkedQueue.offer("B");
    assertFalse(linkedQueue.offer("A"));
  }

  @Test
  public void testOfferArrayQueueDuplicateMiddle() {
    arrayQueue.offer("A");
    arrayQueue.offer("B");
    assertFalse(arrayQueue.offer("B"));
  }

  @Test
  public void testOfferLinkedQueueDuplicateMiddle() {
    linkedQueue.offer("A");
    linkedQueue.offer("B");
    assertFalse(linkedQueue.offer("B"));
  }

  @Test
  public void testOfferArrayQueueDuplicateEnd() {
    arrayQueue.offer("A");
    arrayQueue.offer("B");
    arrayQueue.offer("C");
    assertFalse(arrayQueue.offer("B"));
  }

  @Test
  public void testOfferLinkedQueueDuplicateEnd() {
    linkedQueue.offer("A");
    linkedQueue.offer("B");
    linkedQueue.offer("C");
    assertFalse(linkedQueue.offer("B"));
  }

  @Test
  public void testOfferArrayQueueMaxCapacity() {
    arrayQueue.offer("1");
    arrayQueue.offer("2");
    arrayQueue.offer("3");
    arrayQueue.offer("4");
    arrayQueue.offer("5");
    arrayQueue.offer("6");
    arrayQueue.offer("7");
    arrayQueue.offer("8");
    arrayQueue.offer("9");
    arrayQueue.offer("10");
    assertFalse(arrayQueue.offer("11"));
  }

  @Test
  public void testPollArrayQueueEmpty() {
    assertNull(arrayQueue.poll());
  }

  @Test
  public void testPollLinkedQueueEmpty() {
    assertNull(linkedQueue.poll());
  }

  @Test
  public void testPollArrayQueueSingleItem() {
    arrayQueue.offer("A");
    assertEquals("A", arrayQueue.poll());
    assertNull(arrayQueue.poll());
  }

  @Test
  public void testPollLinkedQueueSingleItem() {
    linkedQueue.offer("A");
    assertEquals("A", linkedQueue.poll());
    assertNull(linkedQueue.poll());
  }

  @Test
  public void testPollArrayQueueAll() {
    arrayQueue.offer("A");
    arrayQueue.offer("B");
    arrayQueue.offer("C");
    assertEquals("A", arrayQueue.poll());
    assertEquals("B", arrayQueue.poll());
    assertEquals("C", arrayQueue.poll());
    assertNull(arrayQueue.poll());
  }

  @Test
  public void testPollLinkedQueueAll() {
    linkedQueue.offer("A");
    linkedQueue.offer("B");
    linkedQueue.offer("C");
    assertEquals("A", linkedQueue.poll());
    assertEquals("B", linkedQueue.poll());
    assertEquals("C", linkedQueue.poll());
    assertNull(linkedQueue.poll());
  }

  @Test
  public void testOfferPollArrayQueueMixed() {
    arrayQueue.offer("A");
    assertEquals("A", arrayQueue.poll());
    arrayQueue.offer("B");
    assertEquals("B", arrayQueue.poll());
    assertNull(arrayQueue.poll());
    arrayQueue.offer("A");
    arrayQueue.offer("B");
    assertEquals("A", arrayQueue.poll());
    assertTrue(arrayQueue.offer("A"));
    assertEquals("B", arrayQueue.poll());
    assertEquals("A", arrayQueue.poll());
  }

  @Test
  public void testOfferPollLinkedQueueMixed() {
    linkedQueue.offer("A");
    assertEquals("A", linkedQueue.poll());
    linkedQueue.offer("B");
    assertEquals("B", linkedQueue.poll());
    assertNull(linkedQueue.poll());
    linkedQueue.offer("A");
    linkedQueue.offer("B");
    assertEquals("A", linkedQueue.poll());
    assertTrue(linkedQueue.offer("A"));
    assertEquals("B", linkedQueue.poll());
    assertEquals("A", linkedQueue.poll());
  }

  @Test
  public void testDuplicateNotAddedArrayQueue() {
    arrayQueue.offer("A");
    arrayQueue.offer("A");
    arrayQueue.poll();
    assertNull(arrayQueue.poll());
  }

  @Test
  public void testDuplicateNotAddedLinkedQueue() {
    linkedQueue.offer("A");
    linkedQueue.offer("A");
    linkedQueue.poll();
    assertNull(linkedQueue.poll());
  }
}

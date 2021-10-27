import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.beans.Transient;

import org.junit.jupiter.api.Test;


public class BinaryNodeTest
{
    @Test
    void testConstructors()
    {
        BinaryNode <Integer> emptyCall = new BinaryNode<>();
        BinaryNode <Integer> dataCall = new BinaryNode<>(7);
        BinaryNode <Integer> fullCall = new BinaryNode<>(13, emptyCall, dataCall);

        assertEquals(null, emptyCall.getData());
        assertEquals(7, dataCall.getData());
        assertEquals(13, fullCall.getData());
        assertEquals(emptyCall, fullCall.getLeftChild());
        assertEquals(dataCall, fullCall.getLeftChild());
    }

    @Test
    void testgetData()
    {
        BinaryNode <Integer> bNode = new BinaryNode<>(5);
        assertEquals(5, bNode.getData());
    }

    @Test
    void testSetData()
    {
        BinaryNode <Integer> bNode = new BinaryNode(21);
        assertEquals(21, bNode.getData());
        bNode.setData(23);
        assertEquals(23, bNode.getData());
    }

    @Test
    void testLeft()
    {
        BinaryNode <Integer> left = new BinaryNode<>(8);
        BinaryNode <Integer> newLeft = new BinaryNode<>(2);
        Binarynode <Integer> right = new BinaryNode<>(3);
        BinaryNode <Integer> bNode = new BinaryNode(11, left, right);

        assertEquals(left, bNode.getLeftChild());
        assertEquals(newLeft, bNode.setLeftChild());
        assertTrue(bNode.hasLeftChild());
    }

    @Test
    void testRight()
    {
        BinaryNode <Integer> left = new BinaryNode<>(8);
        BinaryNode <Integer> newRight = new BinaryNode<>(2);
        Binarynode <Integer> right = new BinaryNode<>(3);
        BinaryNode <Integer> bNode = new BinaryNode(11, left, right);

        assertTrue(bNode.hasRightChild());
        assertEquals(3, bNode.getRightChild());
        assertEquals(2, bNode.getRightChild(bNode.setRightChild()));
    }

    @Test
    void testIsLeaf()
    {
        BinaryNode <Integer> left = new BinaryNode<>(32);
        Binarynode <Integer> right = new BinaryNode<>(97);
        BinaryNode <Integer> bNode = new BinaryNode<>(11, left, right);

        assertFalse(bNode.isLeaf());
        assertTrue(left.isLeaf());
        assertTrue(right.isLeaf());
    }

    @Test
    void testCopy()
    {
        BinaryNode <Integer> left = new BinaryNode<>(17);
        BinaryNode <Integer> right = new BinaryNode<>(4);
        BinaryNode <Integer> root = new BinaryNode(0, left, right);

        BinaryNode  <Integer> copy = root.copy();

        assertEquals(root.getData(), copy.getData());
        assertEquals(root.getLeftChild(), copy.getLeftChild());
        assertEquals(root.getRightChild(), copy.getRightChild());
        root.setLeftChild(right);
        assertFalse(root.getLeftChild() == copy.getLeftChild());
    }

    @Test
    void testPostorderTraverse()
    {
        
    }
}
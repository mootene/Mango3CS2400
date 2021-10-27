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
        assertEquals(dataCall, fullCall.getRightChild());
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
        BinaryNode <Integer> right = new BinaryNode<>(3);
        BinaryNode <Integer> bNode = new BinaryNode(11, left, right);

        assertEquals(left, bNode.getLeftChild());
        bNode.setLeftChild(newLeft);
        assertEquals(newLeft, bNode.getLeftChild());
        assertTrue(bNode.hasLeftChild());
    }

    @Test
    void testRight()
    {
        BinaryNode <Integer> left = new BinaryNode<>(8);
        BinaryNode <Integer> newRight = new BinaryNode<>(2);
        BinaryNode <Integer> right = new BinaryNode<>(3);
        BinaryNode <Integer> bNode = new BinaryNode(11, left, right);

        assertTrue(bNode.hasRightChild());
        assertEquals(right, bNode.getRightChild());
        bNode.setRightChild(newRight);
        assertEquals(newRight, bNode.getRightChild());
    }

    @Test
    void testIsLeaf()
    {
        BinaryNode <Integer> left = new BinaryNode<>(32);
        BinaryNode <Integer> right = new BinaryNode<>(97);
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

        BinaryNode <Integer> copy = root.copy();

        assertEquals(root.getData(), copy.getData());
        assertEquals(root.getLeftChild(), copy.getLeftChild());
        assertEquals(root.getRightChild(), copy.getRightChild());
        root.setLeftChild(right);
        assertFalse(root.getLeftChild() == copy.getLeftChild());
    }

    @Test
    void testPostorderTraverse()
    {
        BinaryNode <Integer> a = new BinaryNode<>(5);
        BinaryNode <Integer> b = new BinaryNode<>(9);
        BinaryNode <Integer> c = new BinaryNode<>(8, a, b);
        BinaryNode <Integer> d = new BinaryNode<>(3);
        BinaryNode <Integer> e = new BinaryNode<>(875431, c, d);

        StringBuilder postoder = new StringBuilder();
        e.postorderTraverse_binaryNodeMethod(postoder);

        //TO DO
    }

    @Test
    void testGetHeight()
    {
        BinaryNode <Integer> a = new BinaryNode<>(7);
        BinaryNode <Integer> b = new BinaryNode<>(2);
        BinaryNode <Integer> c = new BinaryNode<>(105, a, b);
        BinaryNode <Integer> d = new BinaryNode<>(999);
        BinaryNode <Integer> e = new BinaryNode<>(998, c, d);

        int heightE = e.getHeight_binaryNodeMethod();
        int heightA = a.getHeight_binaryNodeMethod();

        assertEquals(1, heightA);
        assertEquals(3, heightE);
    }

    @Test
    void testNumberOfNodes()
    {
        BinaryNode <Integer> a = new BinaryNode<>(5);
        BinaryNode <Integer> b = new BinaryNode<>(9);
        BinaryNode <Integer> c = new BinaryNode<>(8, a, b);
        BinaryNode <Integer> d = new BinaryNode<>(3);
        BinaryNode <Integer> e = new BinaryNode<>(875431, c, d);
        BinaryNode <Integer> f = new BinaryNode<>(27);
        BinaryNode <Integer> g = new BinaryNode<>(56, e, f);

        int nodesRoot = g.getNumberOfNodes_binaryNodeMethod();
        int nodesLeft = e.getNumberOfNodes_binaryNodeMethod();
        int nodesRight = f.getNumberOfNodes_binaryNodeMethod();

        assertEquals(1, nodesRight);
        assertEquals(5, nodesLeft);
        assertEquals(7, nodesRoot);
    }
}
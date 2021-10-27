import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.beans.Transient;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest
{
    @Test
    void testConstructors()
    {
        BinaryTree <Character> tree1 = new BinaryTree<>();
        BinaryTree <Character> tree2 = new BinaryTree<>('a');
        BinaryTree <Character> tree3 = new BinaryTree<>('b');
        BinaryTree <Character> tree4 = new BinaryTree<>('c', tree2, tree3);

        assertTrue(tree1.isEmpty());
        assertEquals('a', tree2.getRootData());

        //TO DO
    }

    @Test
    void testSetTree()
    {
        BinaryTree <Character> tree1 = new BinaryTree<>();
        BinaryTree <Character> tree2 = new BinaryTree<>('a');
        BinaryTree <Character> tree3 = new BinaryTree<>('b', tree1, tree2);

        tree1.setTree('c', tree2, tree3);

        //TO DO
    }

    @Test
    void testgetData()
    {
        BinaryTree <Character> tree1 = new BinaryTree<>('z');
        assertEquals('z', tree1.getRootData());
    }
    @Test
    void testSetRootData()
    {
        BinaryTree <Character> tree1 = new BinaryTree<>();
        tree1.setRootData('a');
        assertEquals('a', tree1.getRootData());
    }

    @Test
    void testIsEmpty()
    {
        BinaryTree <Character> tree1 = new BinaryTree<>();
        BinaryTree <Character> tree2 = new BinaryTree<>('b');

        assertTrue(tree1.isEmpty());
        assertFalse(tree2.isEmpty());
    }

    @Test
    void testClear()
    {
        BinaryTree <Character> tree1 = new BinaryTree<>();
        BinaryTree <Character> tree2 = new BinaryTree<>('a');
        BinaryTree <Character> tree3 = new BinaryTree<>('b', tree1, tree2);

        tree3.clear();
        assertTrue(tree3.isEmpty());
        assertTrue(tree2.isEmpty());    //ask aba
    }

    /*@Test
    void testPostorderTraverse()
    {

    }*/

   
    @Test
    void testGetHeight()
    {
        BinaryTree <Integer> emptyTree = new BinaryTree<>();
        BinaryTree <Integer> left = new BinaryTree<>(45);
        BinaryTree <Integer> right = new BinaryTree<>(42);
        BinaryTree <Integer> full = new BinaryTree<>(76, left, right);

        int height = emptyTree.getHeight();
        assertEquals(0, height);
        height = full.getHeight();
        assertEquals(2, height);
    }
   
}
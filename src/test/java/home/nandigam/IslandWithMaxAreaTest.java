package home.nandigam;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandWithMaxAreaTest
{

    @Test
    public void test()
    {
        int[][] map = { {1, 1, 0, 0, 1},
                        {0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1}};
        IslandWithMaxArea islandWithMaxArea = new IslandWithMaxArea(map);

        assertEquals(6, islandWithMaxArea.islandWithMaxArea());
    }


    @Test
    public void test2()
    {
        int[][] map = { {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        IslandWithMaxArea islandWithMaxArea = new IslandWithMaxArea(map);

        assertEquals(6, islandWithMaxArea.islandWithMaxArea());
    }


}
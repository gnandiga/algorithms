package home.nandigam;

import java.util.Queue;
import java.util.Stack;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * Find the maximum area of an island in the given 2D array.
 *
 * [1 1 0 0 1 ]
 * [0 1 0 0 0 ]
 * [0 0 0 0 1 ]
 * [1 1 1 1 1 ]
 */
public class IslandWithMaxArea
{

    int[][] map;
    int n;
    int m;

    boolean[][] visited;

    public IslandWithMaxArea(int[][] map)
    {
        this.map = map;
        this.m = map.length;
        this.n = map[0].length;
        this.visited = new boolean[m][n];
    }

    public int islandWithMaxArea()
    {
        Stack<Position> landLocations = new Stack<Position>();
        int maxArea = 0;
        for (int x = 0; x < m; x++)
        {
            for (int y = 0; y < n; y++)
            {
                if (map[x][y] == 1 && !visited[x][y])
                {
                    landLocations.push(new Position(x, y));
                    visited[x][y] = true;
                    int areaAtPosition = getArea(landLocations);
                    if (maxArea < areaAtPosition)
                    {
                        maxArea = areaAtPosition;
                    }
                }
            }
        }
        return maxArea;
    }

    private int getArea(Stack<Position> landLocations)
    {
        int area = 0;
        while (!landLocations.empty())
        {
            Position pop = landLocations.pop();

            if (pop.x + 1 < m &&
                    map[pop.x + 1][pop.y] == 1 && !visited[pop.x + 1][pop.y])
            {
                visited[pop.x + 1][pop.y] = true;
                landLocations.push(new Position(pop.x + 1, pop.y));
            }
            if (pop.x - 1 >= 0 &&
                    map[pop.x - 1][pop.y] == 1 && !visited[pop.x - 1][pop.y])
            {
                visited[pop.x - 1][pop.y] = true;
                landLocations.push(new Position(pop.x - 1, pop.y));
            }
            if (pop.y + 1 < n &&
                    map[pop.x][pop.y + 1] == 1 && !visited[pop.x][pop.y + 1])
            {
                visited[pop.x][pop.y + 1] = true;
                landLocations.push(new Position(pop.x, pop.y + 1));
            }
            if (pop.y - 1 >= 0 &&
                    map[pop.x][pop.y - 1] == 1 && !visited[pop.x][pop.y - 1])
            {
                visited[pop.x][pop.y - 1] = true;
                landLocations.push(new Position(pop.x, pop.y - 1));
            }
            area = 1 + getArea(landLocations);
        }
        return area;
    }


    class Position
    {
        int x;
        int y;

        Position(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

}

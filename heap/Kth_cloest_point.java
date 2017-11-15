/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 Solution1: PriorityQueue
time: O(nlogk)
space: O(k)
建立最大堆，维护size为k。
最后，堆中存放的就是答案。
堆顶是距离为第k closest的point。（需要反向输出）
注意：distance函数越界问题
public class Solution {
    private long distance(Point a, Point b) {//注意乘法越界
        long dx = (long)(a.x - b.x);
        long dy = (long)(a.y - b.y);

        return dx * dx  + dy * dy;
    }


    public Point[] kClosest(Point[] points, Point origin, int k) {
        Comparator<Point> cmp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                long d1 = distance(a, origin);
                long d2 = distance(b, origin);

                long diff = d2 - d1;

                if(diff == 0) {
                    diff = b.x - a.x;
                }

                if(diff == 0) {
                    diff = b.y - a.y;
                }

                return (int)diff;
            }
        };

        Queue<Point> pq = new PriorityQueue<Point>(k + 1, cmp);

        for(Point point : points) {
            pq.offer(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        Point[] res = new Point[k];
        for(int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }
}

//Quick Select + sort
time: O(n) + O(klogk)
space: O(1)
public class Solution {

    private long distance(Point a, Point b) {
        long dx = (long)(a.x - b.x);
        long dy = (long)(a.y - b.y);

        return dx * dx  + dy * dy;
    }


    public Point[] kClosest(Point[] points, Point origin, int k) {
        Comparator<Point> cmp = new Comparator<Point>() {
            public int compare(Point a, Point b) {
                long d1 = distance(a, origin);
                long d2 = distance(b, origin);

                long diff = d1 - d2;

                if(diff == 0) {
                    diff = a.x - b.x;
                }

                if(diff == 0) {
                    diff = a.y - b.y;
                }

                return (int)diff;
            }
        };

        int mid = 0;
        int start = 0;
        int end = points.length - 1;
        for(;;) {
            mid = partition(points, start, end, cmp);
            if(mid == k - 1) {
                break;
            } else if(mid < k - 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        Point[] res = new Point[k];
        for(int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        Arrays.sort(res, cmp);//
        return res;
    }

    private int partition(Point[] points, int start, int end, Comparator<Point> cmp) {
        Random random = new Random();
        int pivot = start + random.nextInt(end - start + 1);
        swap(points, pivot, end);

        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(cmp.compare(points[j], points[end]) <= 0) {
                i++;
                swap(points, i, j);
            }
        }

        swap(points, i + 1, end);
        return i + 1;
    }

    private void swap(Point[] points, int i, int j) {
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}

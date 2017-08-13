//better code
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int left = searchX(image, 0, y, 0, m - 1, false);
        int right = searchX(image, y, n - 1, 0, m - 1, true);
        int up = searchY(image, 0, x, left, right, false);
        int down = searchY(image, x, m - 1, left, right, true);
        return (right - left + 1) * (down - up + 1);
    }

    public int searchX(char[][] image, int start, int end, int up, int down, boolean flag) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int i = up;
            while(i <= down && image[i][mid] == '0') i++;
            if((i <= down) == flag) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(flag) {
            int i = up;
            while(i <= down && image[i][end] == '0') i++;
            if(i <= down) {
                return end;
            } else {
                return start;
            }
        } else {
            int i = up;
            while(i <= down && image[i][start] == '0') i++;
            if(i <= down) {
                return start;
            } else {
                return end;
            }
        }
    }
    public int searchY(char[][] image, int start, int end, int left, int right, boolean flag) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int j = left;
            while(j <= right && image[mid][j] == '0') j++;
            if((j <= right) == flag) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(flag) {
            int j = left;
            while(j <= right && image[end][j] == '0') j++;
            if(j <= right) {
                return end;
            } else {
                return start;
            }
        } else {
            int j = left;
            while(j <= right && image[start][j] == '0') j++;
            if(j <= right) {
                return start;
            } else {
                return end;
            }
        }
    }
}
//first version
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left = searchX(image, y, false); System.out.println(left);
        int right = searchX(image, y, true); System.out.println(right);
        int up = searchY(image, x, false); System.out.println(up);
        int down = searchY(image, x, true); System.out.println(down);
        return (right - left + 1) * (down - up + 1);
    }

    public int searchX(char[][] image, int y, boolean flag) {
        int start, end, mid, res = y, i = 0;
        if(flag) {
            start = y; end = image[0].length - 1;
        } else {
            start = 0; end = y;
        }
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            i = 0;
            while(i < image.length - 1 && image[i][mid] == '0') i++;//tricky
            if(flag) {
                if(image[i][mid] == '1') {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if(image[i][mid] == '1') {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if(flag) {
            i = 0;
            while(i < image.length - 1 && image[i][end] == '0') i++;//tricky
            if(image[i][end] == '1') {
                res = Math.max(res, end);
            } else {
                res = Math.max(res, start);
            }
        } else {
            i = 0;
            while(i < image.length - 1 && image[i][start] == '0') i++;//tricky
            if(image[i][start] == '1') {
                res = Math.min(res, start);
            } else {
                res = Math.min(res, end);
            }
        }

        return res;
    }
    public int searchY(char[][] image, int x, boolean flag) {
        int start, end, mid, res = x, j = 0;

        if(flag) {
            start = x; end = image.length - 1;
        } else {
            start = 0; end = x;
        }
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            j = 0;
            while(j < image[0].length - 1 && image[mid][j] == '0') j++;//tricky
            if(flag) {
                if(image[mid][j] == '1') {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if(image[mid][j] == '1') {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if(flag) {
            j = 0;
            while(j < image[0].length - 1 && image[end][j] == '0') j++;//tricky
            if(image[end][j] == '1') {
                res = Math.max(res, end);
            } else {
                res = Math.max(res, start);
            }
        } else {
            j = 0;
            while(j < image[0].length - 1 && image[start][j] == '0') j++;//tricky
            if(image[start][j] == '1') {
                res = Math.min(res, start);
            } else {
                res = Math.min(res, end);
            }
        }
        return res;
    }

}

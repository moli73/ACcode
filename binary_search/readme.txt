binary search template tips:
1.数组必须是sorted的
2.找到pointer的可移动范围，即初始start和end值
3.循环退出条件为，相邻退出：start + 1 < end， 即最终数组里面有两个element
4.核心思想，通过对mid情况的判断，删掉不可能存在答案的一半，向一定有答案的一半缩小
5.根据题目要求，使用if else判断所剩的start和end谁是answer

binary search题目总结：
1.所有带mid * mid <=> target的乘法判断，注意数据类型的range，常见：input是int， 那么mid，start，end应该为long型

2.最后的start和end判断，根据谁更应该是answer的优先级来定。谁优先级高，先check谁
3.当最后剩start和end时，可看成两个点，将数轴分割成3部分，根据题目要求，对target落在哪个区间进行逐一判断。
4.多个区间的if else语句不同的先后顺序，可以简化condition的语法复杂度。因为，当第一个if不满足时，后面的else就默认含有第一个if里面condition的反面

5.binary search常常和hash table， two pointers， sorted等题型相关
如（two pointers）#475heaters：转换为，判断所有house到heater的最近距离，这些距离当中的最大值，即为最小heater覆盖半径。
关键点：1.先将两数组排序。2.扫描每个house，全局指针指向heater，找当前house最近heater，利用公式while(house >= heaters[i] + heaters[i + 1]) i++
下一个house，接着从当前heater[i]进行判断。然后，更新res = max(res, abs(house - heater[i]))
因为，当house >= heaters[i] + heaters[i + 1]时，说明，heaters[i]并不是距离house最近的一个，所以右移i
          h m
        | | | | |
        h       h
        i 此时heater[i]一定时离h最近的
          m h
      | | | | |
      h       h
      i   此时heater[i]不是离h最近的
ps. 1) Arrays.sort(arrayName) 注意时Arrays，不是arrays，也不是Array
    2）Math.abs, Math.max, Math.min

如#349求两数组的intersection，可以排序一个数组，作为二分查找的基础，然后扫面另一个数组。
又或对两个数组进行排序，然后用two pointers进行求解。
注意去重复，在while循环体里面，先执行去重：(只取重复数字中最后一个进行，intersect操作判断)
    while(i + 1 < nums1.length && nums1[i] == nums1[i + 1]) i++;
    while(j + 1 < nums2.length && nums2[j] == nums2[j + 1]) j++;
ps. 1)注意ArrayList和Array的区别，最后返回时Array，所以需要对ArrayList逐次赋值给Array

如（hash table）#274 题目原型为，给定一个数组(隐含，无序，有重复，可为空)，返回满足条件的最大值m，至少有m数的值大于等于m。
思路：1.统计所以数值的出现频率，又因为m最大值也就是数组长度，所以把所有值大于数组长度的数，频率统计到一起。
     2.从大数值的数字频率想小的累加到total上，若total(统计的频率) >= i(指的的数值)，则返回此时数值i，即为答案
     3.当key是连续int的时候，可以利用数组的index来实现hash的查找作用
若#275给定数组是升序，则可以使用binary search。
1.当nums[mid] <= n - mid, 即mid的数值小于大于等于此数值的数个数时，说明答案至少为mid这么大（此判断条件，比较隐蔽），start = mid，反之，end = mid
2.最后，对start和end，找到符合条件的最大值。


6.给定的数组，如果没特别指出需要考虑：是否数值连续，是否排序，是否有重复值，是否为空

7.特殊算法：
如#69 求int sqrt：binary search可解。另解：newton method
求isqrt(x) = 对x求平方根向下取整 --> find solution of x^2 - n = 0, x, n both integer
according to newton method, that f(x) = 0 --> x_(n + 1) =  x_n - f(x_n) / f'(x_n)
which means,
x_(k + 1) = (1 / 2) * (x_k + n / x_k), when k goes infinity, |x_k - x_(k + 1)| < 1 to get the an
the code is:
long r = x;
while(r * r > x){
    r = (r + x / r) / 2
}
return (int)r;

如#240 search in matrix(two pointers)
从左下开始，逐个比较与target的大小，从而可以删除某行，或者某列，缩小范围，最终得到答案。time complexity is O(m + n)

如#4 找median of two sorted arrays
转换为，求两个sorted arrays 的第k大的数。
分别，找A的第k／2大的数和B的第k／2大的数，进行比大小，若A[s1 + k/2 - 1] >= B[s2 + k/2 - 1],则第k大的数，一定不再B的前k／2的数中，所以舍弃它们。
为了只有O(1)的复杂度，则移动B的数组起点从s2到s2 + k／2。然后接着找k-k／2大的数。
终止条件：1.如果一方数组数个数不到k／2，则直接返回，另一数组的第k大的数
        2.当k == 1时，比较两数组的第一个数，即可得到答案
回到，此题，即将问题分为总个数为奇数和偶数两种情况分别讨论即可，最后算法复杂度为O(log(m + n))
ps.1)注意第k大，在数组的下标时k - 1
    2）先判断终止条件1，在判断终止条件2，因为1包含部分2

8.search in rotated array
无duplicate的时候，首先判断mid在那一段上
         - |                        nums[mid] > nums[end] 在左段
        -  |
       -   |                        nums[mid] == nums[end] 的情况，只有在mid和最后一个元素重合时才会出现
      -    |
-----------|----------
           |     -                  nums[mid] <= nums[end] 在右段
           |   -
           | -
有duplicate的时候，对nums[mid] == nums[end]的情况特殊处理，此时只能将end--。所以，极端情况时间复杂度降为O(n).

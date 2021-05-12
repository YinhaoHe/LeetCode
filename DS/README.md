# Question list

## Binary Search

- [35 Search Insert Position](./Array/35_search_insert_position.java) : 注意处理 left right 开闭区间边界值 ([detail](https://mp.weixin.qq.com/s/fCf5QbPDtE6SSlZ1yh_q8Q)) ([LC](https://leetcode.com/problems/search-insert-position/))

## Two Pointers

- [27 Remove Element](./Array/27_remove_element.java) : ([detail](https://mp.weixin.qq.com/s/wj0T-Xs88_FHJFwayElQlA)) ([LC](https://leetcode.com/problems/remove-element/))

## Sliding Window

- [209 Minimum Size Subarray Sum](./Array/209_minimum_size_subarray_sum.java) : 注意确定窗口的起始位置如何移动 ([detail](https://mp.weixin.qq.com/s/UrZynlqi4QpyLlLhBPglyg)) ([LC](https://leetcode.com/problems/minimum-size-subarray-sum/))

## Basic Coding

- [59 Spiral Matrix II](./Array/59_spiral_matrix_2.java) : 注意找到特定的循环规律 **遵循循环不变量原则** ([detail](https://mp.weixin.qq.com/s/KTPhaeqxbMK9CxHUUgFDmg)) ([LC](https://leetcode.com/problems/spiral-matrix-ii/))

## LinkedList Operation

- [203 Remove LinkedList Elements](./LinkedList/203_remove_LinkedList_elements.java): 使用dummy head保持链表操作的一致性，避免单独处理head指针 ([detail](https://mp.weixin.qq.com/s/slM1CH5Ew9XzK93YOQYSjA)) ([LC](https://leetcode.com/problems/remove-linked-list-elements/))
- [707 Design LinkedList](./LinkedList/707_design_LinkedList.java): 可以使用dummy head也可以不使用 基础操作 可以画图弄清next关系 ([detail](https://mp.weixin.qq.com/s/Cf95Lc6brKL4g2j8YyF3Mg)) ([LC](https://leetcode.com/problems/design-linked-list/))
- [206 Reverse Linked List](./LinkedList/206_reverse_LinkedList.java): 使用一个pre 一个cur 依次修改next的方向 最后返回pre ([detail](https://mp.weixin.qq.com/s/pnvVP-0ZM7epB8y3w_Njwg)) ([LC](https://leetcode.com/problems/reverse-linked-list/))
- [141 LinkedList Cycle](./LinkedList/141_linkedlist_cycle.java): 使用一个慢指针/一个快指针, 慢的一次走一步, 快的一次两步, 如果能相遇说明一定有环 ([detail](https://www.cnblogs.com/grandyang/p/4137187.html)) ([LC](https://leetcode.com/problems/linked-list-cycle/)) 
- [142 LinkedList Cycle 2](./LinkedList/142_LinkedList_cycle_2.java): 先使用一个慢指针/一个快指针 从头寻找判断是否有环 如果有环再定义两个指针 一个从头节点开始 另一个从相遇节点开始 每个指针一次走一步 直到相遇则为环的入口节点 ([detail](https://mp.weixin.qq.com/s/_QVP3IkRZWx9zIpQRgajzA)) ([LC](https://leetcode.com/problems/linked-list-cycle-ii/))

## HashMap

- [242 Valid Anagram](./HashMap/242_valid_anagram.java): 使用字母-'a' 在26位数组中存储每个字母出现次数 好过哈希表 ([detail](https://mp.weixin.qq.com/s/vM6OszkM6L1Mx2Ralm9Dig)) ([LC](https://leetcode.com/problems/valid-anagram/))

- [349 Intersection of Two Arrays](./HashMap/349_intersection_of_two_arrays.java): 两个set去重, 动态数组存结果, list转array不要用toArray() ([detail](https://mp.weixin.qq.com/s/N9iqAchXreSVW7zXUS4BVA)) ([LC](https://leetcode.com/problems/intersection-of-two-arrays/))
- [202 Happy Number](./HashMap/202_happy_number.java): 用一个set记录是否有重复 ([detail](https://mp.weixin.qq.com/s/G4Q2Zfpfe706gLK7HpZHpA)) ([LC](https://leetcode.com/problems/happy-number/))

- [1 Two Sum](./HashMap/1_two_sum.java): 用HashMap存储值为key index 为 value ([detail](https://mp.weixin.qq.com/s/uVAtjOHSeqymV8FeQbliJQ)) ([LC](https://leetcode.com/problems/two-sum/))


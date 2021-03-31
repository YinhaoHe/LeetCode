'''

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Find maximum of minimum for every window size in a given array
https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
Given an integer array of size n, find the maximum of the minimum’s of every window size in the array. Note that window size varies from 1 to n.

'''

from collections import deque
def segment(x, arr):
    # Write your code here
    def maxSlidingWindow(nums, k):
        d = deque()
        out = []
        for i, n in enumerate(nums):
            while d and nums[d[-1]] < n:
                d.pop()
            d += i,
            if d[0] == i - k:
                d.popleft()
            if i >= k - 1:
                out += nums[d[0]],
        return out

    res = maxSlidingWindow(list(map(lambda x: -x, arr)), x)
    return -min(res)


def selection_sort(nums: list[int]) -> list[int]: #1
    for i in range (len(nums)-1): # n-1
        smallest = nums[i] # n-1
        smallest_index = i # n-1

        for j in range(i + 1, len(nums)): # (n(n-1)) /2
            if nums[j]<smallest: # (n(n-1)) /2
                smallest = nums[j] # best case 0, worst case (n(n-1)) /2
                smallest_index = j # best case 0, worst case (n(n-1)) /2

        nums[smallest_index] = nums[i] # n-1
        nums[i] = smallest # n-1
        
    return nums #1

# b)
# best case total: (n(n-1))/2 + 4(n-1) + 1     =   1/2 n**2 + 7/2 n - 3
# worst case total: 3* (n(n-2))/2 + 4(n-1) +1  =   3/2 n**2 + 5/2 n -3

# c)
# Upper bound: T(n) = O(n^2)
# Lower bound: T(n) = Omega(n^2)
# Tight bound / general runtime: Theta(n^2)


def main():

    nums = [5, 4, 3, 2, 1]
    print(nums)

    selection_sort(nums) 
    print(nums)
    

if __name__ == "__main__":
    main()
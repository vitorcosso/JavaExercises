// best way, its to use set.
// 24/10/2026
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int,Int>();
        
        for(num in nums){

            if(map.get(num) == null){
                map.put(num, 1)
                continue
            }

            var totalNow = map.get(num)!!

            if(totalNow < 2){
                totalNow = totalNow + 1
                map.put(num, totalNow)
                return true
            }
        }

        return false

    }
}

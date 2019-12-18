package easy.p703;

import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2){
            return o1 -o2;
        }

    });

    private int theK; 
    
    public KthLargest(int k, int[] nums) {
        if(nums.length >= k){
            for (int i = 0; i < k;i++){
                priorityQueue.add(nums[i]); 
            }
            for (int i = k; i < nums.length;i++){
                int min = priorityQueue.peek();
                if(nums[i] > min){
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }else{
            for (int i = 0; i < nums.length;i++){
                priorityQueue.add(nums[i]); 
            }
        }
        theK = k;
    }
    
    public int add(int val) {
        if(priorityQueue.size() < theK){
            priorityQueue.add(val);
        }else{
            int min = priorityQueue.peek();

            if(val > min){
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }
        return priorityQueue.peek();

    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
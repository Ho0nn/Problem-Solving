package meduim;

public class ProdArrExSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right= new int[nums.length];
        int[] product = new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
            System.out.println("left["+i+"]= "+left[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
            System.out.println("right["+i+"]= "+right[i]);
        }

        for(int i=0;i<nums.length;i++){
            product[i]=left[i]*right[i];
            System.out.println("product["+i+"]= "+product[i]);
        }
        return product;
    }

    //Improve Solution
    public int[] productExceptSelf2(int[] nums) {
        int len= nums.length;
        int[] product = new int[len];
        product[0]=1;
        for(int i=1;i<len;i++){
            product[i]=product[i-1]*nums[i-1];
          //  System.out.println("left["+i+"]= "+product[i]);
        }
        int r=1;
        for(int i=len-1;i>=0;i--){
            product[i]*=r;
            r*=nums[i];
         //   System.out.println("product["+i+"]= "+product[i]);
        }
        return product;
    }

    public static void main(String[] args) {
        ProdArrExSelf obj = new ProdArrExSelf();
        System.out.println(obj.productExceptSelf2(new int[]{-1,1,0,-3,3}));

    }

}

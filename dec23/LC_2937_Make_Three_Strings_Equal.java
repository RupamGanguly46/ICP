package dec23;

public class LC_2937_Make_Three_Strings_Equal {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        int maxPossibleLength = Math.min(l1, Math.min(l2, l3));

        int equalTill = 0;

        while(equalTill<maxPossibleLength){
            char c1 = s1.charAt(equalTill);
            char c2 = s2.charAt(equalTill);
            char c3 = s3.charAt(equalTill);

            if(c1!=c2 || c2!=c3){
                break;
            }

            equalTill++;
        }

        if(equalTill==0) return -1;

        int toRem1 = l1 - equalTill;
        int toRem2 = l2 - equalTill;
        int toRem3 = l3 - equalTill;

        return toRem1 + toRem2 + toRem3;
    }
}

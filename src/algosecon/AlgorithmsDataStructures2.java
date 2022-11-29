package algosecon;

import java.util.Arrays;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a) {
        Arrays.sort(a);
        int[] res = new int[a.length];
        res[0] = a[a.length / 2];
        makeBBDTArray(res, 0, Arrays.copyOf(a, a.length), 0, a.length-1);
        return res;
    }

    private static void makeBBDTArray(int[] res, int index, int[] src, int l, int h) {

        if (l > h)
            return;
        if(l==h){
            res[index] = src[l];
            return;
        }

        int mid = (l + h) / 2;
        res[index] = src[mid];

        makeBBDTArray(res, 2 * index + 1, src,l, mid-1 );
        makeBBDTArray(res, 2 * index + 2, src, mid+1, h);
    }
}

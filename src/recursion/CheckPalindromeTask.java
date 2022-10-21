package recursion;

public class CheckPalindromeTask {
    static boolean isPalindrome(String str,
                            int startIndex, int endIndex)
    {

        if (startIndex == endIndex)
            return true;

        if ((str.charAt(startIndex)) != (str.charAt(endIndex)))
            return false;

        if (startIndex < endIndex + 1)
            return isPalindrome(str, startIndex + 1, endIndex - 1);

        return true;
    }
}

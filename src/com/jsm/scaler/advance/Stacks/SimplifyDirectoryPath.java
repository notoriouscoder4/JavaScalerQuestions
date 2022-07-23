package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class SimplifyDirectoryPath {
    /*
    Given a string A representing an absolute path for a file (Unix-style).
    Return the string A after simplifying the absolute path.

    Note:

    In Unix-style file system:
    1. A period '.' refers to the current directory.
    2. A double period '..' refers to the directory up a level.
    3. Any multiple consecutive slashes '//' are treated as a single slash '/'.

    In Simplified Absolute path:
    1. The path starts with a single slash '/'.
    2. Any two directories are separated by a single slash '/'.
    3. The path doesn't end with trailing slashes '/'.
    4. The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
    5. Path will not have whitespace characters.

    Input Format
    The only argument given is string A.

    Output Format
    Return a string denoting the simplified absolute path for a file (Unix-style).

    For Example
    Input 1:
        A = "/home/"
    Output 1:
        "/home"

    Input 2:
        A = "/a/./b/../../c/"
    Output 2:
        "/c"
    */

    private static String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        String[] path = A.split("/");

        for (String p : path) {
            if (stack.size() > 0 && p.equals(".."))
                stack.pop();
            else if (!p.equals(".") && !p.equals("..") && !p.equals(""))
                stack.push(p);
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        String A = "/a/./b/../../c/";
        System.out.println(simplifyPath(A));
    }
}

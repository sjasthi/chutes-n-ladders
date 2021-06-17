/** Making some changes to JumpUtils for demo purpose */
package com.rezilience.chutesnladders.model;

import java.util.HashMap;
import java.util.Map;

public class JumpUtils {

    private static final int[] JUMP_FROM_LIST
            = new int[]{1, 4, 9, 16, 21, 28, 36, 47, 49, 51, 56, 62, 71, 80, 87, 93, 98};
    private static final int[] JUMP_TO_LIST
            = new int[]{38, 14, 31, 6, 42, 84, 44, 26, 11, 67, 53, 19, 91, 100, 24, 73, 78};
    private static final char[] JUMP_TYPE_LIST
            = new char[]{'L', 'L', 'L', 'C', 'L', 'L', 'L', 'C', 'C', 'L', 'C', 'C', 'L', 'L', 'C', 'C', 'C'};

    private static final Map<Character, JumpType> JUMP_TYPE_MAP;

    static {
        JUMP_TYPE_MAP = new HashMap<>();
        JUMP_TYPE_MAP.put('L', JumpType.LADDER);
        JUMP_TYPE_MAP.put('C', JumpType.CHUTE);
    }

  
    static Map<Integer, Jump> getStartBlockJumpMap() {
        Map<Integer, Jump> map = new HashMap<>();
        for (int i = 0; i < JUMP_FROM_LIST.length; i++) {
            Jump jump = new Jump();
            jump.setFromBlock(JUMP_FROM_LIST[i]);
            jump.setToBlock(JUMP_TO_LIST[i]);
            jump.setJumpType(JUMP_TYPE_MAP.get(JUMP_TYPE_LIST[i]));
            map.put(JUMP_FROM_LIST[i], jump);
        }
        return map;
    }
}

package com.rezilience.chutesnladders.model;

import lombok.Data;

@Data
public class Jump {
    private JumpType jumpType;
    private int fromBlock;
    private int toBlock;
}

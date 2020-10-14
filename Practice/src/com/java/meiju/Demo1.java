package com.java.meiju;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-11 20:17
 * @Modified By:
 */
public enum Demo1 {
    LOW(1),MEDIUM(50),HIGH(100);

    private  int  levelValue;

    private Demo1(int levelValue) {
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public void setLevelValue(int levelValue) {
        this.levelValue = levelValue;
    }
}

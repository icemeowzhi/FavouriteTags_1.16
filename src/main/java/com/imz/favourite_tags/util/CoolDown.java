package com.imz.favourite_tags.util;

/**
 * @author icemeowzhi
 * @date 2021/9/18
 * @apiNote
 */
public class CoolDown {
    boolean active = false;
    int nowCoolDown = 0;
    int coolDown = 6000;

    public CoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public CoolDown() {}

    public int getNowCoolDown() {
        return nowCoolDown;
    }

    public void setNowCoolDown(int nowCoolDown) {
        this.nowCoolDown = nowCoolDown;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public boolean isActive() {
        return active;
    }

    public void startCoolDown(){
        active = true;
        nowCoolDown = 0;
    }

    public void processCoolDown(){
        if (active){
            nowCoolDown++;
            if (nowCoolDown >= coolDown){
                active = false;
            }
        }else{
            if (nowCoolDown != 0){
                nowCoolDown = 0;
            }
        }
    }
}

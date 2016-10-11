package net.oschina.j2cache;

import java.io.Serializable;
import java.util.Date;

/**
 * 所获取的缓存对象
 *
 * @author winterlau
 */
public class CacheObject implements Serializable {

    private String region;
    private Object key;
    private Object value;
    private byte level;
    private long createTime = new Date().getTime();
    private long lastAccessTime = new Date().getTime();
    // alive time show
    private long aliveTime=0;
    private long expiredTime=0;  // value is second

    public CacheObject(){

    }

    public CacheObject(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public CacheObject(Object key, Object value, String region, int expiredTime) {
        this.key = key;
        this.value = value;
        this.expiredTime = expiredTime;
        this.region = region;
    }

    public CacheObject(Object key, Object value, int expiredTime) {
        this.key = key;
        this.value = value;
        this.expiredTime = expiredTime;
    }

    public CacheObject(String region, Object key, Object value, byte level) {
        this.region = region;
        this.key = key;
        this.value = value;
        this.level = level;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public long getAliveTime() {
        aliveTime=(new Date().getTime()-createTime);
        return aliveTime;
    }

    public void setAliveTime(long aliveTime) {
        this.aliveTime = aliveTime;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }
    public boolean isExpired(){
        if(expiredTime==0) return false;
        return getAliveTime()/1000 > expiredTime;
    }
}

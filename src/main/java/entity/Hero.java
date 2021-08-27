package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Big HandsomeMan
 * @date 2021-05-23 13:21:29
 */
public class Hero implements Serializable {
    /**
     * 主键递增id
     */
    private Integer id;
    /**
     *英雄名称
     */
    private String name;
    /**
     * 英雄头像
     */
    private String avatar;
    /**
     * 英雄类型
     */
    private Integer type;
    /**
     * 英雄技能
     */
    private String skill;
    /**
     * 技能描述
     */
    private String skillDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", skill='" + skill + '\'' +
                ", skillDescribe='" + skillDescribe + '\'' +
                '}';
    }
}

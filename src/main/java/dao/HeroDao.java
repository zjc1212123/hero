package dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import entity.Hero;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Big HandsomeMan
 * @date 2021-05-23 13:57:40
 */
public class HeroDao {
    /**
     * 根据id查找英雄
     */
    public Entity getHero(int id) {
        Entity hero = null;
        try {
            hero = Db.use().queryOne("select * from hero where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public static void main(String[] args) {
        HeroDao heroDao = new HeroDao();
        Hero hero = new Hero();
        hero.setName("1");
        hero.setAvatar("gbhjgjgh");
        hero.setType(1);
        hero.setSkill("111");
        hero.setSkillDescribe("尽快了解");
        System.out.println(heroDao.addHero(hero));
    }

    /**
     * 查询所有英雄
     */
    public List<Entity> listHero() {
        List<Entity> res = null;
        try {
            res = Db.use().findAll("hero");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 添加英雄
     */
    public boolean addHero(Hero hero) {
        boolean state = true;
        try {
            Db.use().insertForGeneratedKey(
                    Entity.create("hero")
                            .set("name", hero.getName())
                            .set("avatar", hero.getAvatar())
                            .set("type", hero.getType())
                            .set("skill", hero.getSkill())
                            .set("skill_describe", hero.getSkillDescribe())
            );
        } catch (SQLException e) {
            state = false;
            e.printStackTrace();
        }
        return state;
    }

    /**
     * 修改英雄
     */
    public boolean updateHero(Hero hero) {
        boolean state = true;
        try {
            Db.use().execute("update hero set name =? where id = ?", hero.getName(), hero.getId());
        } catch (SQLException e) {
            state = false;
            e.printStackTrace();
        }
        try {
            Db.use().execute("update hero set avatar =? where id = ?", hero.getAvatar(), hero.getId());
        } catch (SQLException e) {
            state = false;
            e.printStackTrace();
        }
        try {
            Db.use().execute("update hero set type =? where id = ?", hero.getType(), hero.getId());
        } catch (SQLException e) {
            state = false;
            e.printStackTrace();
        }
        try {
            Db.use().execute("update hero set skill =? where id = ?", hero.getSkill(), hero.getId());
        } catch (SQLException e) {
            state = false;
            e.printStackTrace();
        }
        try {
            Db.use().execute("update hero set skill_describe =? where id = ?", hero.getSkillDescribe(), hero.getId());
        } catch (SQLException e) {
            state = false;
            e.printStackTrace();
        }

        return state;
    }

    /**
     * 删除英雄
     */
    public boolean deleteHero(int id) {
        boolean state = true;
        try {
            Db.use().execute("delete from hero where id = ?", id);
        } catch (SQLException e) {
            state = false;
            e.printStackTrace();
        }
        return state;
    }
}

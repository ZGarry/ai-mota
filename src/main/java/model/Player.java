package model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {
    private int atk;
    private int def;
    private int hp;
    private int shield;

    private List<String> items = new ArrayList<String>();

    public boolean fight(Monster monster) {
        //  跳过式战斗
        int playerAtkPerTurn = this.atk - monster.getDef();
        //  无法造成伤害
        if (playerAtkPerTurn <= 0) {
            return false;
        }

        //  怪物伤害
        int monsterAtkPerTurn = monster.getAtk() - this.def;
        if (monster.getSkill().equals(MotaConstant.二连击)) {
            monsterAtkPerTurn *= 2;
        }
        if (monster.getSkill().equals(MotaConstant.魔攻)) {
            monsterAtkPerTurn = monster.getAtk();
        }


        // 玩家攻击回合数
        int playerAtkTimes = monster.getHp() / playerAtkPerTurn;
        if (monster.getHp() % playerAtkPerTurn > 0) {
            playerAtkTimes += 1;
        }
        // 怪物攻击次数
        int monsterAtkTimes = playerAtkTimes - 1;
        if (monster.getSkill().equals(MotaConstant.先攻)) {
            monsterAtkTimes += 1;
        }

        // 玩家受到伤害
        int playerAcceptDamage = monsterAtkTimes * monsterAtkPerTurn;
        // 护盾
        playerAcceptDamage = playerAcceptDamage - shield;
//        没有伤害
        if (playerAcceptDamage == 0) {
            return true;
        }

        // 扣血
        if (this.hp > playerAcceptDamage) {
            this.hp -= playerAcceptDamage;
            return true;
        } else {
            return true;
        }
    }
}

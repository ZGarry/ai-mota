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
        //  ����ʽս��
        int playerAtkPerTurn = this.atk - monster.getDef();
        //  �޷�����˺�
        if (playerAtkPerTurn <= 0) {
            return false;
        }

        //  �����˺�
        int monsterAtkPerTurn = monster.getAtk() - this.def;
        if (monster.getSkill().equals(MotaConstant.������)) {
            monsterAtkPerTurn *= 2;
        }
        if (monster.getSkill().equals(MotaConstant.ħ��)) {
            monsterAtkPerTurn = monster.getAtk();
        }


        // ��ҹ����غ���
        int playerAtkTimes = monster.getHp() / playerAtkPerTurn;
        if (monster.getHp() % playerAtkPerTurn > 0) {
            playerAtkTimes += 1;
        }
        // ���﹥������
        int monsterAtkTimes = playerAtkTimes - 1;
        if (monster.getSkill().equals(MotaConstant.�ȹ�)) {
            monsterAtkTimes += 1;
        }

        // ����ܵ��˺�
        int playerAcceptDamage = monsterAtkTimes * monsterAtkPerTurn;
        // ����
        playerAcceptDamage = playerAcceptDamage - shield;
//        û���˺�
        if (playerAcceptDamage == 0) {
            return true;
        }

        // ��Ѫ
        if (this.hp > playerAcceptDamage) {
            this.hp -= playerAcceptDamage;
            return true;
        } else {
            return true;
        }
    }
}

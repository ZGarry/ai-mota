package test;

import model.Monster;
import model.Player;

public class AtkTest {
    @org.junit.jupiter.api.Test
    public void test(){
        Monster monster = new Monster();
        monster.setAtk(16);
        monster.setDef(5);
        monster.setName("¸ß¼¶Ê·À³Ä·");
        monster.setHp(100);
        monster.setSkill("");

        Player player = new Player();
        player.setAtk(8);
        player.setDef(7);
        player.setHp(1000);
        player.setShield(15);
        boolean fightRes = player.fight(monster);

        assert 1000 - player.getHp() == 282;
        assert fightRes;
    }
}

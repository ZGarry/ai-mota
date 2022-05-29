package model;


import lombok.Data;

@Data
public class Monster {
  private String name;
  private int atk;
  private int def;
  private int hp;

    /**
     * 目前都是单skill，使用字符串表示
     */
  private String skill;

  public void fight(){

  }
}

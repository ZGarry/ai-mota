package model;


import lombok.Data;

@Data
public class Monster {
  private String name;
  private int atk;
  private int def;
  private int hp;

    /**
     * Ŀǰ���ǵ�skill��ʹ���ַ�����ʾ
     */
  private String skill;

  public void fight(){

  }
}

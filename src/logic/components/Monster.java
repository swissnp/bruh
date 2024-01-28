package logic.components;

import exception.BadStatusException;

public class Monster {
  private String name;
  private Status status;
  private Food food;
  private Potion potion;

  public Monster(String name, Status status) {
    this.name = name;
    try {
      this.status = new Status(Math.max(1, status.getHp()), status.getDurability(), status.getAttack(),
          status.getMagic());
    } catch (BadStatusException e) {
      e.printStackTrace();
    }
    this.food = null;
    this.potion = null;
  }

  public void attack(Player player) {
    try {
      int damage = Math.max(0, this.status.getAttack() - player.getStatus().getDurability());
      player.getStatus().setHp(Math.max(0, player.getStatus().getHp() - damage));
    } catch (BadStatusException e) {
      e.printStackTrace();
    }
  }

  public void magicAttack(Player player) {
    try {
      player.getStatus().setHp(Math.max(0, player.getStatus().getHp() - this.status.getMagic()));
    } catch (BadStatusException e) {
      e.printStackTrace();
    }
  }

  public String getName() {
    return this.name;
  }

  public Status getStatus() {
    return this.status;
  }

  public Food getFood() {
    return this.food;
  }

  public Potion getPotion() {
    return this.potion;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public void setPotion(Potion potion) {
    this.potion = potion;
  }

}

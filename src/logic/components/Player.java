package logic.components;

import java.util.ArrayList;

import exception.BadStatusException;

public class Player {
  private String name;
  private Status status;
  private int energy;
  private int money;
  private ArrayList<Food> foods;
  private ArrayList<Potion> potions;
  private ArrayList<Ore> ores;

  static final int MIN_ENERGY = 0;
  static final int MIN_MONEY = 0;

  public Player(String name, Status status) {
    this.name = name;
    try {
      this.status = new Status(Math.max(1, status.getHp()), status.getDurability(), status.getAttack(),
          status.getMagic());
    } catch (BadStatusException e) {
      e.printStackTrace();
    }
    this.energy = 10;
    this.money = 100;
    this.foods = new ArrayList<Food>();
    this.potions = new ArrayList<Potion>();
    this.ores = new ArrayList<Ore>();
  }

  public Player(String name, Status status, int energy, int money) {
    this.name = name;
    try {
      this.status = status.getHp() < 1 ? new Status(1, status.getDurability(), status.getAttack(), status.getMagic())
          : status;
    } catch (BadStatusException e) {
      e.printStackTrace();
    }
    this.energy = energy < MIN_ENERGY ? MIN_ENERGY : energy;
    this.money = money < MIN_MONEY ? MIN_MONEY : money;
    this.foods = new ArrayList<Food>();
    this.potions = new ArrayList<Potion>();
    this.ores = new ArrayList<Ore>();
  }

  public boolean buyOre(Ore ore) {
    if (this.money >= ore.getCost()) {
      this.money -= ore.getCost();
      this.ores.add(ore);
      return true;
    } else {
      return false;
    }
  }

  public void drinkPotion(int index) {
    try {
      try {
        this.status.setHp(this.status.getHp() + this.potions.get(index).getIncreasingStatus().getHp());
        this.status.setDurability(
            this.status.getDurability() + this.potions.get(index).getIncreasingStatus().getDurability());
        this.status.setAttack(this.status.getAttack() + this.potions.get(index).getIncreasingStatus().getAttack());
        this.status.setMagic(this.status.getMagic() + this.potions.get(index).getIncreasingStatus().getMagic());
        this.potions.remove(index);
      } catch (BadStatusException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bound");
    }
  }

  public void eatFood(int index) {
    try {
      this.energy = this.energy + this.foods.get(index).getEnergy();
      this.foods.remove(index);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index out of bound");
    }
  }

  public void sellPotion(int index) {
    if (index >= 0 && index < this.potions.size()) {
      this.money += this.potions.get(index).getPrice();
      this.potions.remove(index);
    } else {
      System.out.println("Invalid index");
    }
  }

  public void sellFood(int index) {
    if (index >= 0 && index < this.foods.size()) {
      this.money += this.foods.get(index).getPrice();
      this.foods.remove(index);
    } else {
      System.out.println("Invalid index");
    }
  }

  public void attack(Monster monster) {
    try {
      int damage = Math.max(0, this.status.getAttack() - monster.getStatus().getDurability());
      monster.getStatus().setHp(
          Math.max(monster.getStatus().getHp() - damage, 0));
    } catch (BadStatusException e) {
      e.printStackTrace();
    }
  }

  public Status getStatus() {
    return this.status;
  }

  public int getEnergy() {
    return this.energy;
  }

  public int getMoney() {
    return this.money;
  }

  public ArrayList<Food> getFoods() {
    return this.foods;
  }

  public ArrayList<Potion> getPotions() {
    return this.potions;
  }

  public ArrayList<Ore> getOres() {
    return this.ores;
  }

  public String getName() {
    return this.name;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setEnergy(int energy) {
    this.energy = Math.max(energy, MIN_ENERGY);
  }

  public void setMoney(int money) {
    this.money = Math.max(money, MIN_MONEY);
  }

  public void setFoods(ArrayList<Food> foods) {
    this.foods = foods;
  }

  public void setPotions(ArrayList<Potion> potions) {
    this.potions = potions;
  }

  public void setOres(ArrayList<Ore> ores) {
    this.ores = ores;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void magicAttack(Monster monster) {
    try {
      monster.getStatus().setHp(Math.max(monster.getStatus().getHp() - this.status.getMagic(), 0));
    } catch (BadStatusException e) {
      e.printStackTrace();
    }
  }
}

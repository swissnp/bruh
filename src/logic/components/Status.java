package logic.components;

import exception.BadStatusException;

public class Status {
  private int hp;
  private int durable;
  private int attack;
  private int magic;

  public int getHp() {
    return this.hp;
  }

  public int getDurability() {
    return this.durable;
  }

  public int getAttack() {
    return this.attack;
  }

  public int getMagic() {
    return this.magic;
  }

  public void setHp(int hp) throws BadStatusException {
    if (hp < 0) {
      throw new BadStatusException();
    }
    this.hp = hp;
  }

  public void setMagic(int magic) throws BadStatusException {
    if (magic < 0) {
      throw new BadStatusException();
    }
    this.magic = magic;
  }

  public void setAttack(int attack) throws BadStatusException {
    if (attack < 0) {
      throw new BadStatusException();
    }
    this.attack = attack;
  }

  public void setDurability(int durable) throws BadStatusException {
    if (durable < 0) {
      throw new BadStatusException();
    }
    this.durable = durable;
  }

  public Status(int hp, int durable, int attack, int magic) throws BadStatusException {
    this.setHp(hp);
    this.setDurability(durable);
    this.setAttack(attack);
    this.setMagic(magic);
  }

  public boolean equals(Status status) {
    return this.hp == status.hp && this.durable == status.durable && this.attack == status.attack
        && this.magic == status.magic;
  }

  public void addStatus(Status status) throws BadStatusException {
    this.setHp(this.getHp() + status.getHp());
    this.setDurability(this.getDurability() + status.getDurability());
    this.setAttack(this.getAttack() + status.getAttack());
    this.setMagic(this.getMagic() + status.getMagic());
  }
}

package pokemon;

class Pokemon {
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int speed;
    private int level;
    private Type[] types;
    private Move[] moves;

    public Pokemon(String name, int hp, int atk, int def, int spAtk, int spDef, int speed, int level, Type[] types, Move[] moves) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
        this.level = level;
        this.types = types;
        this.moves = moves;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return this.def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpAtk() {
        return this.spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return this.spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public Type[] getTypes() {
        return this.types;
    }

    public void setTypes(Type[] types) {
        this.types = types;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Move[] getMoves() {
        return this.moves;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    public boolean hasType(Type type) {
        for(Type t : this.types) {
            if(t.equals(type)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s [Level %d] - %d HP", this.name, this.level, this.hp);
    }
}
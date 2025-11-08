package pokemon;

class Move implements Comparable<Move> {
    private String name;
    private int power;
    private Type type;
    private int pp;
    private int accuracy;

    public Move(String name, int power, Type type, int pp, int accuracy) {
        this.name = name;
        this.power = power;
        this.type = type;
        this.pp = pp;
        this.accuracy = accuracy;
    }

    public Move(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPp() {
        return this.pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public boolean canUse() {
        return this.pp > 0;
    }

    public void use() {
        this.pp -= 1;
        if(this.pp < 0) {
            this.pp = 0;
        }
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return String.format("%s - %dPP", this.name, this.pp);
    }

    @Override
    public int compareTo(Move other) {
        return this.name.compareTo(other.name);
    }
}
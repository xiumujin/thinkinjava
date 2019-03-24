package prototype.expansion;

class Square implements Shape {
    public Object clone() {
        Square b = null;
        try {
            b = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝正方形失败!");
        }
        return b;
    }

    public void countArea() {
        int a = 7;
        System.out.println("该正方形的面积=" + a * a + "\n");
    }
}
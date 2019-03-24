package prototype.expansion;

class Circle implements Shape {
    public Object clone() {
        Circle w = null;
        try {
            w = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆失败!");
        }
        return w;
    }

    public void countArea() {
        int r = 7;
        System.out.println("该圆的面积=" + 3.1415 * r * r + "\n");
    }
}
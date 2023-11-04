public class Shape{
    public void draw(){
        System.out.println("Menggambar Bentuk Umum");
    }
    public double calculateArea(){
        System.out.println("Menghitung Luas Bentuk Umum.");
        return 0;
    }
}

public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public void draw(){
        System.out.println("Menggambar Lingkaran Dengan Radius " + radius);
    }

    public double calculateArea(){
        return Math.PI * radius * radius;
    }
}

public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw(){
        System.out.println("Draw the triangle with base " + base + " and height " + height);
    }

    public double calculateArea(){
        return base * height / 2;
    }
}

public class Rectangle extends Shape{
    private double Length;
    private double width;

    public Rectangle(double length, double width){
        this.Length = length;
        this.width = width;
    }

    @Override
    public void draw(){
        System.out.println("Menggambar Persegi Panjang Dengan Panjang " + Length + " Dan Lebar " + width);
    }
    public double calculateArea(){
        return Length = width;
    }
}

public class Main{
    public static void main(String[] args){
        Shape[] shape = new Shape[3];
        shape[0] = new Circle(5.0);
        shape[1] = new Rectangle(4.0, 6.0);
        shape[2] = new Triangle(5, 6);

        for (Shape shapes : shape){
            shapes.draw();
            double area = shapes.calculateArea();
            System.out.println("Luas : " + area);
            System.out.println();
        }


    }
}

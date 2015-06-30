/**
 * Created by Alinka on 24.02.2015.
 */
public class App {
    public static void main(String[] args){

        double[][] a = { { 1, 11, 11 }, { 14, 7, 5 }, { 7, 8, 0 } };
        double[][] b = { { 5, 6, 7 }, { 8, 9, 10 }, { 1, 2, 3 } };
        double[][] c = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 7, 8, 0, 1 }, {2, 3, 4, 5} };
        double[][] d = { { 5, 6, 7, 8 }, { 8, 9, 10, 11 }, { 1, 2, 3, 4 }, {1, 1, 1, 1} };

        AbstractMatrix matrix1 = new MatrixTwoD(a);
        AbstractMatrix matrix2 = new MatrixTwoD(b);
        AbstractMatrix matrix6 = new MatrixTwoD(c);
        AbstractMatrix matrix7 = new MatrixTwoD(d);

        AbstractMatrix matrix4 = new MatrixOneD(a);
        AbstractMatrix matrix5 = new MatrixOneD(b);
        AbstractMatrix matrix8 = new MatrixOneD(c);
        AbstractMatrix matrix9 = new MatrixOneD(d);



        System.out.println("Matrix 3x3");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(matrix1.toString()+ "\n" + matrix2.toString());
        System.out.println("Multiply of matrixs with MatrixTwoD:\n" + matrix1.multiplyMatrix(matrix2).toString());
        System.out.println("Determinant: " + matrix1.detMatrix());
        System.out.println("Inverse matrix:\n" + matrix1.invertMatrix());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Multiply of matrixs with MatrixOneD:\n" + matrix4.multiplyMatrix(matrix5).toString());
        System.out.println("Determinant: " + matrix4.detMatrix());
        System.out.println("Inverse matrix:\n" + matrix4.invertMatrix());
        System.out.println("Matrix 4x4");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Multiply of matrixs with MatrixTwoD:\n" + matrix6.multiplyMatrix(matrix7).toString());
        System.out.println("Determinant: " + matrix7.detMatrix());
        System.out.println("Inverse matrix:\n" + matrix7.invertMatrix());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Multiply of matrixs with MatrixOneD:\n" + matrix8.multiplyMatrix(matrix9).toString());
        System.out.println("Determinant: " + matrix8.detMatrix());
        System.out.println("Inverse matrix:\n" + matrix8.invertMatrix());


    }
}

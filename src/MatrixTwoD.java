/**
 * Created by Alinka on 01.03.2015.
 */
public class MatrixTwoD extends AbstractMatrix {

    public double[][] matrixTwoD;


    public MatrixTwoD(double[][] matrixTwoD) {
        this.matrixTwoD = matrixTwoD;
        size = matrixTwoD.length;
    }

    @Override
    public void setElement(int i, int j, double b) {
        matrixTwoD[i][j] = b;
    }

    @Override
    public double getElement(int i, int j) {
        return matrixTwoD[i][j];
    }

    @Override
    public double[] getRow(int i) {
        return matrixTwoD[i];
    }

    @Override
    public MatrixTwoD createMatrix(double[][] m) {
        return new MatrixTwoD(m);
    }
}

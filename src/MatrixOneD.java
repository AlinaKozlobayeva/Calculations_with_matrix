/**
 * Created by Alinka on 01.03.2015.
 */
public class MatrixOneD extends AbstractMatrix {

    public double[] matrixOneD;

    public MatrixOneD(double[] a) {
        this.matrixOneD = a;
        size = matrixOneD.length;
    }

    public MatrixOneD(double[][] a) {
        size = a[0].length;
        double[] result = new double[size*size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i + j*size] = a[i][j];
            }
        }
        this.matrixOneD = result;
    }

    @Override
    public void setElement(int i, int j, double b) {
        matrixOneD[size*j + i] = b;
    }

    @Override
    public double getElement(int i, int j) {
        return matrixOneD [size*j + i];
    }

    @Override
    public double[] getRow(int j) {
        double[] result = new double[size];
        for (int k = 0; k < size; k++) {
            result[k] = matrixOneD[size*k + j];
        }
        return result;
    }

    @Override
    public MatrixOneD createMatrix(double[][] m) {
        return new MatrixOneD(m);
    }

}

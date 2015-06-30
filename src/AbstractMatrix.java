/**
 * Created by Alinka on 24.02.2015.
 */
public abstract class AbstractMatrix {
    protected int size;

    public int getSize() {
        return size;
    }

    public abstract void setElement(int i, int j, double b);

    public abstract double getElement(int i, int j);

    public abstract double[] getRow(int i);

    public abstract AbstractMatrix createMatrix(double[][] m);

    public AbstractMatrix multiplyByNum(double d){

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.setElement(i, j, this.getElement(i,j)*(d));
            }
        }
        return this;
    }


    public AbstractMatrix multiplyMatrix(AbstractMatrix matrix2){
        double[][] matrix3 = new double[size][size];
        int i,j,k;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                matrix3[i][j] = 0.0;
            }
        }
        for(i=0;i<size;i++) {
            for (j = 0; j < size; j++) {
                for (k = 0; k < size; k++) {
                    matrix3[i][j] += (this.getElement(i, k) * matrix2.getElement(k, j));
                }
            }
        }
        return createMatrix(matrix3);
    }


    public double detMatrix(){
            if(this.getSize()==1){
                return this.getElement(0, 0);
            } else {
                double det = 0.0;
                for(int j = 0; j < this.getSize(); j++){
                    det += Math.pow(-1,j)*this.getElement(0, j)*this.minor(0, j).detMatrix();
                }
                return det;
            }
    }

    protected AbstractMatrix minor( int i, int j) {
        double[][] minor = new double[size - 1][size - 1];
        int r = 0;
        int s = 0;
        for (int k = 0; k < size; k++) {
            double[] row = this.getRow(k);
            if (k != i) {
                for (int l = 0; l < row.length; l++) {
                    if (l != j) {
                        minor[r][s++] = row[l];
                    }
                }
                r++;
                s = 0;
            }

        }

        return createMatrix(minor);
    }

    protected AbstractMatrix transponseMatrix(){
        double[][] trMatrix = new double[size][size];
        for(int i = 0; i < size; i++){
            for (int j = 0; j< size; j++){
                trMatrix[j][i] = this.getElement(i, j);
            }
        }
        return createMatrix(trMatrix);
    }

    public AbstractMatrix invertMatrix(){
        double d = this.detMatrix();
        if (d == 0){
            System.out.println("Inverse matrix does not exist");
            return null;
        }
        double[][] temp = new double[size][size];
        for (int k = 0; k < this.getSize(); k++) {
            for (int l = 0; l < this.getSize(); l++) {
                temp[k][l] = minor(k,l).detMatrix();

            }
        }
        return (createMatrix(temp).transponseMatrix().multiplyByNum(1.0/d));

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(String.format("%9.5f ", getElement(i, j)));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}

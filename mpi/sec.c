#include <stdio.h>
#include <math.h>
#include <mpi.h>

int main(int argc, char **argv)
{
    int myid, numprocs;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &numprocs);
    MPI_Comm_rank(MPI_COMM_WORLD, &myid);
    if (myid == 0)
    {
        printf("Hola!!\n");
    }

    int suma = 0;
    for (int i = 1; i <= 1000; i++)
    {
        suma = suma + i;
    }
    if (myid == 0)
    {
        printf("La suma de 1 a 1000 es : %d\n", suma);
        printf("de un total de %d \n", numprocs);
    }
    MPI_Finalize();
    return 0;
}
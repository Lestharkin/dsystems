#include <stdio.h>
#include <math.h>
#include <mpi.h>

int main(int argc, char **argv)
{
    int minodo, totalnodos;
    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &totalnodos);

    MPI_Comm_rank(MPI_COMM_WORLD, &minodo);
    printf("Estoy en el procesador %d", minodo);
    printf("de un total de %d \n", totalnodos);
    MPI_Finalize();
}